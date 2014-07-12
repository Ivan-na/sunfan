package com.sunfan.monitor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sunfan.monitor.entity.User;
import com.sunfan.monitor.service.LinuxService;

@Controller
public class LoginController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private LinuxService linuxService;

	@RequestMapping("/serverLogin")
	public ModelAndView serverLogin(User user, HttpServletRequest request) {
		String res = "";
		try {
			res = linuxService.executeCommand(user.getUrl(), user.getUsername(), user.getPassword(), "whoami");
		} catch (IOException e) {
			return new ModelAndView("/jsp/login/server_error.jsp","error",e.getMessage());
		} catch (IllegalArgumentException e1) {
			return new ModelAndView("/jsp/login/server_error.jsp","error",e1.getMessage());
		}
		request.getSession().setAttribute("sUser", user);
		return new ModelAndView("/jsp/login/server_index.jsp", "res", res);
	}

}
