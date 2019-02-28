package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.Proper;

public class TestPro {
	
	Proper proper;
	public Proper getProper(){
		return proper;
	}
	
	public void setProper(Proper proper){
		this.proper=proper;
	}
	
//	@Test
	public void protest(){
		System.out.println("protest测试");
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");//通过配置文件得到应用程序的上下文，就是IOC容器
		TestPro testProper = (TestPro) applicationContext.getBean("protest");
		testProper.getProper().print_All();
	}
}
