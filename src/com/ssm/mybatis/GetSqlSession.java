package com.ssm.mybatis;

import org.apache.ibatis.session.SqlSession;


public class GetSqlSession {
	private static ThreadLocal<SqlSession> t1 = new ThreadLocal<SqlSession>();
	
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = t1.get();
		if(sqlSession==null){
			sqlSession = GetSqlSessionFactory.getSqlSessionFactory().openSession();
			t1.set(sqlSession);
		}else {
			
		}
		System.out.println("获得的sqlSession对象的hashCode:"+sqlSession.hashCode());
		return sqlSession;
	}
	
	public static void commit(){
		if(t1.get()!=null){
			t1.get().commit();
			t1.get().close();
			t1.set(null);
			System.out.println("提交了");
		}
	}
	
	public static void rollback(){
		if(t1.get()!=null){
			t1.get().rollback();
			t1.get().close();
			t1.set(null);
			System.out.println("回滚了");
		}
	}
}
