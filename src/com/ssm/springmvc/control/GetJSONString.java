package com.ssm.springmvc.control;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.springmvc.pojo.Userinfo;

@Controller
public class GetJSONString {
	
	@RequestMapping(value="getJSONString")
	public String getJSONString(@RequestParam("jsonString") String jsonString){
		JSONObject object  = new JSONObject(jsonString);
		System.out.println(object.get("username"));
		System.out.println(object.get("password"));
		return "test";
	}
	
	@RequestMapping(value="getJSON",method=RequestMethod.POST)
	public String createJSON(@RequestBody Userinfo userinfo){
		System.out.println("username value="+userinfo.getUsername());
		System.out.println("password value="+userinfo.getPassword());
		return "test";
	}
}
