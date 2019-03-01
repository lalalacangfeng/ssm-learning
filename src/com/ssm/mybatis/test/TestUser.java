package com.ssm.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.orm.Users;
import com.orm.UsersExample;
import com.orm.UsersExample.Criteria;
import com.orm.UsersMapper;
import com.ssm.mybatis.GetSqlSession;

public class TestUser {

	//在iBator逆向工程生成的文件XxxExample.java中包含一个static的内部类Criteria，Criteria中的方法是定义SQL 语句where后的查询条件。
	
	@Test
	public void TestMapper(){
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
		Users user = mapper.selectByPrimaryKey(1);
		System.out.println("id:"+user.getUid());
		System.out.println("name:"+user.getUsername());
		System.out.println("email:"+user.getEmail());
	}
	
	@Test
	public void TestSelectById(){
		//查询id为1的用户
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		Users user = sqlSession.selectOne("selectByPrimaryKey",1);
		System.out.println("查询id为1的用户");
		System.out.println("id:"+user.getUid());
		System.out.println("name:"+user.getUsername());
		System.out.println("email:"+user.getEmail());
	}
	
	@Test
	public void TestSelectAll(){
		//查询所有用户
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		List<Users> list = sqlSession.selectList("selectByExample");
		System.out.println("查询所有用户");
		for (int i = 0; i < list.size(); i++) {
			Users user= list.get(i);
			System.out.println("id:"+user.getUid());
			System.out.println("name:"+user.getUsername());
			System.out.println("email:"+user.getEmail());
		}
	}
	
	@Test
	public void TestInsert(){
		//插入单条语句
		Users user= new Users();
		user.setUsername("mybatis");
		user.setEmail("mybatis");
		user.setRole(4);
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		sqlSession.insert("insert", user);
		System.out.println("插入单条语句");
		System.out.println("id:"+user.getUid());//无法自增<!-- 主键自增 -->
		//<generatedKey column="uid" sqlStatement="mysql" identity="true" />
		//sqlSession.commit();sqlSession.close();//进行提交
	}
	
	@Test
	public void TestDelByid(){
		//删除单条语句
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		System.out.println("删除单条语句");
		sqlSession.delete("deleteByPrimaryKey", 12);
		sqlSession.commit();sqlSession.close();
	}
	
	@Test
	public void TestDelByLike(){
		//删除多条语句
		UsersExample user= new UsersExample();
		Criteria criteria = user.createCriteria();
		criteria.andUsernameEqualTo("mybatis");
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		System.out.println("删除多条语句");
		sqlSession.delete("deleteByExample", user);
		sqlSession.commit();sqlSession.close();
	}
	
	@Test
	public void TestUpdateByid(){
		//更新单条id ByPrimaryKey
		Users user = new Users();
		user.setUid(9);
		user.setUsername("mybatis");
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		System.out.println("更新单条id");
		sqlSession.update("updateByPrimaryKeySelective", user);
		//sqlSession.commit();sqlSession.close();//进行提交
	}
	
	@Test
	public void TestUpdateByExampleSelective(){
		//FIXME ExampleSelective的使用
		//更新ByExampleSelective
		UsersExample example= new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(9);
		criteria.andUsernameEqualTo("user");
		Users user = new Users();
		user.setUsername("lalalafeng9");
		SqlSession sqlSession = GetSqlSession.getSqlSession();
		System.out.println("更新ByExampleSelective");
//		sqlSession.update("updateByExampleSelective",user,example);
		
	}
	
	
}
