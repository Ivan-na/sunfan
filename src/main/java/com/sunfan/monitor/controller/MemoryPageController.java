package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoryPageController {
	
	@RequestMapping("/mem_used")
	public String mem_used() {
		return "/jsp/monitor/memory/mem_used.jsp";
	}
	@RequestMapping("/mem_free")
	public String mem_free() {
		return "/jsp/monitor/memory/mem_free.jsp";
	}

	@RequestMapping("/mem_free_buffer_cach")
	public String mem_free_buffer_cach() {
		return "/jsp/monitor/memory/mem_free_buffer_cach.jsp";
	}



}
