package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testdb {
	String driver;
	String username;
	String password;
	String url;
	
	@Test
	public void run(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Testdb run = (Testdb) context.getBean("showdb");
		System.out.println("driver: "+run.driver);
		System.out.println("url: "+run.url);
		System.out.println("username: "+run.username);
		System.out.println("password: "+run.password);
		
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
