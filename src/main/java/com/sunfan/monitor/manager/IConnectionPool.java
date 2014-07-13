package com.sunfan.monitor.manager;

import java.io.IOException;

import com.sunfan.monitor.platform.IConnectable;
/**
 * 
 * @author sunfan
 *
 */
public interface IConnectionPool {
	
	 public Boolean saveObject(IConnectable conn);
	 
	 /**
	  * borrow connection object in the connect-pool 
	  * 
	  * @param key
	  * @return
	  */
	 public IConnectable borrowObject(String key);
	 /**borrow connection object in the connect-pool 
	  * if the connection hasn't in the connectionPool return null,else return connect object
	  * 
	  * @param conn 
	  * @return
	  */
	 public IConnectable borrowObject(IConnectable conn);
	 
	 
	 /**
	  * close single connection in the connection-pool and  close/release of this connection  
	  * @param conn
	 * @throws IOException 
	  */
	 public void remove(IConnectable conn) throws IOException;
	 public void remove(String key) throws IOException;
	 
	 /**
	  * delete every connection in the connection-pool and also close/release of all connection  
	  * @throws IOException
	  */
	 public void clear() throws IOException;
}
