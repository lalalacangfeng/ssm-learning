package com.ssm.springmvc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.springmvc.pojo.Userinfo;

@Controller
public class TestJson {

	@RequestMapping("getJSON1")
	public void getJSON1(@RequestBody Userinfo userinfo){
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getPassword());
	}
	
	@RequestMapping("getJSON2")
	public void getJSON2(@RequestBody ArrayList<String> list){
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@RequestMapping("getJSON3")
	public void getJSON3(@RequestBody List<Map> list){
		for(int i = 0;i<list.size();i++){
			Map map = list.get(i);
			System.out.println(map.get("username")+"  "+map.get("password"));
		}
	}
	
	@RequestMapping("getJSON4")
	public void getJSON4(@RequestBody Map map){
		System.out.println(map.get("username"));
		List<Map> workList = (List) map.get("work");
		for(int i = 0;i<workList.size();i++){
			Map eachMap = workList.get(i);
			System.out.println("address="+eachMap.get("address"));
		}
		
		Map schoolMap = (Map) map.get("school");
		System.out.println(schoolMap.get("name"));
		System.out.println(schoolMap.get("address"));
	}
}
