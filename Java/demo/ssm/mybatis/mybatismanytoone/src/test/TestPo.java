package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.UserDao;
import po.User;
import utils.Utils;

public class TestPo {
	//根据组id查找用户信息
	@Test
	public void testPoGetGroupById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		UserDao  ud = sqlSession.getMapper(UserDao.class);
   	 
		User user = ud.getUserById(2);
		
		System.out.println(user);
		
		sqlSession.close();
	}
}
