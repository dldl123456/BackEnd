package com.iotek.view;

import com.iotek.entity.Admin;
import com.iotek.service.IAdminFunctions;
import com.iotek.service.impl.AdminFunctions;
import com.iotek.util.Util;

public class AdminView {
	IAdminFunctions af=new AdminFunctions();
	public void adminView(){
		Admin ad=af.login();
		if(ad==null){
			System.out.println("登陆失败");
			return;
		}
		System.out.println("欢迎"+ad.getName()+"登陆");
		while(true){
			System.out.println("********************************************************");
			int choose=Util.getInt("请输入选项：1.电影\t2.影院\t3.场次\t4.更多选项\t0.退出 ");//电影票\t5.
			switch(choose){
			case 1:
				af.movieOptions();
				break;
			case 2:
				af.theaterOptions();
				break;
			case 3:
				af.showplanOptions();
				break;
			/*case 4:
				af.ticketOptions();
				break;*/
			case 4:
				if(moreView(ad)){
					break;
				}else{
					return;
				}
			case 0:
				System.out.println("***************************谢谢使用电影管理系统***************************");
				return;
				default :
					System.out.println("请输入正确选项！！！");
					break;
			}
			
		}
	}
	public boolean moreView(Admin ad){
		int choose2;
		while(true){
			choose2=Util.getInt("请输入选项 ：1.更改管理员信息 \t2.注册新管理员\t3.修改密码\t4.返回上一步\t0.退出");//待做功能：修改个人信息\t5.
			switch(choose2){
				case 1:
					af.updateAdmin(ad);
					break;
				case 2:
					if(af.register(ad)){
						break;
					}
					return false;
				case 3:
					String isSure=Util.getString("确认修改1.确认（修改之后需要重新登陆）");
					if(isSure.equals("1")){
						if(af.updatePsw(ad)){
							System.out.println("修改成功！");
						}return false;
					}
					break;
				case 4:
					return true;
				case 0:
					return false;
				default :
					System.out.println("请输入正确选项!!!");
					break;
				}
			}
	}
}
