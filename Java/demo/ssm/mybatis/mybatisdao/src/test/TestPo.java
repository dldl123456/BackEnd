package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.UserMapper;
import po.User;
import utils.Utils;

public class TestPo {
	//@Test
	public void TestPoInsertUser(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		User user = new User("eee", "dfde", 78);
		
		//拿接口的反射,返回的是接口(代理对象)
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		System.out.println("um(代理对象)==" + um);
		
		//返回的是影响的结果集(用代理对象实现添加)
		um.insertUser(user);
		
		//人工提交事务，永久写入磁盘
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	@Test
	public void TestPoGetUserById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		
		//调用UserMapper的方法
		User user = um.getUserById(2);
		
		System.out.println(user);
		
	}
}
