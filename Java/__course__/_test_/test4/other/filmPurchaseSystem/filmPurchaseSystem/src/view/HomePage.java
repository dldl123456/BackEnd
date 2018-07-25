package view;

import view.choose.PageChoose;

public class HomePage {
	public static void homePage() {
		UserView.userNum=0;//重置
		System.out.println("欢迎进入小刘电影购票系统");
		System.out.println("请选择您的身份：");
		System.out.print("【1】、用户\t\t");
		System.out.print("【2】、管理员\t");
		System.out.println("【3】、退出系统");
		PageChoose.homeChoose();
	}
	
	public static void exitSystem() {
		System.out.println("感谢使用小刘电影购票系统，诚挚期待您的再次使用，谢谢！！！");
		System.exit(0);
	}
}
