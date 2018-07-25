package function;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.ManagerArr;
import arrays.TeacherArr;
import common.HandleInputMismatchException;
import common.ReviseMessage;
import operate.ManagerOperate;
import test.Page;
/**
 * 本类为管理员登陆后操作的具体实现类，包含所有功能的实现
 * @author Administrator
 *
 */
public class ManagerFunction extends ManagerArr{
	Scanner input = new Scanner(System.in);
	TeacherArr tcArr =new TeacherArr();
	int tcIndex=-1;//用来存放拿到的老师姓名下标
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
		case 1://查看所有管理员信息
			System.out.println("所有管理员信息如下：");
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t" +"职位\t"+"状态");
			ergodicMa();
			break;
		case 2://查看所有老师信息
			System.out.println("所有老师信息如下：");
			tcArr.ergodicTc();
			break;
		case 3://查看单个老师信息
			System.out.println("请输入要查看的老师姓名：");	
			String tcName = input.next();
			tcArr.sayTcOfName(tcName);
			break;
		case 4://添加老师
			tcArr.addTeacher();
			break;
		case 5://注销老师信息
			tcArr.deleteStu();
			break;
		case 6://查看账户信息
			System.out.println("以下是你的个人信息：");
			int index = LoginTemplet.indexAccount;
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t" +"职位\t"+"状态");
			System.out.println(ma[index]);
			break;
		case 7://修改账户信息
			System.out.println("请输入要修改的选项：[1]、年龄\t[2]、地址\t\t[3]、爱好");
			ReviseMessage.reviseMa(ma);
			break;
		case 8://修改账户密码(匿名内部类)
			new RevisePassword() {
				public void againLogin() {
					LoginTemplet lt = new ManagerOperate();//多态
					lt.Login();
				}
			}.revisePassword(ma);//子类调用父类方法
			break;
		case 9://注销此账户
			deleteMan();
			break;
		case 10://返回主页面
			Page.homePage();
			break;
		case 11://退出系统
			System.out.println("谢谢使用本系统，欢迎您再次使用！！！");
			System.exit(0);
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
