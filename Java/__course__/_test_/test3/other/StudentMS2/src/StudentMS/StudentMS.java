/*
 *  学生管理系统
 *  (必须使用面向对象)
 *  登录、注册、增加、删除、修改、查询
 *  课程管理(不会做多门课程就做一门课程)
 *  成绩、排行榜、异常处理
 *  删除时：数组中间不允许留空
 *  提高部分：验证码 
 */

package StudentMS;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentMS {
	public static void main(String[] args) {
		//声明变量
		int num = 0;  //用来保存用户的输入
		boolean isTrue = false;  //用来判断是否进入
		
		//实例化
		Student[] stuInfo = Student.getStudent();  //实例化学生信息对象数组
		Student[] stuAccount = Student.stuAccount();  //实例化学生账号对象数组
		Administrator[] adminAccount = Administrator.adminAccount();  //实例化管理员账号对象数组
		
		BaseMethod m = new BaseMethod();  //实例化方法类

		Scanner in=new Scanner(System.in);  //输入
		
		do{
			//主界面
			System.out.println("--欢迎进入学生管理系统--");
			System.out.println("[1]登录     [2]注册     [3]退出\n");
			System.out.print("请选择您需要的操作：");
			
			try{
				num = in.nextInt();  //让用户输入需要选择的项目
			}catch(InputMismatchException e){
				System.out.println("非法输入，程序结束!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					System.out.println("管理员：");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					System.out.println("学生：");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
					m.login(in, m, stuAccount, stuInfo, adminAccount);
					isTrue = true;  //继续循环
					break;
				case 2:
					List list=m.register(in, m, adminAccount, stuAccount, stuInfo);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) instanceof Student[]) {
							stuAccount=(Student[]) list.get(i);//强制转换
						}else {
							adminAccount=(Administrator[]) list.get(i);
						}
					}
					System.out.println("管理员：");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					System.out.println("学生：");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
					isTrue = true;  //继续循环
					break;
				case 3:
					System.out.println("\n您已退出学生管理系统");
					isTrue = false;  //跳出循环
					break;
				default:
					System.out.println("您的输入有误");
					isTrue = true;  //继续循环
					break;
			}
		}while(isTrue);
		
		//程序结束
		System.out.println("欢迎下次使用！");
		in.close();  //关闭键盘
		System.exit(0);
	}
}
