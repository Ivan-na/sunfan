package com.sunfan.monitor.manager.pool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sunfan.monitor.manager.IConnectionPool;
import com.sunfan.monitor.platform.IConnectable;
import com.sunfan.monitor.platform.linux.LinuxConnect;

@Component
public class LinuxConnectionPool implements IConnectionPool {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private Map<String, IConnectable> connectionPool = new HashMap<String, IConnectable>();

	/**
	 * save connecion in the connectionPool,if conn is already exist return
	 * false else return true
	 * 
	 * @param conn
	 * @return
	 */
	public synchronized Boolean saveObject(IConnectable conn) {
		String key = rewardConnectionKey(conn);
		if (isExist(key)) {
			logger.info("this key{} has already exist", key);
			return false;
		}
		connectionPool.put(key, conn);
		return true;
	}

	/**
	 * borrow connection object in the connect-pool
	 * 
	 * @param key
	 * @return
	 */
	public IConnectable borrowObject(String key) {
		if (!isExist(key)) {
			throw new IllegalArgumentException("key not found:" + key);
		}
		return connectionPool.get(key);
	}
	
	public IConnectable borrowObject(String url,String user,String password){
		String key = this.rewardConnectionKey(url, user, password);
		if (!isExist(key)){
			try {
				LinuxConnect connect = new LinuxConnect(url, user, password);
				connectionPool.put(key, connect);
				return connect;
			} catch (IOException e) {
				throw new RuntimeException("异常"+url,e);
			}
		}else {
			return connectionPool.get(key);
		}
		
	}

	/**
	 * borrow connection object in the connect-pool if the connection hasn't in
	 * the connectionPool return null,else return connect object
	 * 
	 * @param conn
	 * @return
	 */
	public IConnectable borrowObject(IConnectable conn) {
		String key = rewardConnectionKey(conn);
		return borrowObject(key);
	}

	/**
	 * close single connection in the connection-pool and close/release of this
	 * connection
	 * 
	 * @param conn
	 * @throws IOException
	 */
	public void remove(IConnectable conn) throws IOException {
		String key = rewardConnectionKey(conn);
		remove(key);
	}

	/**
	 * close single connection in the connection-pool and close/release of this
	 * connection
	 * 
	 * @param conn
	 * @throws IOException
	 */
	public synchronized void remove(String key) throws IOException {
		if (!isExist(key)) {
			throw new IllegalArgumentException(key + "is not exist");
		}
		connectionPool.get(key).close();
		connectionPool.remove(key);
	}

	/**
	 * delete every connection in the connection-pool and also close/release of
	 * all connection
	 * 
	 * @throws IOException
	 */
	public void clear() throws IOException {
		for (String keyString : connectionPool.keySet()) {
			connectionPool.get(keyString).close();
		}
		connectionPool.clear();
	}

	/**
	 * according to the connection to generate key if the connecion is not equal
	 * null return url/usr/password
	 * 
	 * @param conn
	 * @return
	 */
	public String rewardConnectionKey(IConnectable conn) {
		return conn.getUrl() + "/" + conn.getUser() + "/" + conn.getPassword();
	}

	public String rewardConnectionKey(String url, String user, String password) {
		return url + "/" + user + "/" + password;
	}

	/**
	 * To confirm whether the connectionPool has this key if already has return
	 * true else return false
	 * 
	 * @param key
	 * @return
	 */
	public Boolean isExist(String key) {
		return connectionPool.containsKey(key);
	}

}
