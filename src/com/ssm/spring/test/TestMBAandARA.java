package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.Hello;

public class TestMBAandARA {

	@Test
	public void runMBAandARA(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello_ref = (Hello)context.getBean("my_proxy");
		hello_ref.say_hello();
	}
	
	
}
