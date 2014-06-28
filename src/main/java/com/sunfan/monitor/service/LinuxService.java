package com.sunfan.monitor.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.platform.IConnectable;
import com.sunfan.monitor.platform.linux.LinuxConnect;
import com.sunfan.monitor.platform.linux.LinuxHandle;

@Component
public class LinuxService {
	private String defaultTopComand = "top -b -n 1";
	@Autowired
	private LinuxConnectionPool pool ;
	public String topMonitor(String url,String user,String password) throws IOException{
		String key = pool.rewardConnectionKey(url, user, password);
		IConnectable lc =  pool.borrowObject(key);
		if(lc==null){
			lc = new LinuxConnect(url, user, password);
		}
		return new LinuxHandle(lc.getConnection()).executeCommand(defaultTopComand);
	}

	public LinuxConnectionPool getPool() {
		return pool;
	}
	public void setPool(LinuxConnectionPool pool) {
		this.pool = pool;
	}

	public String getDefaultTopComand() {
		return defaultTopComand;
	}

	public void setDefaultTopComand(String defaultTopComand) {
		this.defaultTopComand = defaultTopComand;
	}

}
