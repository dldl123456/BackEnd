package service.impl;

import java.util.List;

import dao.EvaluateDao;
import dao.impl.EvaluateDaoImpl;
import entity.Evaluate;
import service.EvaluateService;

/**
 * 
 * @param 实现评论服务接口
 * @author zmx2321
 * 
 */

public class EvaluateServiceImpl implements EvaluateService {
	private int code = 0;  //sql执行状态
	
	private EvaluateDao evaluateDao;
	
	public EvaluateServiceImpl() {
		evaluateDao = new EvaluateDaoImpl();
	}
	
	//查询所有评论
	@Override
	public boolean querryEvaluate(List<Evaluate> evaluatelist){
		evaluatelist = evaluateDao.querryEvaluate();
		
		return evaluatelist == null ? false : true;
	}
	
	//添加评论
	@Override
	public boolean addEvaluate(Evaluate evaluate) {
		code = evaluateDao.addEvaluate(evaluate);
		
		return code == 0 ? false : true;
	}
	
	//根据id删除评论
	@Override
	public boolean deleteEvaluate(int evaluate_id) {
		code = evaluateDao.deleteEvaluate(evaluate_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		EvaluateServiceImpl esi = new EvaluateServiceImpl();
		
		//Evaluate evaluate = new Evaluate("123123", 1, 4);
		
		//查询所有评论
		//System.out.println(esi.querryEvaluate(evaluatelist));
		
		//添加评论
		/*Evaluate evaluate1 = new Evaluate("123123", 1, 4);
		System.out.println(esi.addEvaluate(evaluate1));*/
		
		//根据id删除评论
		System.out.println(esi.deleteEvaluate(1));
	}
}
