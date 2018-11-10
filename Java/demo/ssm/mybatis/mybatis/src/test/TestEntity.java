package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.User;

public class TestEntity {
	@Test
	public void TestInsertUser(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sessionFactory.openSession();
			
			User user = new User("aaa", "555");
			
			int num = sqlSession.insert("entity.insertUser", user);
			
			sqlSession.commit();
			
			System.out.println("影响了" + num + "行");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
