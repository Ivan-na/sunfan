package com.sunfan.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IoPageController {
	@RequestMapping("/tps")
	public String tps() {
		return "/jsp/monitor/io/tps.jsp";
	}
	@RequestMapping("/blk_read_s")
	public String blk_read_s() {
		return "/jsp/monitor/io/blk_read_s.jsp";
	}
	@RequestMapping("/blk_read")
	public String blk_read() {
		return "/jsp/monitor/io/blk_read.jsp";
	}
	@RequestMapping("/blk_wrtn_s")
	public String blk_wrtn_s() {
		return "/jsp/monitor/io/blk_wrtn_s.jsp";
	}
	@RequestMapping("/blk_wrtn")
	public String blk_wrtn() {
		return "/jsp/monitor/io/blk_wrtn.jsp";
	}
	@RequestMapping("/total_util")
	public String total_util() {
		return "/jsp/monitor/io/total_util.jsp";
	}
	@RequestMapping("/connections")
	public String connections() {
		return "/jsp/monitor/io/connections.jsp";
	}

}
