package com.ssm.springmvc.control;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.springmvc.pojo.Userinfo;

@Controller
public class ReturnJSONString {

	@RequestMapping(value = "returnJSONString")
	@ResponseBody
	public String ReturnJSONString(){
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername("王五");
		userinfo.setPassword("123");
		return JSONObject.fromObject(userinfo).toString();
	}
}
