package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.NewsDao;
import po.News;
import utils.Utils;

public class TestPo {
	//根据父节点id查子节点数据
	@Test
	public void testPoGetChildrenByPid(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		NewsDao nd = sqlSession.getMapper(NewsDao.class);
		
		List<News> nwlist = nd.getChildrenByPid(2);
		
		for(News news : nwlist){
			System.out.println(news);
		}
		
		sqlSession.close();
	}
}
