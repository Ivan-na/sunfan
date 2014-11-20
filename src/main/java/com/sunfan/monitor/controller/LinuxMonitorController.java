package com.sunfan.monitor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class LinuxMonitorController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private LinuxService linuxService;
	@Autowired
	private CpuInfoUtil cpuUtil;
	@Autowired
	private MemoryInfoUtil menoryUtil;
	@Autowired
	private IOstatInfoUtil ioUtil;

	public String systemSummaryMonitor() {
		String res = null;
		// try {
		// // res = linuxService.topMonitor("192.168.1.9", "root", "root");
		// } catch (IOException e) {
		// }
		return res;
	}

	/**
	 * monitor cpu by cmd defaultMpstatComand "mpstat -P ALL"
	 * 
	 * @return json result
	 */
	@RequestMapping("/cpu")
	public String cpuMonitor(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User) request.getSession().getAttribute("sUser");
			res = linuxService.cpuMonitor(u.getUrl(), u.getUsername(), u.getPassword());
			res = JsonMapper.toNonDefaultJson(cpuUtil.mpstatResultTransferCpuObject(res));
			System.out.println(res);
		} catch (IOException e) {
			log.error("cpu数据获取异常",e);
		}
		return res;
	}

	/**
	 * monitor memory by command "free -m"
	 * 
	 * @return json result
	 */
	@RequestMapping("/memory")
	public String memoryMonitor(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User) request.getSession().getAttribute("sUser");
			res = linuxService.memoryMonitor(u.getUrl(), u.getUsername(), u.getPassword());
			res = JsonMapper.toNonDefaultJson(menoryUtil.freeResultTransferMemoryInfoObject(res));
			System.out.println(res);
		} catch (IOException e) {
			log.error("内存数据获取异常",e);
		}
		return res;
	}

	/**
	 * //monitor IO by command "iostat -d -m -x"; monitor IO by command
	 * "iostat -d -m ";
	 * 
	 * @return json result
	 */
	@RequestMapping("/io")
	public String InputOutputMonitor(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User) request.getSession().getAttribute("sUser");
			res = linuxService.inputOutputMonitor(u.getUrl(), u.getUsername(), u.getPassword());
			res = JsonMapper.toNonDefaultJson(ioUtil.iostatResultTransferCpuObject(res));
			System.out.println(res);
		} catch (IOException e) {
			log.error("磁盘数据获取异常",e);
		}
		return res;
	}
	
	@RequestMapping("/io_x")
	public String InputOutputMonitor_x(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User) request.getSession().getAttribute("sUser");
			res = linuxService.inputOutputMonitor_x(u.getUrl(), u.getUsername(), u.getPassword());
			res = JsonMapper.toNonDefaultJson(ioUtil.iostatResultTransferCpuObject(res));
			System.out.println(res);
		} catch (IOException e) {
			log.error("磁盘数据获取异常",e);
		}
		return res;
	}
	
	@RequestMapping("/connections_count")
	public String conections(HttpServletRequest request) {
		String res = null;
		try {
			User u = (User) request.getSession().getAttribute("sUser");
			res = linuxService.inputConections(u.getUrl(), u.getUsername(), u.getPassword());
			res = JsonMapper.toNonDefaultJson(res);
			System.out.println(res);
		} catch (IOException e) {
			log.error("连接数获取异常",e);
		}
		return res;
	}

}
