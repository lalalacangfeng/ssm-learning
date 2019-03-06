package com.ssm.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.springmvc.pojo.Userinfo;

@Controller
public class ParamToEntity {
	
	@RequestMapping("paramToEntity")
	public String ParamToEntity(Userinfo userinfo){
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getPassword());
		return "test";
	}
}
