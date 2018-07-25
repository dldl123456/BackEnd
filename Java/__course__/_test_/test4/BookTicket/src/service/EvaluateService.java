package service;

import java.util.List;

import entity.Evaluate;

/**
 * 
 * @param 给评论服务提供接口
 * @author zmx2321
 *
 */

public interface EvaluateService {
	//添加评论
	public boolean addEvaluate(Evaluate evaluate);
	
	//查询所有评论
	public boolean querryEvaluate(List<Evaluate> evaluatelist);
	
	//根据id删除评论
	public boolean deleteEvaluate(int evaluate_id);
}
