package com.iotek.view;

import com.iotek.util.Util;

/**
 * 主页面
 * @author Administrator
 *
 */
public class MainMune {
	
	private StudentView stuView;
	public MainMune() {
		stuView =  new StudentView();
	}
	
	public void mune(){
		System.out.println("---欢迎来到学生管理系统----");
	 
		boolean flag = true;
		while(flag ){
			System.out.println("1:登录");
			System.out.println("2:注册");
			System.out.println("3:退出");
			
		 /**
		  * 登录之后
		  */
		String num = Util.getString("请输入你的选择:");
		switch (num) {
		case "1":
			stuView.login();
			break;
		case "2":
			stuView.regist();
			break;
		case "3":
			System.exit(0);
			break;

		default:
			System.out.println("输入错误,没有该选项");
			break;
		}
		
	}
		}

}
