package com.sunfan.monitor.action;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunfan.monitor.service.LinuxService;

public class LinuxMonitorAction {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LinuxService linuxService;

	public String TopAction() {
		String res = null;
		try {
			res = linuxService.topMonitor("127.0.0.1", "zhangsn", "1");
		} catch (IOException e) {
			logger.error("打开机器异常:{}","192.168.1.9",e);
		}
		if (res == null) {
			res = "TopAction execute fail";
		}
		return res;

	}

}
