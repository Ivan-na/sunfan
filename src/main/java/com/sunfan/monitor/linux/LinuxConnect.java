package com.sunfan.monitor.linux;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.sunfan.monitor.IConnect;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.Session;

public class LinuxConnect implements IConnect {
	Logger logger = (Logger) LoggerFactory.getLogger(LinuxConnect.class);
	String url, user, password;
	Connection con;
	Session session;

	/**
	 * init server's connect
	 * 
	 * @param url
	 * @param user
	 * @param password
	 */
	LinuxConnect(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * this method will establish connection unless username or password
	 * incorrect and remote server is not find
	 * 
	 * @return connection
	 * @throws IOException
	 */
	public Connection getConnection() throws IOException {
		con = new Connection(url);
		ConnectionInfo info = con.connect(); // establish connection
		if (false == con.authenticateWithPassword(user, password))
			logger.error("connect server failed,please check the username and password. "+this.user+" "+this.password);
		return con;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Session getSesion() throws IOException {
		con = getConnection();
		session = con.openSession();
		return session;
	}

	/**
	 * close session and connect
	 */
	public void closeAll() {
		this.con.close();
		this.session.close();
	}

	/**
	 * only close connection
	 */
	public void closeConnection() {
		this.con.close();
	}

	/**
	 * only close session
	 */
	public void closeSession() {
		this.session.close();
	}

}
