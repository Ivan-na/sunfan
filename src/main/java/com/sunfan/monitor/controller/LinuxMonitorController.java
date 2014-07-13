package com.sunfan.monitor.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunfan.monitor.baseUtil.JsonMapper;
import com.sunfan.monitor.entity.User;
import com.sunfan.monitor.entity.util.CpuInfoUtil;
import com.sunfan.monitor.entity.util.IOstatInfoUtil;
import com.sunfan.monitor.entity.util.MemoryInfoUtil;
import com.sunfan.monitor.service.LinuxService;


/**
 * 
 * @author sunfan
 *
 */
@Controller
public class LinuxMonitorController{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LinuxService linuxService;
	@Autowired
	private CpuInfoUtil cpuUtil;
	@Autowired
	private MemoryInfoUtil menoryUtil;
	@Autowired
	private IOstatInfoUtil ioUtil;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("/jsp/login/server_login.jsp");
	}
	
	
	public String systemSummaryMonitor() {
		String res = null;
		try {
			res = linuxService.topMonitor("192.168.1.9", "root", "root");
		} catch (IOException e) {
		}
		return res;
	}
	
	/**monitor cpu by cmd defaultMpstatComand "mpstat -P ALL" 
	 * 
	 * @return json result
	 */
	@RequestMapping("/cpu")
	 @ResponseBody  
	public String cpuMonitor(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User)request.getSession().getAttribute("sUser");
			res = linuxService.cpuMonitor(u.getUrl(), u.getUsername(), u.getPassword());
		    res = JsonMapper.toNonDefaultJson(cpuUtil.mpstatResultTransferCpuObject(res));
		    System.out.println(res);
		} catch (IOException e) {
		}
		return res;
	}
	
	/**
	 *  monitor memory by command "free -m" 
	 * @return json result
	 */
	@RequestMapping("/memory")
	 @ResponseBody  
	public String memoryMonitor(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User)request.getSession().getAttribute("sUser");
			res = linuxService.memoryMonitor(u.getUrl(), u.getUsername(), u.getPassword());
		    res = JsonMapper.toNonDefaultJson(menoryUtil.freeResultTransferMemoryInfoObject(res));
		    System.out.println(res);
		} catch (IOException e) {
		}
		return res;
	}
	
	/**
	 *  //monitor IO by command "iostat -d -m -x"; 
	 *  monitor IO by command "iostat -d -m ";
	 * @return json result
	 */
	@RequestMapping("/io")
	 @ResponseBody  
	public String InputOutputMonitor(HttpServletRequest request){
		String res = null;
		try {
			User u = (User)request.getSession().getAttribute("sUser");
			res = linuxService.inputOutputMonitor(u.getUrl(), u.getUsername(), u.getPassword());
		    res = JsonMapper.toNonDefaultJson(ioUtil.iostatResultTransferCpuObject(res));
		    System.out.println(res);
		} catch (IOException e) {
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

	public MemoryInfoUtil getMenoryUtil() {
		return menoryUtil;
	}

	public void setMenoryUtil(MemoryInfoUtil menoryUtil) {
		this.menoryUtil = menoryUtil;
	}

	public IOstatInfoUtil getIOUtil() {
		return ioUtil;
	}

	public void setIOUtil(IOstatInfoUtil iOUtil) {
		ioUtil = iOUtil;
	}
	
}
