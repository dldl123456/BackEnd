package function;


import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.StudentArr;
import common.HandleInputMismatchException;
import common.RankingList;
import common.ReviseMessage;
import entity.Student;
import operate.StudentOperate;
import test.Page;
/**
 * 本类为管理员登陆后操作的具体实现类，包含所有功能的实现
 * @author Administrator
 *
 */
public class StudentFunction extends StudentArr{
	/**
	 * 实现所有选项功能
	 */
	public void overall() {
		/**
		 * 处理输入异常
		 */
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://查看账户信息
			System.out.println("以下是你的个人信息：");
			System.out.println("账号\t"+ "姓名\t"+"年龄\t"+"性别\t"+"家庭住址\t"+"兴趣爱好\t"+"状态");
			int index = LoginTemplet.indexAccount;
			Student ss = stuu[index]; 
			System.out.println(ss);
			break;
		case 2://修改账户信息
			System.out.println("请输入要修改的选项：[1]、年龄\t[2]、地址\t\t[3]、爱好");
			ReviseMessage.reviseMa(stuu);
			break;
		case 3://查看考试成绩（本人）
			System.out.println("以下是你本次考试的成绩清单：");
			System.out.println("姓名\t语文成绩\t数学成绩\t英语成绩\t总成绩");
			int e = LoginTemplet.indexAccount;
			Student exam = stuu[e];
			System.out.println(exam.toString2());
			break;
		case 4://查看成绩排行榜
			RankingList.sayRankingList();
			break;
		case 5://修改账户密码(局部内部类)
			class Inner extends RevisePassword {
				public void againLogin() {						
					LoginTemplet lt = new StudentOperate();//多态
					lt.Login();
				}
			}
			Inner in = new Inner();
			in.revisePassword(stuu);
			break;
		case 6://返回主页面
			Page.homePage();
			break;
		case 7://退出
			Page.exit();
			break;
		default:
			System.out.println("您输入的指令有误，已为您切换到功能列表，请重新输入：");
			Page.loginSuccess();
			break;
		}
		System.out.println("请选择您的下一步操作：");
		Page.loginSuccess();
	}
}
