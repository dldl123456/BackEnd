package view;

import contro.EvaluateContro;
import contro.MovieControl;
import contro.TicketContro;
import contro.UserContro;
import entity.User;
import util.Help;

/**
 * 
 * @param 用户界面
 * @author zmx2321
 * 
 */

public class UserView {
	private static boolean flag = true;  //用于判断是否跳出循环
	
	//用户界面
	public static void userMune(User user) {
		System.out.println("欢迎进入用户界面：");
		
		do{
			System.out.println("*********************");
			System.out.println("1:购票");
			System.out.println("2:电影查询");
			System.out.println("3:充值");
			System.out.println("4:我的评论");
			System.out.println("5:个人信息");
			System.out.println("0:返回");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n请输入您需要的操作：");
			
			switch (ops){
				case 1:
					System.out.println("购票：\n");
					TicketContro.addTicket(user.getUser_id());
					
					break;
				case 2: 
					System.out.println("电影查询：\n");
					MovieControl.queryMovies();
					
					break;
				case 3: 
					System.out.println("您正在进行充值操作：\n");
					UserContro.updateAccount(user.getUser_id());
					
					break;
				case 4: 
					System.out.println("我的评论：\n");
					
					MovieControl.queryMoviesName();
					
					EvaluateContro.addEvaluate(user.getUser_id());
					
					EvaluateContro.queryEvaluate();
					
					break;
				case 5: 
					System.out.println("个人信息：\n");
					UserContro.PersonalInformation(user.getUser_id());  //user_id
					break;
				case 0:
					System.out.println("返回\n");
					flag = false;
					break;
				default:
					System.out.println("输入错误,没有该选项\n");
					break;
			}
		} while (flag);
	}
	
	//用户管理界面
	public static void userAdminMune(){
		System.out.println("欢迎进入用户管理界面：");
		
		do{
			System.out.println("*********************");
			System.out.println("1:查看全部用户");
			System.out.println("2:添加用户");
			System.out.println("3:删除用户");
			System.out.println("0:返回");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n请输入您需要的操作：");
			
			switch (ops){
				case 1:
					System.out.println("查看全部用户：\n");
					UserContro.queryUsers();
					break;
				case 2: 
					System.out.println("添加用户：\n");
					UserContro.regist();
					
					break;
				case 3: 
					System.out.println("删除用户：\n");
					UserContro.deleteUser();
					
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
		//User user = new User(1);
		
		//userMune(user);
		
		userAdminMune();
	}
}
