package com.ssm.springmvc.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetRequest {
	
	@RequestMapping("/getRequest1")
	public String getRequest1(HttpServletRequest request,HttpServletResponse response){
		System.out.println("request1："+request);
		System.out.println("response1："+response);
		request.setAttribute("username", "心塞塞");
		return "index";
	}
	
	@RequestMapping("/getResponse1")
	public void login(HttpServletResponse response){
		try {
			String username = "xuxuxux";
			System.out.println(username);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("我是心塞塞");
			out.flush();out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
