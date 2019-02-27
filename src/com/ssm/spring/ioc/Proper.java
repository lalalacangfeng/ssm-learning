package com.ssm.spring.ioc;

import java.util.Iterator;
import java.util.Properties;

public class Proper {

	Properties properties;//声明一个属性类对象
	
	public void print_All(){
		//输出内容
		Iterator iterator = properties.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			Object value = properties.get(key);
			System.out.println("key= "+key+"  value: "+value);
		}
	}
	
	public Properties getProperties(){
		return properties;
	}
	public void setProperties(Properties properties){
		this.properties = properties;
	}
}
