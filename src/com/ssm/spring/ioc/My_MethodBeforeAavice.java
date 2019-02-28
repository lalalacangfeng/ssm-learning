package com.ssm.spring.ioc;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
* @ClassName: My_MethodBeforeAavice
* @Description: 方法执行前增强需要实现接口：MethodBeforeAdvice
* @author cangfeng
* @date 2019年2月28日 下午6:36:45
*
 */
public class My_MethodBeforeAavice implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor {

	//重写before方法
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("MethodBeforeAdvice方法");
		System.out.println("*****准备打印了******");
		
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("AfterReturningAdvice方法");
		System.out.println("*****打印完成了******");
	}

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("方法执行前增强");
		System.out.println();
		arg0.proceed();
		System.out.println();
		System.out.println("方法执行后增强");
		return null;
	}
}
