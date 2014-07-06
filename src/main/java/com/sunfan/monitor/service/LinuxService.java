package com.sunfan.monitor.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.platform.IConnectable;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;

@Component
public class LinuxService {
	private  String defaultTopComand = "top -b -n 1";
	private  String defaultMpstatComand = "mpstat -P ALL";
	private  String defaultFreeCommand = "free -m";
	@Autowired
	private LinuxConnectionPool pool ;
	@Autowired
	private LinuxSessionHandle handle;
	
	/**
	 * execute default command "top -b -n 1" and return String type reslut
	 * 
	 * @param url  server's ip 
	 * @param user  login name 
	 * @param password login password
	 * @return
	 * @throws IOException
	 */
	public String topMonitor(String url,String user,String password) throws IOException{
		return this.executeCommand(url, user, password, defaultTopComand);
	}
	
	/**
	 * execute default command "mpstat -P ALL" to get cpus performance 
	 * 
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public String cpuMonitor(String url,String user,String password) throws IOException{
		return this.executeCommand(url, user, password, defaultMpstatComand);
	}
	
	/**
	 * execute default command "free -m" to get memory performance 
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public String memoryMonitor(String url,String user,String password) throws IOException{
		return this.executeCommand(url, user, password, defaultFreeCommand);
	}
	
	public String executeCommand(String url,String user,String password,String command) throws IOException{
		IConnectable lc =  pool.borrowObject(url,user,password);
		return handle.executeCommand(lc.getConnection(),command);
	}
	
	

	public LinuxConnectionPool getPool() {
		return pool;
	}
	public void setPool(LinuxConnectionPool pool) {
		this.pool = pool;
	}
	
	public String getDefaultMpstatComand() {
		return defaultMpstatComand;
	}

	public void setDefaultMpstatComand(String defaultMpstatComand) {
		this.defaultMpstatComand = defaultMpstatComand;
	}

	public LinuxSessionHandle getHandle() {
		return handle;
	}

	public void setHandle(LinuxSessionHandle handle) {
		this.handle = handle;
	}

	public String getDefaultTopComand() {
		return defaultTopComand;
	}

	public void setDefaultTopComand(String defaultTopComand) {
		this.defaultTopComand = defaultTopComand;
	}

}
