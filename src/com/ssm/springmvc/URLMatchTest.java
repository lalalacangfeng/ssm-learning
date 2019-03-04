package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test4/{urlId}")
public class URLMatchTest {

	//直接使用Path路径配置变量{userId}
	@RequestMapping("/test1/{urlId}")
	public String test1(@PathVariable String urlId){
		//测试网址为：http://localhost:8090/ssm/test1/123.spring
		System.out.println("run test1 urlId="+urlId);
		return "index";
	}
	
	//直接配置变量的别名为id
	@RequestMapping("/test2/{urlId}")
	public String test2(@PathVariable("urlId") String id){
		//http://localhost:8090/ssm/test2/123.spring
		System.out.println("run test2 id"+id);
		return "index";
	}
	
	@RequestMapping("/test3/{urlId}/age/{ageValue}")
	public String test3(@PathVariable String urlId,@PathVariable int ageValue){
		System.out.println("run test3 urlId:"+urlId+" ageValue:"+ageValue);
		return "index";
	}
	
	@RequestMapping("/age/{ageValue}")
	public String test4(@PathVariable String urlId,@PathVariable int ageValue){
		System.out.println("run test4 urlId:"+urlId+" ageValue:"+ageValue);
		return "index";
	}
}
