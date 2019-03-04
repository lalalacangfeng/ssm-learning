package com.ssm.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListUsername {

	@RequestMapping("/listUsername")
	public String ListUsername(Model model){
		List listUsername = new ArrayList();
		for(int i = 0;i<10;i++){
			listUsername.add("username"+(i+1));
		}
		model.addAttribute("listUsername", listUsername);
		return "listUsername";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("username") String username){
		System.out.println("username:"+username);
		//重定向：在返回字符串中加入"redirect:/"前缀代表重定向——无参数传递
		//重定向：在返回字符串中加入"redirect:/***.spring?参数="+参数   前缀代表重定向——有参数传递
		return "redirect:/test.jsp";
	}
}
