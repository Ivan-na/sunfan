package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CpuPageController {
	
	@RequestMapping("/total_utilization")
	public String total_utilization() {
		return "/jsp/monitor/cpu/total_utilization.jsp";
	}
	
	@RequestMapping("/io_wait")
	public String io_wait() {
		return "/jsp/monitor/cpu/io_wait.jsp";
	}


}
