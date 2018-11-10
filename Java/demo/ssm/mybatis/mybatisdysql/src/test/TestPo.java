package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.GoodsMapper;
import po.Goods;
import util.Utils;

public class TestPo {
	//根据条件查询商品（动态sql-If）
	//@Test
	public void testPoQueryGoodsByIf(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods gds = new Goods();
		gds.setGoodsName("a");  //如果为空，查出所有
		gds.setPrice(300);	//在price大于0的结果集中查询price大于300的数据
		
		List<Goods> goodsList = gm.queryGoodsByIf(gds);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据条件查询商品（动态sql-Where）
	//@Test
	public void testPoQueryGoodsByWhere(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods gds = new Goods();
		gds.setGoodsName("a");  //如果为空，查出所有
		gds.setPrice(300);	//在price大于0的结果集中查询price大于300的数据
		
		//查询价格在300以上包含a的所有商品数据
		List<Goods> goodsList = gm.queryGoodsByWhere(gds);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据条件查询商品（动态sql-Choose）
	//@Test
	public void testPoQueryGoodsByChoose(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods gds = new Goods();
		gds.setGoodsName("a");  //如果为空，查出所有
		gds.setPrice(300);	//在price大于0的结果集中查询price大于300的数据
		
		//当第一个条件满足，第二个条件不执行，当第一个条件不满足，第一个条件执行
		List<Goods> goodsList = gm.queryGoodsByChoose(gds);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据条件查询商品（动态sql-Foreach）传一个数组进去
	//@Test
	public void testPoQueryGoodsByForeach(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//初始化一个数组
		int[] ids = {1, 3};
		
		//调用接口方法
		List<Goods> goodsList = gm.queryGoodsByForeach(ids);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据条件查询商品（动态sql-Foreach）传一个集合进去
	//@Test
	public void testPoQueryGoodsByForeach2(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//初始化一个集合
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		
		//调用接口方法
		List<Goods> goodsList = gm.queryGoodsByForeach2(ids);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据条件查询商品（动态sql-Foreach）传一个集合对象进去
	@Test
	public void testPoQueryGoodsByForeach3(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//集合中是对象，先实例化对象
		Goods gds1 = new Goods();
		gds1.setId(1);
		
		Goods gds2 = new Goods();
		gds2.setId(3);
		
		//初始化一个集合
		List<Goods> gdslist = new ArrayList<>();
		gdslist.add(gds1);
		gdslist.add(gds2);
		
		//调用接口方法
		List<Goods> goodsList = gm.queryGoodsByForeach3(gdslist);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
}
