package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CpuPageController {
	
	@RequestMapping("/total_utilization")
	public String index() {
		return "/jsp/monitor/cpu/total_utilization.jsp";
	}

}
