package com.ssm.spring.ioc;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
* @ClassName: My_MethodBeforeAavice
* @Description: 方法执行前增强需要实现接口：MethodBeforeAdvice
* @author cangfeng
* @date 2019年2月28日 下午6:36:45
*
 */
public class My_MethodBeforeAavice implements MethodBeforeAdvice {

	//重写before方法
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("*****准备打印了******");
		
	}
}
