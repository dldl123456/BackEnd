package view;

import contro.EvaluateContro;
import contro.MovieControl;
import entity.User;
import util.Help;

/**
 * 
 * @param 评论界面
 * @author zmx2321
 * 
 */

public class EvaluateView {
	private static boolean flag = true;  //用于判断是否跳出循环
	
	public static void evaluateMune(User user){
		System.out.println("欢迎进入评论管理界面：");
		
		do{
			System.out.println("*********************");
			System.out.println("1:查看全部评论");
			System.out.println("2:添加评论");
			System.out.println("3:删除评论");
			System.out.println("0:返回");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n请输入您需要的操作：");
			
			switch (ops){
				case 1:
					System.out.println("查看全部评论：\n");
					EvaluateContro.queryEvaluate();
					
					break;
				case 2: 
					System.out.println("添加评论：\n");
					
					MovieControl.queryMoviesName();
					EvaluateContro.addEvaluate(user.getUser_id());
					EvaluateContro.queryEvaluate();
					
					break;
				case 3: 
					System.out.println("删除评论：\n");
					EvaluateContro.deleteEvaluate();
					
					break;
				case 0:
					System.out.println("返回\n");
					flag = false;
					
					break;
				default:
					System.out.println("输入错误,没有该选项\n");
					
					break;
			}
		}while(flag);
	}
	
	//test
	public static void main(String[] args) {
		User user = new User(1);
		
		evaluateMune(user);
	}
}
