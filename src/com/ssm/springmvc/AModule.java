package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class AModule {

	@RequestMapping("/login")
	public String login(){
		System.out.println("aModule模块登录");
		//在springmvcservlet.xml配置中对路径进行了限定，因此不用加前缀/与后缀.jsp
		return "index";
	}
}
