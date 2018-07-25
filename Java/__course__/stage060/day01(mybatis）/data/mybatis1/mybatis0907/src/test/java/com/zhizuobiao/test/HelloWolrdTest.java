package com.zhizuobiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhizuobiao.entity.User;

public class HelloWolrdTest {

	// �Ự����
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void createSqlSessionFactory() throws IOException {
		// �����ļ�
		String resource = "mybatis-config.xml";
		// ��ȡ�����ļ���ת����������
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	// ���� id��ѯ�û���Ϣ
	@Test
	public void testGetUser() {
		// ���ݿ�Ựʵ��
		SqlSession sqlSession = null;
		try {
			// �������ݿ�Ựʵ��sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// ��ѯ������¼�������û�id��ѯ�û���Ϣ
			User user = sqlSession.selectOne("test.getUser", 7);
			// ����û���Ϣ
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// �����û�����ģ����ѯ�û���Ϣ
	@Test
	public void testGetUserList() {
		// ���ݿ�Ựʵ��
		SqlSession sqlSession = null;
		try {
			// �������ݿ�Ựʵ��sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// ��ѯ������¼�������û�id��ѯ�û���Ϣ
			List<User> list = sqlSession.selectList("test.getUserList", null);
			System.out.println(list.size());
			for (User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// �����û�����ģ����ѯ�û���Ϣ
	@Test
	public void testGetUserList2() {
		// ���ݿ�Ựʵ��
		SqlSession sqlSession = null;
		try {
			// �������ݿ�Ựʵ��sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// ��ѯ������¼�������û�id��ѯ�û���Ϣ
			List<User> list = sqlSession.selectList("test.getUserList2", "��");
			System.out.println(list.size());
			for (User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// ����
	@Test
	public void testInsertUser() {
		// ���ݿ�Ựʵ��
		SqlSession sqlSession = null;
		try {
			// �������ݿ�Ựʵ��sqlSession
			sqlSession = sqlSessionFactory.openSession();

			User user = new User();
			user.setAddress("sz");
			user.setBirthday(new Date());
			user.setSex("0");
			user.setUsername("uname09072");

			// ��ѯ������¼�������û�id��ѯ�û���Ϣ
			int code = sqlSession.insert("test.insertUser", user);
			System.out.println(code);
			System.out.println("user_id=" + user.getId());

			// �ύ����
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
