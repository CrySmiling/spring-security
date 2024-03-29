package com.lzh.springsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/")
	public String showHome() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("当前登陆用户：" + name);

		return "home.html";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login.html";
	}

	@RequestMapping("/admin")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String printAdmin() {
		return "如果你看见这句话，说明你有ROLE_ADMIN角色";
	}

	@RequestMapping("/user")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER')")
	public String printUser() {
		return "如果你看见这句话，说明你有ROLE_USER角色";
	}

	@RequestMapping("/login/invalid")
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String invalid(){
		return "Session 已过期，请重新登录";
	}

}

