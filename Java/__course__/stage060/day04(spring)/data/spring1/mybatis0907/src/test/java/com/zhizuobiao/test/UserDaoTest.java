package com.zhizuobiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	/**
	 * select * from user where sex = #{sex} or address = #{address}
	 */
	@Test
	public void testGetUserListMap() throws Exception {

		HashMap<String, String> queryMap = new HashMap<String, String>();

		queryMap.put("sex", "1");
		queryMap.put("address", "update415");

		// ��ȡmapper�ӿڵĴ������
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// ���ô�����󷽷�
		List<User> userList = userDao.getUserListMap(queryMap);
		System.out.println(userList.size());

		// java -- db
		// createTime -- create_time  mybatis�ṩ����ת������
		// newTime -- create_time  ֻ���ֶ����ö�Ӧ��ϵ

		// ������ foreach ѭ��д��
		userList.forEach((User u) -> {
			System.out.println(u);
		});

	}

	@Test
	public void testGetCount() throws Exception {

		// ��ȡmapper�ӿڵĴ������
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// ���ô�����󷽷�
		int count = userDao.getCount();
		System.out.println(count);

	}
	
	
	@Test
	public void testGetUserListMapDynamic() throws Exception {


		HashMap<String, String> queryMap = new HashMap<String, String>();

		queryMap.put("username", "415");
		queryMap.put("address", "update415");
		
		// ��ȡmapper�ӿڵĴ������
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// ���ô�����󷽷�
		List<User> userList = userDao.getUserListMapDynamic(queryMap);
		userList.forEach((User u) -> {
			System.out.println(u);
		});

	}
	
	
	@Test
	public void testGetUserListDynamicForeach() throws Exception {


		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(8);
		list.add(10);
		
		// ��ȡmapper�ӿڵĴ������
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		// ���ô�����󷽷�
		List<User> userList = userDao.getUserListDynamicForeach(list);
		userList.forEach((User u) -> {
			System.out.println(u);
		});

	}
}
