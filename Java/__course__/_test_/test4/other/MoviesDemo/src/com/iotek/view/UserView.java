package com.iotek.view;

import com.iotek.entity.User;
import com.iotek.service.IUserFunctions;
import com.iotek.service.impl.UserFunctions;
import com.iotek.util.Util;

public class UserView {
	private IUserFunctions uf;
	public UserView(){
		uf=new UserFunctions();
	}
	/**
	 * 用户的拓展界面
	 */
	public boolean moreUserView(User u){
		int choose2;
		while(true){
			choose2=Util.getInt("请输入选项 ：1.影评\t2.充值\t3.修改密码\t4.返回上一步\t0.退出");//待做功能：修改个人信息\t5.
			switch(choose2){
				case 1:
					uf.reviewOptions(u);
					break;
				case 2:
					System.out.println("尊敬的"+u.getName()+"，你好，你当前账户余额为："+u.getBalance());
					uf.rechargeOptions(u);
					break;
				case 3:
					String isSure=Util.getString("确认修改1.确认（修改之后需要重新登陆）");
					if(isSure.equals("1")){
						if(uf.updatePsw(u)){
							return false;
						}
					}
					break;
//				case 4:
//					uf.updateUser(u);
//					break;
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
	/**
	 * 用户基础界面
	 */
	public void userView(){
		User user=uf.login();
		if(user==null){
			return;
		}
		System.out.println("欢迎"+user.getName()+"登陆");
		while(true){
			System.out.println("********************************************************");
			int choose=Util.getInt("请输入选项：1.电影\t2.影院\t3.榜单\t4.电影票\t5.更多选项\t0.退出 ");
			switch(choose){
			case 1:
				uf.movieOptions(user);
				break;
			case 2:
				uf.theaterOptions(user);
				break;
			case 3:
				uf.topMovies(user);
				break;
			case 4:
				uf.ticketOptions(user);
				break;
			case 5:
				if(moreUserView(user)){
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
	/**
	 * 用户注册功能
	 * 注册成功提示注册成功
	 * 失败则提示失败
	 */
	public void register(){
		boolean flag=uf.register();
		if(flag){
			System.out.println("用户注册成功");
		}else{
			System.out.println("注册失败");
		}
		
	}
	
}
