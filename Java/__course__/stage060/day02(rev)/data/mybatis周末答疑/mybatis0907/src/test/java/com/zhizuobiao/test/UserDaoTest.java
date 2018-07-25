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
 * ���Զ�̬�ӿڰ�
 */
public class UserDaoTest {

	// �Ự����
	private SqlSessionFactory sqlSessionFactory;

	// ���ݿ�Ựʵ��
	private SqlSession sqlSession;

	@Before
	public void createSqlSessionFactory() throws IOException {
		// �����ļ�
		String resource = "mybatis-config.xml";
		// ��ȡ�����ļ���ת����������
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// �������ݿ�Ựʵ��sqlSession
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

		// ��ȡmapper�ӿڵĴ������
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// ���ô�����󷽷�
		User user = userDao.getUser(12);
		System.out.println(user);

	}

}
