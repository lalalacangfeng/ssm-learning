package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="method")
public class Method {
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(){
		 System.out.println("get提交了");
		 return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(){
		System.out.println("post提交了");
		return "index";
	}
}
