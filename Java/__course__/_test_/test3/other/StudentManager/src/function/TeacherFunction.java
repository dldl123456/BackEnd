  package function;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.StudentArr;
import arrays.TeacherArr;
import common.HandleInputMismatchException;
import common.RankingList;
import common.ReviseMessage;
import entity.Teacher;
import operate.TeacherOperate;
import test.Page;
/**
 * 本类为管理员登陆后操作的具体实现类，包含所有功能的实现
 * @author Administrator
 *
 */
public class TeacherFunction extends TeacherArr{
	Scanner input = new Scanner(System.in);
	StudentArr stuArr = new StudentArr();
	int stuIndex=-1;//用来存放拿到的学生姓名下标
	String stuName;//用来接收键盘输入的学生姓名
	/**
	 * 实现所有选项功能
	 */
	public void overall() {
		/**
		 * 处理输入异常
		 */
		int choose = 0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);	
		switch(choose) {
		case 1://查看所有学生信息
			System.out.println("所有学生信息如下：");
			System.out.println("账号\t"+ "姓名\t"+"年龄\t"+"性别\t"+"家庭住址\t"+"兴趣爱好\t"+"状态");
			stuArr.ergodicStuu();
			break;
		case 2://查看单个学生信息
			System.out.println("请输入要查看的学生姓名：");
			stuName = input.next();
			stuArr.sayStuuOfName(stuName);
			break;
		case 3://查看成绩排行榜
			RankingList.sayRankingList();
			break;
		case 4://查看所有学生成绩
			System.out.println("所有学生成绩如下：");
			System.out.println("姓名\t语文成绩\t数学成绩\t英语成绩\t总成绩");
			stuArr.ergodicStuuScore();
			break;
		case 5://修改学生成绩
			System.out.println("请输入要修改的学生姓名：");
			stuName = input.next();
			stuArr.reviseStuuScore(stuName);
			break;
		case 6://添加学生
			stuArr.addStu();
			break;
		case 7://注销学生信息
			stuArr.deleteStu();
			break;
		case 8://查看账户信息
			System.out.println("以下是您的账户信息：");
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t" +"职位\t"+"状态");
			int i = LoginTemplet.indexAccount;
			Teacher tt = tc[i]; 
			System.out.println(tt.toString());
			break;
		case 9://修改账户信息
			System.out.println("请输入要修改的选项：[1]、年龄\t[2]、地址\t\t[3]、爱好");
			ReviseMessage.reviseMa(tc);
			break;
		case 10://修改账户密码(局部内部类)
			class Inner extends RevisePassword {
				public void againLogin() {						
					LoginTemplet lt = new TeacherOperate();//多态
					lt.Login();
				}
			}
			Inner in = new Inner();
			in.revisePassword(tc);
			break;
		case 11://返回主页面
			Page.homePage();
			break;
		case 12://退出系统
			Page.exit();
			break;
		default:
			System.out.println("您输入的指令有误，已为您切换到功能列表，请重新输入：");
			break;
		}
		System.out.println("请选择您的下一步操作：");
		Page.loginSuccess();
	}
	
}
