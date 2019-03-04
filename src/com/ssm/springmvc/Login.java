package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//@Controller注解代表本Java类是controller控制层
//@Controller
public class Login {
	
	//用指定的URL访问本控制层
	@RequestMapping("/login")
	//@RequestParam:根据参数名从url取得参数值，同名参数可以省略
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model){
		if(username.equals("test") && password.equals("123")){			
			model.addAttribute("username",username);
			return "ok.jsp";			
		}else {
			return "no.jsp";			
		}
	}
}
