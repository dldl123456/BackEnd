package com.zhizuobiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhizuobiao.entity.User;

public class HelloWolrdTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 数据库会话实例
	private SqlSession sqlSession;

	@Before
	public void createSqlSessionFactory() throws IOException {
		// 配置文件
		String resource = "mybatis-config.xml";
		// 读取配置文件，转换成输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建数据库会话实例sqlSession
		sqlSession = sqlSessionFactory.openSession();

	}

	@After
	public void destory() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	// 根据 id查询用户信息
	@Test
	public void testGetUser() {
		// 查询单个记录，根据用户id查询用户信息
		User user = sqlSession.selectOne("test.getUser", 7);
		// 输出用户信息
		System.out.println(user);

	}

	// 根据用户名称模糊查询用户信息
	@Test
	public void testGetUserList() {

		// 查询单个记录，根据用户id查询用户信息
		List<User> list = sqlSession.selectList("test.getUserList", null);
		System.out.println(list.size());
		for (User u : list) {
			System.out.println(u);
		}

	}

	// 根据用户名称模糊查询用户信息
	@Test
	public void testGetUserList2() {

		// 查询单个记录，根据用户id查询用户信息
		List<User> list = sqlSession.selectList("test.getUserList2", "张");
		System.out.println(list.size());
		for (User u : list) {
			System.out.println(u);
		}

	}

	// 插入
	@Test
	public void testInsertUserAfter() {

		User user = new User();
		user.setAddress("sz");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setUsername("uname09072");

		// 查询单个记录，根据用户id查询用户信息
		int code = sqlSession.insert("test.insertUserAfter", user);
		System.out.println(code);
		System.out.println("user_id=" + user.getId());

		// 提交事务
		sqlSession.commit();

	}

	// 插入
	@Test
	public void testInsertUserBefore() {

		User user = new User();
		user.setAddress("testbefore");
		user.setBirthday(new Date());
		user.setSex("0");

		// 查询单个记录，根据用户id查询用户信息
		int code = sqlSession.insert("test.insertUserBefore", user);
		System.out.println(code);
		System.out.println("user_id=" + user.getId());

		// 提交事务
		sqlSession.commit();

	}

	@Test
	public void testDelete() {
		int code = sqlSession.delete("test.deleteUser", 1);
		// 提交事务
		sqlSession.commit();
		System.out.println(code);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setAddress("update415");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("uname415");
		user.setId(12);

		int code = sqlSession.insert("test.updateUser", user);
		System.out.println(code);

		// 提交事务
		sqlSession.commit();
	}

}
