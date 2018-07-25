package com.zhizuobiao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.entity.User;

/**
 * 测试动态接口绑定
 */
public class UserDaoTest {

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

	@Test
	public void testGetUser() throws Exception {

		// 获取mapper接口的代理对象
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// 调用代理对象方法
		User user = userDao.getUser(12);
		System.out.println(user);

	}

}
