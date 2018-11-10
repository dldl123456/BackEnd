package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import po.User;

public class TestPo {
	//@Test
	public void TestPoSelectUserById(){
		try {
			//读取xml配置文件
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			//会话工厂类（字符流的方式）
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//从sqlSession从SqlSessionFaction工厂类获取sqlsession对象
			//sqlSession对象封装对sql语句的所有操作
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//找到命名空间下的名字,参数（id）
			User user = sqlSession.selectOne("po.selectUserById", 2);
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//insert有事务
	//@Test
	public void TestPoInsertUser(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			User user = new User("eee", "dfde", 78);
			
			int num = sqlSession.insert("po.insertUser", user);
			
			//未提交（没有持久化）之前，在内存中
			//映射了之后，人工提交事务，永久写入磁盘
			sqlSession.commit();
			
			System.out.println("影响了" + num + "行");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//修改
	//@Test
	public void TestPoUpdateUserById(){
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			User user = new User("88", "ll", 4);
			user.setId(2);
			
			int num = sqlSession.update("po.updateUserById", user);
			
			sqlSession.commit();
			
			System.out.println("影响了" + num + "行");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//修改
	//@Test
	public void TestPoDeleteUserById(){
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			int num = sqlSession.delete("po.deleteUserById", 5);
			
			sqlSession.commit();
			
			System.out.println("影响了" + num + "行");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void TestPoSelectUserByUserName1(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//找到命名空间下的名字,参数（id）
			List<User> userList = sqlSession.selectList("po.selectUserByUserName1", "zs");
			
			for(User user : userList){
				System.out.println(user);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestPoSelectUserByUserName2(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("sqlmapconfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			User user = new User();
			user.setUsername("zs");
			
			//找到命名空间下的名字,参数（id）
			List<User> userList = sqlSession.selectList("po.selectUserByUserName", user);
			
			Iterator<User> it = userList.iterator();
			while(it.hasNext()){
				User users = it.next();  
				System.out.println(users);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
