package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IoPageController {
	@RequestMapping("/tps")
	public String index() {
		return "/jsp/monitor/io/tps.jsp";
	}

}
