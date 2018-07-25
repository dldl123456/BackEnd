package com.iotek.view;

import com.iotek.util.Util;

public class MainViews {
	private UserView uv;
	private AdminView av;
	public MainViews(){
		uv=new UserView();
		av=new AdminView();
	}
	/**
	 * 系统运行时初始界面
	 */
	public void mainMovieView(){
		int choose;
		while(true){
			System.out.println("*********************************欢迎使用电影管理系统***************************************");
			 choose=Util.getInt("请输入你要选择的选项:1.登录 2.用户注册 0.退出");
			switch(choose){
			case 1:
				choose=Util.getInt("请输入你要选择的选项:1.用户登录 2.管理员登陆 0.退出");
				if(choose==1){
					uv.userView();
				}
				if(choose==2){
					av.adminView();
				}if(choose==0){
					System.out.println("谢谢使用电影管理系统，欢迎下次光临");
					return;
				}
				break;
			case 2:
				uv.register();//用户注册
				break;
			case 0:
				System.out.println("谢谢使用电影管理系统，欢迎下次光临");
				return;
				default:
					System.out.println("请输入正确选项");
					break;
			}
		}
		
	}
	
}
