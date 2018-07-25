package dao;

import java.util.List;

import entity.Evaluate;

/**
 * 
 * @param 给评论类提供数据接口
 * @author zmx2321
 *
 */

public interface EvaluateDao {
	//添加评论
	public int addEvaluate(Evaluate evaluate);
	
	//查询所有评论
	public List<Evaluate> querryEvaluate();
	
	//根据id删除评论
	public int deleteEvaluate(int evaluate_id);
}
