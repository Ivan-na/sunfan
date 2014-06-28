package com.sunfan.monitor.manager.pool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

import com.sun.org.apache.xml.internal.utils.ObjectPool;
import com.sunfan.monitor.manager.IConnectionPool;
import com.sunfan.monitor.platform.IConnectable;
@Component
public class LinuxConnectionPool implements IConnectionPool {
	 Logger logger = (Logger) LoggerFactory.getLogger(LinuxConnectionPool.class);
	 private Map<String,IConnectable> connectionPool ;
	 
	 public LinuxConnectionPool() {
		 connectionPool = new HashMap<String,IConnectable>();
	}
	 
	 /**
	  * save connecion in the connectionPool,if conn is already exist return false else return true
	  * 
	  * @param conn
	  * @return
	  */
	 public synchronized Boolean saveObject(IConnectable conn){
		 String key = rewardConnectionKey(conn);
		 if(isExist(key)){
			 logger.info("this key"+ key +" has already exist");
			 return false;
		 }
		 connectionPool.put(key,conn);
		 return true;
	 }
	 
	 /**
	  * borrow connection object in the connect-pool 
	  * 
	  * @param key
	  * @return
	  */
	 public IConnectable borrowObject(String key){
		 if(!isExist(key)){
			 return null;
		 }
		 return connectionPool.get(key);
	 }
	 /**borrow connection object in the connect-pool 
	  * if the connection hasn't in the connectionPool return null,else return connect object
	  * 
	  * @param conn 
	  * @return
	  */
	 public IConnectable borrowObject(IConnectable conn){
		 String key = rewardConnectionKey(conn);
		 return borrowObject(key);
	 }
	 
	 
	 /**
	  * close single connection in the connection-pool and  close/release of this connection  
	  * @param conn
	 * @throws IOException 
	  */
	 public void remove(IConnectable conn) throws IOException{
		 String key = rewardConnectionKey(conn);
		 remove(key);
	 }
	 
	 /**
	  * close single connection in the connection-pool and  close/release of this connection  
	  * @param conn
	 * @throws IOException 
	  */
	 public synchronized void remove(String key) throws IOException{
		 if(!isExist(key)){
			throw new NullPointerException(key+"is not exist");
		 }
		 connectionPool.get(key).close();
		 connectionPool.remove(key);
	 }
	 
	 /**
	  * delete every connection in the connection-pool and also close/release of all connection  
	  * @throws IOException
	  */
	 public void clear() throws IOException{
		 Iterator<String> it = connectionPool.keySet().iterator();
		 while(it.hasNext()){
			 String key = it.next();
			 IConnectable conn = connectionPool.get(key);
			 conn.close();
		 }
		 connectionPool.clear();
	 }
	 
	 /**
	  * according to the connection to generate key
	  * if the connecion is not equal null return url/usr/password
	  * @param conn
	  * @return
	  */
	 public String rewardConnectionKey(IConnectable conn){
		 return conn.getUrl()+"/"+conn.getUser()+"/"+conn.getPassword();
	 }
	 
	 public String rewardConnectionKey(String url,String user,String password){
		 return url+"/"+user+"/"+password;
	 }
	 
	 
	 
	 /**
	  * To confirm whether the connectionPool has this key
	  * if already has return true
	  * else return false
	  * 
	  * @param key
	  * @return
	  */
	 public Boolean isExist(String key){
		 if(connectionPool.containsKey(key))
		     return true;
		 return false;
	 }

}
