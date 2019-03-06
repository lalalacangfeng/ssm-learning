package com.ssm.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class List {
	@RequestMapping(value="/list",params="type=a")
	public String listA(){
		System.out.println("AAA");
		return "index";
	}
	
	@RequestMapping(value="/list",params="type=b")
	public String listB(){
		System.out.println("BBB");
		return "index";
	}
}
