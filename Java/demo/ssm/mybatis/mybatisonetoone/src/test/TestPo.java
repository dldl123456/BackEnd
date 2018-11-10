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
		
		CardNo cardno = cd.getPersonById(1);
		
		System.out.println(cardno);
		System.out.println(cardno.getPerson().getPname());
		
		sqlSession.close();
	}
}
