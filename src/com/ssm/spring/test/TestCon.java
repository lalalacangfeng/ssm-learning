package com.ssm.spring.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.Construct;

public class TestCon{
	Construct construct;
	
	public Construct getConstruct(){
		return construct;
	}
	
	public void setConstruct(Construct construct){
		this.construct = construct;
	}
	
//	@Test
	public void run(){
		//通过IOC容器对构造方法进行注入

		//取得应用程序上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从IOC容器中取出指定Bean对象
		TestCon testcon = (TestCon) context.getBean("contest");
	}
	
//	@Test
	public void testpro(){
		//对Bean作用域进行测试
		
		//取得应用程序上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		try{
			//从IOC容器中取出指定Bean对象
			Date date = (Date) context.getBean("my_Date");
			//sleep休息3秒
			Thread.sleep(3000);
			System.out.println("date :"+date);
			date = (Date) context.getBean("my_Date");
			//sleep休息3秒
			Thread.sleep(3000);
			System.out.println("date :"+date);
			date = (Date) context.getBean("my_Date");
			//sleep休息3秒
			Thread.sleep(3000);
			System.out.println("date :"+date);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("出错了");
		}
	}
	
	
}