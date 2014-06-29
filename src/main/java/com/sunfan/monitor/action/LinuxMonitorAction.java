package com.sunfan.monitor.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Logger;

import com.sunfan.monitor.service.LinuxService;
import com.sunfan.monitor.util.PrintStackTraceUtil;

public class LinuxMonitorAction {
	Logger logger = (Logger)LoggerFactory.getLogger(LinuxMonitorAction.class);
	@Autowired
	LinuxService linuxService;
	
	public String TopAction(){
		String res =null;
		try {
			res = linuxService.topMonitor("192.168.1.9", "root", "root");
		} catch (IOException e) {
             logger.error(PrintStackTraceUtil.printStackTrace(e));
		}
		if(res==null){
			res="TopAction execute fail";
		}
		return res;
		
	}

	public LinuxService getLinuxService() {
		return linuxService;
	}

	public void setLinuxService(LinuxService linuxService) {
		this.linuxService = linuxService;
	}
	
	

}
