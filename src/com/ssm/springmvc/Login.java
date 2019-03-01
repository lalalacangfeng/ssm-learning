package com.ssm.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//@Controller注解代表本Java类是controller控制层
@Controller
public class Login {
	
	@RequestMapping("/login")
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
