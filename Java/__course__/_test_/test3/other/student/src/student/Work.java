package student;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		Student[]arr=Student.getStudent();//取得学生信息的对象
		Student[]arr1=Student.str();//取得学生账号数组
		int elements=arr.length;
		Student[]arr2=new Student[elements];
		Manager[]managers=Manager.getMarrays();//取得管理员数组
		boolean isAgin=false;
		Methodstu m=new Methodstu();
		int choice=0;
		do {
			Scanner in=new Scanner(System.in);
			try {
				m.Login();
				 choice=in.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (choice) {
				case 1:
				  do {
					  boolean isEnter=m.enter(in,arr1,arr, managers,isAgin,elements,m);
						if (isEnter) {
							isAgin=true;
						}else {
							isAgin=true;
							break;
						}	
					}while (isAgin);
						break;	
				case 2:
						List list=m.register(in,managers, arr1);//注册功能
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) instanceof Manager[]) {
								managers=(Manager[]) list.get(i);
							}else {
								arr1=(Student[]) list.get(i);
							}	
						}
						isAgin=true;
						break;
				case 3:
						System.out.println("程序结束！！");
						isAgin=false;
						break;
				default:
						System.out.println("您输入有误！");
						isAgin=true;
						break;
					}
		} while (isAgin);
		System.out.println("您已退出学生管理系统，程序结束");
	}
}
