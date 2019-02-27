package com.ssm.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class DBOperate {


	
	public int insert(String sql,Map<Object, Object> valueMap){
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		return sqlSession.insert(sql, valueMap);
	}
	
	public int delete(String sql,Map<Object, Object> valueMap){
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		return sqlSession.delete(sql, valueMap);
	}
	
	public int update(String sql,Map<Object, Object> valueMap){
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		return sqlSession.update(sql, valueMap);
	}
	
	public List<Map<Object, Object>> select(String sql,Map<Object, Object> valueMap){
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		return sqlSession.selectList(sql, valueMap);
	}
}
