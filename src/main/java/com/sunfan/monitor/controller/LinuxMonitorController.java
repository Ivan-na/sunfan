package com.sunfan.monitor.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunfan.monitor.baseUtil.JsonMapper;
import com.sunfan.monitor.entity.CpuInfo;
import com.sunfan.monitor.entity.MemoryInfo;
import com.sunfan.monitor.entity.util.CpuInfoUtil;
import com.sunfan.monitor.entity.util.MemoryInfoUtil;
import com.sunfan.monitor.service.LinuxService;

public class LinuxMonitorController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LinuxService linuxService;
	@Autowired
	private CpuInfoUtil cpuUtil;
	@Autowired
	private MemoryInfoUtil menoryUtil;
	public String systemSummaryMonitor() {
		String res = null;
		try {
			res = linuxService.topMonitor("192.168.1.9", "root", "root");
		} catch (IOException e) {
			log.error("打开机器异常:{}","192.168.1.9",e);
		}
		return res;
	}
	
	public String cpuMonitor() {
		String res = null;
		try {
			res = linuxService.cpuMonitor("192.168.1.9", "root", "root");
		    res = JsonMapper.toNonDefaultJson(cpuUtil.mpstatResultTransferCpuObject(res));
		} catch (IOException e) {
			log.error("打开机器异常:{}","192.168.1.9",e);
		}
		return res;
	}
	
	public String memoryMonitor() {
		String res = null;
		try {
			res = linuxService.memoryMonitor("192.168.1.9", "root", "root");
		    res = JsonMapper.toNonDefaultJson(menoryUtil.freeResultTransferMemoryInfoObject(res));
		} catch (IOException e) {
			log.error("打开机器异常:{}","192.168.1.9",e);
		}
		return res;
	}
	

	public LinuxService getLinuxService() {
		return linuxService;
	}

	public void setLinuxService(LinuxService linuxService) {
		this.linuxService = linuxService;
	}

	public CpuInfoUtil getCpuUtil() {
		return cpuUtil;
	}

	public void setCpuUtil(CpuInfoUtil cpuUtil) {
		this.cpuUtil = cpuUtil;
	}
}
