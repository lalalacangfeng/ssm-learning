package com.ssm.spring.ioc;

public class Construct {
	public Construct(String str_var, int int_var){
		System.out.println();
		System.out.println("在public Construct(String str_var, int int_var) 构造方法中打印...");
		System.out.println("str_var:"+str_var+" int_var:"+int_var);
		System.out.println();
	}

	public Construct(String str_var, String str2_var){
		System.out.println();
		System.out.println("在public Construct(String str_var,String str2_var) 构造方法中打印...");
		System.out.println("str_var:"+str_var+" str2_var:"+str2_var);
		System.out.println();
	}
}