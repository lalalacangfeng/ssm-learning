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
		return "listUsername.jsp";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username){
		System.out.println("username:"+username);
		return "test.jsp";
	}
}
