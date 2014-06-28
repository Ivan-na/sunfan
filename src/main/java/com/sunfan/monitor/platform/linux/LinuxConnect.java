package com.sunfan.monitor.platform.linux;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.sunfan.monitor.platform.IConnectable;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.ConnectionMonitor;

public class LinuxConnect implements IConnectable ,Closeable{
	Logger logger = (Logger) LoggerFactory.getLogger(LinuxConnect.class);
	private String url, user, password;
	private Connection connection;

	/**
	 * init server's connect
	 * 
	 * @param url
	 * @param user
	 * @param password
	 * @throws IOException 
	 */
	public LinuxConnect(String url, String user, String password) throws IOException {
		this.url = url;
		this.user = user;
		this.password = password;
		this.connection=createConnection();
	}

	/**
	 * this method will establish connection unless username or password
	 * incorrect and remote server is not find
	 * 
	 * @return connection
	 * @throws IOException
	 */
	private Connection createConnection() throws IOException {
		connection = new Connection(url);
		ConnectionInfo info = connection.connect(); // establish connection
		if (false == connection.authenticateWithPassword(user, password))
			logger.error("connect server failed,please check the username and password. "+this.user+" "+this.password);
		return connection;
	}

	/**
	 * close connection
	 */
	@Override
	public void close() throws IOException {
		if(connection!=null)
		    this.connection.close();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	


}
