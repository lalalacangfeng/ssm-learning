package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class AModule {

	@RequestMapping("/login")
	public String login(){
		System.out.println("aModule模块登录");
		return "../index.jsp";
	}
}
