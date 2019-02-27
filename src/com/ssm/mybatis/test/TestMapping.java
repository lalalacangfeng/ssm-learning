package com.ssm.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ssm.mybatis.DBOperate;
import com.ssm.mybatis.GetSqlSession;

public class TestMapping {

	@Test
	public void test(){
		GetSqlSession.getSqlSession();
		GetSqlSession.getSqlSession();
		GetSqlSession.getSqlSession();
		GetSqlSession.getSqlSession();
		GetSqlSession.getSqlSession();
	}
	
	@Test
	public void TestDelete(){
		//删除
		HashMap<Object, Object> v1=new HashMap<Object, Object>();
		v1.put("uid", 17);
		try {
			DBOperate dbOperate = new DBOperate();
			dbOperate.delete("deleteUserByid", v1);	
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally{
			GetSqlSession.commit();
		}
	}
	
	@Test
	public void TestSelectAll(){
		//查询多条记录
		try {
			DBOperate dbOperate = new DBOperate();
			List<Map<Object, Object>> list = dbOperate.select("getUsersAll", null);
			for (int i = 0; i < list.size(); i++) {
				Map<?,?> map = list.get(i);
				System.out.println("username:"+map.get("username")+" "+map.get("uid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally{
			GetSqlSession.commit();
		}
	}
	
	@Test
	public void TestSelectByid(){
		//通过id查询
		HashMap<Object, Object> v1 = new HashMap<Object, Object>();
		v1.put("uid", 3);
		try {
			DBOperate dbOperate = new DBOperate();
			List<Map<Object, Object>> list = dbOperate.select("getUsersByid", v1);
			for (int i = 0; i < list.size(); i++) {
				Map<?,?> map = list.get(i);
				System.out.println("username:"+map.get("username")+" "+map.get("uid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally{
			GetSqlSession.commit();
		}
	}
	
	@Test
	public void TestUpdate(){
		//更新
		HashMap<Object, Object> v1 = new HashMap<Object, Object>();
		v1.put("uid", 16);
		v1.put("username", "lalala");
		try {
			DBOperate dbOperate = new DBOperate();
			dbOperate.update("updateUserByid", v1);	
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally{
			GetSqlSession.commit();
		}
		
	}
	
	@Test
	public void TestIns(){
		//插入
		HashMap<Object,Object> valueMap1 = new HashMap<Object,Object>();
		valueMap1.put("username", "mapping1afsadfsfasdfdasfasfddsafsadfasdfsdfds_12341412414224_sfsfsdfsdf");	
		valueMap1.put("role", 4);
		
		HashMap<Object,Object> valueMap2 = new HashMap<Object,Object>();
		valueMap2.put("username", "mapping2");
		valueMap2.put("role", 4);
		
		try {
			DBOperate dbOperate = new DBOperate();
			dbOperate.select("insertUsers", valueMap1);
			dbOperate.select("insertUsers", valueMap2);			
		} catch (Exception e) {
			e.printStackTrace();
			GetSqlSession.rollback();
		} finally{
			GetSqlSession.commit();
		}
	}
}
