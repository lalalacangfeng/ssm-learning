package com.ssm.spring.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

interface hello{
	//声明一个接口
	public void say_hello();//声明个方法
}

class helloImpl implements hello{
	public void say_hello(){
		System.out.println("hello 动态代理");
	}
}

public class TestInterface implements InvocationHandler {
	Object any_object;
	
	//声明bind方法
	public Object bind(Object any_object){
		this.any_object = any_object;
		
		return Proxy.newProxyInstance(any_object.getClass().getClassLoader(),
				any_object.getClass().getInterfaces(), this);
	}

	//重写invoke方法
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object return_object = null;
		System.out.println("-----准备打印-----");
		return_object = method.invoke(any_object, args);
		System.out.println("-----结束打印-----");
		return return_object;
	}
	
	@Test
	public void testInte(){
		TestInterface run = new TestInterface();
		hello hello_ref = (hello) run.bind(new helloImpl());
		hello_ref.say_hello();
	}
}
