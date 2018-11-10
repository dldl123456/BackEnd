/*
 *  一级缓存
 *  只执行一次sql语句，第二次没有在sql查，它是从内存（SqlSession）查的
 */

package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.CardDao;
import po.CardNo;
import utils.Utils;

public class TestPo {
	//根据用户id查身份证
	@Test
	public void testPoGetPersonById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		CardDao cd = sqlSession.getMapper(CardDao.class);
		
		//第一次查存到sqlSession缓存
		CardNo cardno = cd.getPersonById(1);
		
		System.out.println(cardno);
		System.out.println(cardno.getPerson().getPname());
		
		//第二次查直接从缓存中查
		CardNo cardno1 = cd.getPersonById(1);
		
		System.out.println(cardno1);
		System.out.println(cardno1.getPerson().getPname());
		
		//清楚sqlSession缓存，执行sql，查数据库
		sqlSession.clearCache();
		CardNo cardno2 = cd.getPersonById(1);
		
		System.out.println(cardno2);
		System.out.println(cardno2.getPerson().getPname());
		
		//将他关闭之后查手动要重新开启一个会话，再次执行sql
		sqlSession.close();
		
		SqlSession sqlSession2 = Utils.getSqlSessionFactory().openSession();
		CardDao cd2 = sqlSession2.getMapper(CardDao.class);
		
		CardNo cardno3 = cd2.getPersonById(1);
		
		System.out.println(cardno3);
		System.out.println(cardno3.getPerson().getPname());
		
	}
}
