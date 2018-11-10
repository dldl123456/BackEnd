package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.AnimalsMapper;
import po.Animals;
import utils.Utils;

public class TestPo {
	@Test
	public void TestPoAddGoods(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		AnimalsMapper am = sqlSession.getMapper(AnimalsMapper.class);
		
		Animals ams = am.getAnimalsById(1);
		
		System.out.println(ams);
		
		sqlSession.close();
	}
}
