package com.ssm.mybatis;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	private GetSqlSessionFactory(){
	}
	synchronized public static SqlSessionFactory getSqlSessionFactory(){
		try {
			if(sqlSessionFactory==null){
				System.out.println("sqlSessionFactory为空");
				InputStream isRef = GetSqlSession.class.getResourceAsStream("/db.properties");
				Properties properties = new Properties();
				properties.load(isRef);//加载db
				String resource="mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,properties);
				System.out.println("新建sqlSessionFactory");
			}else{
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
