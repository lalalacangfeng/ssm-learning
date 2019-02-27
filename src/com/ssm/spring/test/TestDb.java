package com.ssm.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.spring.ioc.IDataOperate;

public class TestDb {
	
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
		//XXX 这是个关于xml配置文件删除还能用的问题
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");//通过配置文件得到应用程序的上下文，就是IOC容器
		TestDb run_ref=(TestDb) applicationContext.getBean("run");//取得指定的Bean实例
		run_ref.getDataOperate().save("这是第一个关于IOC测试!!");
	}
}
