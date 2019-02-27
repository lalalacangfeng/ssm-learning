package com.ssm.spring.ioc;

public class DBOperate implements IDataOperate {

	public void save(String big_text) {
		System.out.println("将数据   "+big_text+"  保存进数据库");

	}

}
