package test;

import java.util.Iterator;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.GroupDao;
import po.Group;
import po.User;
import utils.Utils;

public class TestPo {
	//根据组id查找用户信息
	@Test
	public void testPoGetGroupById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GroupDao  gd=sqlSession.getMapper(GroupDao.class);
   	 
		Group group = gd.getGroupById(1);
		
		System.out.println(group.getGid() + "、" + group.getGname());
		
		//用迭代器遍历
		Iterator<User> iter = group.getUsers().iterator();
		while(iter.hasNext()){
			User user = iter.next();
			System.out.println(user.getUname());
		}
		
		sqlSession.close();
	}
}
