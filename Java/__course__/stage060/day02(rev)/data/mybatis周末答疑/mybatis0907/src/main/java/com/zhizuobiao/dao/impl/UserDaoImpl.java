package com.zhizuobiao.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.entity.User;

public class UserDaoImpl implements UserDao {

	// �Ự����
	private SqlSessionFactory sqlSessionFactory;

	// ���ݿ�Ựʵ��
	private SqlSession sqlSession;

	public UserDaoImpl() {
		try {
			// �����ļ�
			String resource = "mybatis-config.xml";
			// ��ȡ�����ļ���ת����������
			InputStream inputStream;

			inputStream = Resources.getResourceAsStream(resource);

			// ʹ��SqlSessionFactoryBuilder��xml�����ļ��д���SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// �������ݿ�Ựʵ��sqlSession
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertUser(User user) {
		int code = sqlSession.insert("test.insertUser", user);
		// �ύ����
		sqlSession.commit();
		sqlSession.close();
		return code;
	}

	public int updateUser(User user) {
		int code = sqlSession.insert("test.updateUser", user);
		// �ύ����
		sqlSession.commit();
		sqlSession.close();
		return code;
	}

	public int deleteUser(int id) {
		int code = sqlSession.delete("test.deleteUser", 1);
		// �ύ����
		sqlSession.commit();
		sqlSession.close();
		return code;
	}

	public User getUser(int id) {
		User user = sqlSession.selectOne("test.getUser", id);
		sqlSession.close();
		return user;
	}

	public List<User> getUserList() {
		// ��ѯ������¼�������û�id��ѯ�û���Ϣ
		List<User> list = sqlSession.selectList("test.getUserList", null);
		sqlSession.close();
		return list;
	}

}
