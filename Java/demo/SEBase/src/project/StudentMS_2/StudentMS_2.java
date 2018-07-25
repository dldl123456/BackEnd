package project.StudentMS_2;

import java.util.Scanner;

public class StudentMS_2 {
	static int num;
	static int[] stuId = new int[100];
	static String[] stuName = new String[100];
	static String[] stuSex = new String[100];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// stuId[0] = 1;
		// stuName[0] = "王大";
		// stuSex[0] = "男";
		menu();

	}

	private static void menu() {
		System.out.println("---菜单---");

		System.out.println("1.添加学生");
		System.out.println("2.删除学生");
		System.out.println("3.修改学生");
		System.out.println("4.查询学生");

		num = sc.nextInt();
		switch (num) {
		case 1:
			tianjia();
			break;
		case 2:
			shanchu();
			break;
		case 3:
			xiugai();
			break;
		case 4:
			chaxun();
			break;
		default:
			break;
		}
	}

	private static void shanchu() {
		System.out.println("--请输入需要删除的学号");
		int id = sc.nextInt();
		if (id < 100) {
			stuId[id - 1] = 0;
			stuName[id - 1] = null;
			stuSex[id - 1] = null;
			System.out.println("删除成功");
		} else {
			System.out.println("请输入正确学号（100以内）");
		}
		menu();
	}

	private static void chaxun() {
		// TODO Auto-generated method stub

		System.out.println("--查询学生请输入学号");
		System.out.println("1.---学号查询");
		System.out.println("2.---查询所有");
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("请输入学号");
			int i = sc.nextInt();

			System.out.println("学号:" + stuId[i - 1] + " 姓名:" + stuName[i - 1] + " 性别:" + stuSex[i - 1]);
			menu();
		} else if (num == 2) {
			for (int j = 0; j < stuId.length; j++) {
				System.out.println("学号:" + stuId[j] + " 姓名:" + stuName[j] + " 性别:" + stuSex[j]);
			}
		}
		menu();
	}

	private static void xiugai() {
		// TODO Auto-generated method stub
		System.out.println("--修改学生：请输入学号");

		int i = sc.nextInt();
		if (i < stuId.length) {
			System.out.println("输入新的姓名");
			String name = sc.next();
			stuName[i - 1] = name;
			System.out.println("输入性别");
			String sex = sc.next();
			stuSex[i - 1] = sex;
			System.out.println("新的信息为: " + "学号:" + stuId[i - 1] + " 姓名:" + stuName[i - 1] + " 性别:" + stuSex[i - 1]);

		} else {
			System.out.println("输入有误，请输入正确学号（100以内）");
		}
		menu();
	}

	private static void tianjia() {
		// TODO Auto-generated method stub
		System.out.println("--添加学生：请输入学号");

		int id = sc.nextInt();
		if (id < stuId.length) {
			System.out.println("请输入姓名");
			String name = sc.next();
			System.out.println("请输入性别");
			String sex = sc.next();
			stuId[id - 1] = id;
			stuName[id - 1] = name;
			stuSex[id - 1] = sex;

		} else {
			System.out.println("请输入正确的学号（100以内）");
		}
		menu();
	}

}