package dao;

import java.util.List;

import po.Goods;

public interface GoodsMapper {
	//根据条件查询商品（动态sql-If）
	public List<Goods> queryGoodsByIf(Goods goods);
	
	//根据条件查询商品（动态sql-Where）
	public List<Goods> queryGoodsByWhere(Goods goods);
	
	//根据条件查询商品（动态sql-Choose）
	public List<Goods> queryGoodsByChoose(Goods goods);
	
	//根据条件查询商品（动态sql-Foreach）传一个数组进去
	public List<Goods> queryGoodsByForeach(int[] ids);
	
	//根据条件查询商品（动态sql-Foreach）传一个集合进去
	public List<Goods> queryGoodsByForeach2(List<Integer> ids);
	
	//根据条件查询商品（动态sql-Foreach）传一个集合对象进去
	public List<Goods> queryGoodsByForeach3(List<Goods> goods);
}
