package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoryPageController {
	
	@RequestMapping("/mem_used")
	public String index() {
		return "/jsp/monitor/memory/mem_used.jsp";
	}


}
