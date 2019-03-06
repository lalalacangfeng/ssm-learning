package com.ssm.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/b")
public class BModule {

	@RequestMapping("/login")
	public String login(){
		System.out.println("bModule模块登录");
		return "../index.jsp";
	}
}
