package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.IDataOperate;

public class Run {
	
	private IDataOperate dataOperate;
	public IDataOperate getDataOperate(){
		return dataOperate;
	}
	public void setDataOperate(IDataOperate dataOperate){
		System.out.println("setDataOperate dataOperate="+dataOperate);
		this.dataOperate = dataOperate;
	}
	
	@Test
	public void main(){
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");//通过配置文件得到应用程序的上下文，就是IOC容器
		Run run_ref=(Run) applicationContext.getBean("run");//取得指定的Bean实例
		run_ref.getDataOperate().save("这是第一个关于IOC测试!!");
	}
}
