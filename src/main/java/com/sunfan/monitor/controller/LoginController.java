package com.sunfan.monitor.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunfan.monitor.entity.User;
import com.sunfan.monitor.service.LinuxService;

/**
 * 
 * @author sunfan
 * 
 */
@Controller
public class LoginController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private LinuxService linuxService;

	@RequestMapping("/")
	public String index() {
		return "/jsp/login/server_login.jsp";
	}

	@RequestMapping(value = "/serverLogin",method = RequestMethod.POST)
	public String serverLogin(User user, HttpSession session, Model model) {
		String res = "";
		try {
			res = linuxService.executeCommand(user.getUrl(), user.getUsername(), user.getPassword(), "whoami");
		} catch (IOException e) {
			log.error("发生了异常", e);
			model.addAttribute("error", e.getMessage());
			return "/jsp/login/server_error.jsp";
		} catch (IllegalArgumentException e1) {
			log.error("发生了异常", e1);
			model.addAttribute("error", e1.getMessage());
			return "/jsp/login/server_error.jsp";
		}
		session.setAttribute("sUser", user);
		model.addAttribute("res", res);
		return "/jsp/login/server_index.jsp";
	}

}
