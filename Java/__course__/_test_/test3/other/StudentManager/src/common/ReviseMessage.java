package common;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import entity.Person;
import test.Page;

/**
 * 修改信息，通用类
 * @author Administrator
 *
 */
public class ReviseMessage {
	static Scanner input = new Scanner(System.in);
	static int index = LoginTemplet.indexAccount;
	/**
	 * 修改当前账户的信息
	 */
	public static void reviseMa(Person [] pe) {
		/**
		 * 处理输入异常
		 */
		int cho = 0;
		cho =HandleInputMismatchException.handleInputMismatchException(cho);
		switch(cho) {
		case 1:
			System.out.println("请输入您要修改的年龄：");
			int newAge=0;
			newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
			pe[index].setAge(newAge);
			System.out.println("年龄已经修改，修改后的信息如下");
			assist(pe);
			break;
		case 2:
			System.out.println("请输入您要修改的地址：");
			pe[index].setAddress(input.next());
			System.out.println("地址已经修改，修改后的信息如下");
			assist(pe);
			break;
		case 3:
			System.out.println("请输入您要修改的爱好：");
			pe[index].setHobbys(input.next());
			System.out.println("爱好已经修改，修改后的信息如下");
			assist(pe);
			break;
		default:
			System.out.println("您输入的指令错误，请重新输入：");
			System.out.println("请输入要修改的选项：[1]、年龄\t[2]、地址\t\t[3]、爱好");
			/**
			 * 处理输入异常
			 */
			int choose = 0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			reviseMa(pe);
		}
		System.out.println("请选择下一步操作：");
		Page.loginSuccess();
	}
	/**
	 * 辅助方法
	 */
	private static void assist(Person [] pe){
		if(Page.choose1==2) {
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t"+"状态");
		}else {
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t" +"职位\t"+"状态");
		}
		System.out.println(pe[index]);
	}
}
