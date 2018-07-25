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

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 数据库会话实例
	private SqlSession sqlSession;

	public UserDaoImpl() {
		try {
			// 配置文件
			String resource = "mybatis-config.xml";
			// 读取配置文件，转换成输入流
			InputStream inputStream;

			inputStream = Resources.getResourceAsStream(resource);

			// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertUser(User user) {
		int code = sqlSession.insert("test.insertUser", user);
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
		return code;
	}

	public int updateUser(User user) {
		int code = sqlSession.insert("test.updateUser", user);
		// 提交事务
		sqlSession.commit();
		sqlSession.close();
		return code;
	}

	public int deleteUser(int id) {
		int code = sqlSession.delete("test.deleteUser", 1);
		// 提交事务
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
		// 查询单个记录，根据用户id查询用户信息
		List<User> list = sqlSession.selectList("test.getUserList", null);
		sqlSession.close();
		return list;
	}

}
