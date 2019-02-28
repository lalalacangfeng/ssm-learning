package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.VarData;

public class TestVar {
	
	VarData varData;
	public VarData getVarData(){
		return varData;
	}
	
	public void setVarData(VarData varData){
		this.varData = varData;
	}	
	
//	@Test
	public void test(){
		System.out.println("关于test的测试");
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");//通过配置文件得到应用程序的上下文，就是IOC容器
		TestVar testVar = (TestVar) applicationContext.getBean("runtest");
		testVar.getVarData().printAll();
	}
}
