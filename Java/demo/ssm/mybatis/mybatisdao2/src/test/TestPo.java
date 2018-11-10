package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dao.GoodsMapper;
import po.Goods;
import po.GoodsCondition;
import utils.Utils;

public class TestPo {
	//添加商品
	//@Test
	public void TestPoAddGoods(){
		//开启一个会话
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		//拿到代理对象(接口)
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods goods = new Goods("banala", 200, 30);
		
		//代理对象使用接口方法
		gm.addGoods(goods);
		
		//人工提交事务
		sqlSession.commit();
		
		//关闭会话
		sqlSession.close();
	}
	
	//根据id查询商品
	//@Test
	public void TestPoQueryGoodsById(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods goods = gm.queryGoodsById(1);
		
		System.out.println(goods);
		
		sqlSession.close();
	}
	
	//根据名称查询商品
	//@Test
	public void TestPoQueryGoodsByName(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//查询出含有a的集合
		List<Goods> goodsList = gm.queryGoodsByName("a");
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据商品条件搜索（价格区间）
	//@Test
	public void TestPoQueryGoodsCondition(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//没有写构造方法，直接赋值
		GoodsCondition gc = new GoodsCondition();
		gc.setMinPrice(200);
		gc.setMaxPrice(800);
		
		List<Goods> goodsList = gm.queryGoodsCondition(gc);
		
		for(Goods goods : goodsList){
			System.out.println(goods);
		}
		
		sqlSession.close();
	}
	
	//根据商品名称和id查询商品
	//@Test
	public void TestPoQueryGoodsByNameAndId(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods goods = gm.queryGoodsByNameAndId("apple", 1);
		
		System.out.println(goods);
		
		sqlSession.close();
	}
	
	//根据id和对象查询商品
	//@Test
	public void TestPoQueryGoodsByIdAndGoods(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		Goods gds = new Goods();
		gds.setGoodsName("TV");
		
		Goods goods = gm.queryGoodsByIdAndGoods(2, gds);
		
		System.out.println(goods);
		
		sqlSession.close();
	}
	
	//根据map集合查询商品
	//@Test
	public void TestPoQueryGoodsByMap(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//要传集合进来，要创建一个集合(实例化一个hashmap)
		Map<String, Object> map = new HashMap<>();
		//在map里面插入值
		map.put("id", 2);
		map.put("goodsName", "TV");
		
		Goods goods = gm.queryGoodsByMap(map);
		
		System.out.println(goods);
		
		sqlSession.close();
	}
	
	//根据id和集合查询商品
	@Test
	public void TestPoQueryGoodsByIdAndList(){
		SqlSession sqlSession = Utils.getSqlSessionFactory().openSession();
		
		GoodsMapper gm = sqlSession.getMapper(GoodsMapper.class);
		
		//创建对象(sql只取了集合中的第一个元素)
		Goods gds1 = new Goods();
		gds1.setGoodsName("TV");
		
		//创建集合
		List<Goods> gdsList = new ArrayList<>();
		gdsList.add(gds1);
		
		Goods goods = gm.queryGoodsByIdAndList(2, gdsList);
		
		System.out.println(goods);
		
		sqlSession.close();
	}
}
