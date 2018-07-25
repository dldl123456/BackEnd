package view;

import java.util.Scanner;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import view.choose.AdminViewChoose;
import view.choose.AssessmentChoose;
import view.choose.CinemaChoose;
import view.choose.CityChoose;
import view.choose.FilmTicketChoose;
import view.choose.HallChoose;
import view.choose.MovieChoose;
import view.choose.SeatChoose;
import view.choose.SessionChoose;
import view.choose.UserViewChoose;

public class AdminView {
	static AdminViewChoose avc = new AdminViewChoose();
	public static void adminFirstPage() {
		System.out.println("请选择您需要的操作：");
		System.out.println("【1】、登录");
		System.out.println("【2】、退出");
		avc.adminFirstPageChoose();
	}
	
	public static void adminMeanPage() {
		System.out.println("以下是您的功能列表请输入要选择的序号：");
		System.out.println("【1】、进入用户管理");
		System.out.println("【2】、进入电影票管理");
		System.out.println("【3】、进入电影管理");
		System.out.println("【4】、进入电影院管理");
		System.out.println("【5】、进入影厅管理");
		System.out.println("【6】、进入座位管理");
		System.out.println("【7】、进入场次管理");
		System.out.println("【8】、进入评价管理");
		System.out.println("【9】、进入城市管理");
		System.out.println("【10】、返回主页面");
		System.out.println("【11】、退出");
		try {
			avc.adminMeanPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateUserPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、查看某个用户");
		System.out.println("【2】、查看所有用户");
		System.out.println("【3】、查看某个城市所有用户");
		System.out.println("【4】、为用户充值");
		System.out.println("【5】、为用户重置密码");
		System.out.println("【6】、返回上级列表");
		System.out.println("【7】、返回首页");
		System.out.println("【8】、退出");
		UserViewChoose uvc = new UserViewChoose();
		try {
			uvc.adminOperateUserPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateFilMTicketPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、查看所有电影票信息");
		System.out.println("【2】、查看某部影片全部电影票信息");
		System.out.println("【3】、查看某部影片某个影院的全部电影票信息");
		System.out.println("【4】、查看某个影院的全部电影票信息");
		System.out.println("【5】、查看某个用户的全部电影票信息");
		System.out.println("【6】、返回上级列表");
		System.out.println("【7】、返回首页");
		System.out.println("【8】、退出");
		FilmTicketChoose ftc = new FilmTicketChoose();
		try {
			ftc.adminOperateFilMTicketPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateMoviePage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加电影");
		System.out.println("【2】、删除电影");
		System.out.println("【3】、修改电影状态");
		System.out.println("【4】、修改电影评分");
		System.out.println("【5】、查看全部电影");
		System.out.println("【6】、查找单个电影");
		System.out.println("【7】、返回上级列表");
		System.out.println("【8】、返回首页");
		System.out.println("【9】、退出");
		MovieChoose mc = new MovieChoose();
		try {
			mc.adminOperateMoviePageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateCinemaPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加电影院");
		System.out.println("【2】、删除电影院");
		System.out.println("【3】、查看所有电影院");
		System.out.println("【4】、查看某个城市所有电影院");
		System.out.println("【5】、查找单个电影院");
		System.out.println("【6】、返回上级列表");
		System.out.println("【7】、返回首页");
		System.out.println("【8】、退出");
		CinemaChoose cc = new CinemaChoose();
		try {
			cc.adminOperateCinemaPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateHallPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加影厅");
		System.out.println("【2】、删除影厅");
		System.out.println("【3】、查看所有影厅");
		System.out.println("【4】、查看某个影院所有影厅");
		System.out.println("【5】、查找单个影厅");
		System.out.println("【6】、返回上级列表");
		System.out.println("【7】、返回首页");
		System.out.println("【8】、退出");
		HallChoose hs = new HallChoose();
		try {
			hs.adminOperateHallPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateSeatPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加座位");
		System.out.println("【2】、删除座位");
		System.out.println("【3】、查看某个影厅所有座位");
		System.out.println("【4】、将某个厅座位状态恢复为空");
		System.out.println("【5】、返回上级列表");
		System.out.println("【6】、返回首页");
		System.out.println("【7】、退出");
		SeatChoose sch = new SeatChoose();
		try {
			sch.adminOperateSeatPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateSessionPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加场次");
		System.out.println("【2】、删除场次");
		System.out.println("【3】、查看所有场次");
		System.out.println("【4】、查看某个影院所有场次");
		System.out.println("【5】、查看某个电影所有场次");
		System.out.println("【6】、查看某个电影在某个影院的所有场次");
		System.out.println("【7】、查找单个场次");
		System.out.println("【8】、返回上级列表");
		System.out.println("【9】、返回首页");
		System.out.println("【10】、退出");
		//System.out.println("【8】、修改场次信息");
		SessionChoose sec = new SessionChoose();
		try {
			sec.adminOperateSessionPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateAssessmentPage() {
		System.out.println("因国家规定，您只能查看评价，请选择查看方式：");
		System.out.println("【1】、查看所有评价");
		System.out.println("【2】、查看某部影片全部评价");
		System.out.println("【3】、查看某部影片某个影院的全部评价");
		System.out.println("【4】、查看某个影院的全部评价");
		System.out.println("【5】、查看某个用户的全部评价");
		System.out.println("【6】、返回上级列表");
		System.out.println("【7】、返回首页");
		System.out.println("【8】、退出");
		AssessmentChoose amc = new AssessmentChoose();
		try {
			amc.adminOperateAssessmentPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateCityPage() {
		System.out.println("请输入要选择的编号：");
		System.out.println("【1】、添加城市");
		System.out.println("【2】、查看所有城市");
		System.out.println("【3】、返回上级列表");
		System.out.println("【4】、返回首页");
		System.out.println("【5】、退出");
		CityChoose cityc = new CityChoose();
		try {
			cityc.adminOperateCityPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminLoginPage() throws Exception {
		a:while(true) {
			System.out.println("请输入账户名称：");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String adminName=input.next();
			AdminDao ad = new AdminDaoImpl();
			if(ad.comparisonAdminName(adminName)!=-1) {
				b:while(true) {
					System.out.println("请输入账户密码：");
					String adminPassword=input.next();
					if(ad.comparisonAdminPas(adminName, adminPassword)!=-1) {
						System.out.println("登录成功，欢迎您："+adminName);
						AdminView.adminMeanPage();
						break;
					}else {
						System.out.println("密码错误，请重新输入：");
						continue b;
					}
				}
				break;
			}else {
				System.out.println("您出入的账户名称不正确，请重新输入：");
				continue a;
			}
		}		
	}
	public static String AdminToString(Admin admin) {
		return admin.getAdminId()+"\t"+admin.getAdminName();
	}
}
