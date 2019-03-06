package com.ssm.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.springmvc.pojo.Userinfo;

@Controller
public class CreateJSON {

	//通过consumes="application/json"限制前台传入数据的格式是JSON
	//produces="application/json"将返回的数据转成JSON对象并传回客户端
	//@ResponseBody将JSON字符串作为响应处理
	@RequestMapping(value="createJSON",method = RequestMethod.POST,
			consumes="application/json",produces="application/json"
			)
	@ResponseBody
	public Userinfo createJSON(@RequestBody Userinfo userinfoParam){
		System.out.println(userinfoParam.toString());
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("传回对象了");
		userinfo.setPassword("123");
		return userinfo;
	}
}
