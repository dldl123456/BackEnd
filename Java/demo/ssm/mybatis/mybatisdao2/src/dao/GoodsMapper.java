package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import po.Goods;
import po.GoodsCondition;

public interface GoodsMapper {
	//添加商品
	public void addGoods(Goods goods);
	
	//根据id查询商品
	public Goods queryGoodsById(Integer id);
	
	//根据名称查询商品
	public List<Goods> queryGoodsByName(String goodsName);
	
	//根据商品条件搜索（价格区间）
	public List<Goods> queryGoodsCondition(GoodsCondition gc);
	
	//根据商品名称和id查询商品
	/*传2个参数，用map集合
	  map[key 0,1....param1,param2]
	 */
	//public Goods queryGoodsByNameAndId(String goodsName, Integer id);
	/*
	    第二种方法，用注解,
	    这里写了注解，Goods	Mapper.xml就可以用名称
	*/
	public Goods queryGoodsByNameAndId(@Param("goodsName")String goodsName, @Param("id")Integer id);
	
	//根据id和对象查询商品
	//（一个基本数据类型，一个对象）
	public Goods queryGoodsByIdAndGoods(Integer id, @Param("gds")Goods goods);
	
	//根据map集合查询商品
	public Goods queryGoodsByMap(Map<String, Object> map);
	
	//根据id和集合查询商品
	public Goods queryGoodsByIdAndList(Integer id, @Param("gdslist")List<Goods> goodsList);
}
