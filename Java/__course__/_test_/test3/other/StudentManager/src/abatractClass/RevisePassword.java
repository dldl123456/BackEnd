package abatractClass;

import java.util.Scanner;

import entity.Person;
/**
 * 公用类  抽象类
 * 用于修改账户密码
 * @author Administrator
 *说明，抽象类，内含重新登录的抽象方法,继承此类的内部类实现此方法
 */
public abstract class RevisePassword {
	Scanner input = new Scanner(System.in);
	/**
	 * 修改密码的方法
	 * @param pe三种身份的父类数组
	 */
	public void revisePassword(Person [] pe) {
		int w = LoginTemplet.indexAccount;
		System.out.println("请输入旧密码：");
		String oldPw = input.next();
		if(oldPw.equals(pe[w].getPassword())) {
			a:while(true) {
				System.out.println("请输入新密码：");
				String newPw =input.next();
				if(oldPw.equals(newPw)) {
					System.out.println("新密码不能与原密码相同，请重新设置新密码：");
					continue a;
				}
				int con =0;
				b:while(true) {
					con++;
					if(con>3) {
						System.out.println("确认密码次数超限,请重新修改密码：");
						revisePassword(pe);
					}else {
						System.out.println("请确认新密码："); 
						String newPw1 = input.next();
						if(newPw.equals(newPw1)) {
							pe[w].setPassword(newPw1);
							System.out.println("密码修改成功，请重新登录：");
							LoginTemplet.indexPassword=-1;
							LoginTemplet.indexAccount=-1;
							againLogin();
						}else {
							System.out.println("确认密码错误，请重新确认密码：");     
							continue b;
						}							
					}
					break;
				}
				break;
			}						
		}else {
			System.out.println("密码输入错误，请重新输入:");
			revisePassword(pe);
		}
	}
	/**
	 * 重新登录方法，继承后重写使用
	 */
	public abstract void againLogin();
}
