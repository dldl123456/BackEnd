package contro;

import java.util.List;

import dao.EvaluateDao;
import dao.impl.EvaluateDaoImpl;
import entity.Evaluate;
import service.EvaluateService;
import service.impl.EvaluateServiceImpl;
import util.Help;

/**
 * 
 * @param 评论控制层
 * @author zmx2321
 * 
 */


public class EvaluateContro {
	static EvaluateService evaluateService = new EvaluateServiceImpl();
	static EvaluateDao evaluateDao = new EvaluateDaoImpl();
	
	//查询所有评论
	public static void queryEvaluate(){
		List<Evaluate> evaluateList = evaluateDao.querryEvaluate();
		
		if (evaluateList.isEmpty()) {
			System.out.println("暂无评论！");
			return;
		}
		
		boolean success = evaluateService.querryEvaluate(evaluateList);
		
		if(success){
			for(Evaluate evaluate : evaluateList){
				System.out.println(evaluate.getEvaluate_id() + "、" + 
					evaluate.getMovie().getMovie_name() + "\n" + 
					evaluate.getUser().getUser_name() + "\n" + 
					evaluate.getEvaluate_content() + " \n" + 
					evaluate.getEvaluate_time() + "\n"
				);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		evaluateList.clear();
	}
	
	//添加评论
	public static Evaluate addEvaluate(int user_id){
		int movie_id = Help.getInt("请输入您需要评论的电影编号：");
		String evaluate_content = Help.getString("请填写您的评价：");
		
		Evaluate evaluate = new Evaluate(evaluate_content, movie_id, user_id);
		
		boolean success = evaluateService.addEvaluate(evaluate);
		
		if (success) {
			System.out.println("评价成功！\n");
			return evaluate;
		} else {
			System.out.println("评价失败！\n");
			return null;
		}
	}
	
	//根据id删除评论
	public static void deleteEvaluate(){
		queryEvaluate();
		
		int evaluate_id = Help.getInt("请输入您要删除的评论编号：");
		
		boolean success = evaluateService.deleteEvaluate(evaluate_id);
		
		if(success){
			System.out.println("评论删除成功！\n");
			queryEvaluate();
		}else{
			System.out.println("评论删除失败！\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//添加评论
		//addEvaluate(1);
		
		//查询所有评论
		queryEvaluate();
		
		//根据id删除评论
		//deleteEvaluate();
	}
}
