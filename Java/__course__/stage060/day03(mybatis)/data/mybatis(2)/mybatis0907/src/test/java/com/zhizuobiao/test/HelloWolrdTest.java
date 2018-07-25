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

	// ���� id��ѯ�û���Ϣ
	@Test
	public void testGetUser() {
		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		User user = sqlSession.selectOne("test.getUser", 7);
		// ����û���Ϣ
		System.out.println(user);

	}

	// �����û�����ģ����ѯ�û���Ϣ
	@Test
	public void testGetUserList() {

		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		List<User> list = sqlSession.selectList("test.getUserList", null);
		System.out.println(list.size());
		for (User u : list) {
			System.out.println(u);
		}

	}

	// �����û�����ģ����ѯ�û���Ϣ
	@Test
	public void testGetUserList2() {

		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		List<User> list = sqlSession.selectList("test.getUserList2", "��");
		System.out.println(list.size());
		for (User u : list) {
			System.out.println(u);
		}

	}

	// ����
	@Test
	public void testInsertUserAfter() {

		User user = new User();
		user.setAddress("sz");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setUsername("uname09072");

		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		int code = sqlSession.insert("test.insertUserAfter", user);
		System.out.println(code);
		System.out.println("user_id=" + user.getId());

		// �ύ����
		sqlSession.commit();

	}

	// ����
	@Test
	public void testInsertUserBefore() {

		User user = new User();
		user.setAddress("testbefore");
		user.setBirthday(new Date());
		user.setSex("0");

		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		int code = sqlSession.insert("test.insertUserBefore", user);
		System.out.println(code);
		System.out.println("user_id=" + user.getId());

		// �ύ����
		sqlSession.commit();

	}

	@Test
	public void testDelete() {
		int code = sqlSession.delete("test.deleteUser", 1);
		// �ύ����
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

		// �ύ����
		sqlSession.commit();
	}

}
