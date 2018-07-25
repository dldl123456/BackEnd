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
		System.out.println("��ѡ������Ҫ�Ĳ�����");
		System.out.println("��1������¼");
		System.out.println("��2�����˳�");
		avc.adminFirstPageChoose();
	}
	
	public static void adminMeanPage() {
		System.out.println("���������Ĺ����б�������Ҫѡ�����ţ�");
		System.out.println("��1���������û�����");
		System.out.println("��2���������ӰƱ����");
		System.out.println("��3���������Ӱ����");
		System.out.println("��4���������ӰԺ����");
		System.out.println("��5��������Ӱ������");
		System.out.println("��6����������λ����");
		System.out.println("��7�������볡�ι���");
		System.out.println("��8�����������۹���");
		System.out.println("��9����������й���");
		System.out.println("��10����������ҳ��");
		System.out.println("��11�����˳�");
		try {
			avc.adminMeanPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateUserPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1�����鿴ĳ���û�");
		System.out.println("��2�����鿴�����û�");
		System.out.println("��3�����鿴ĳ�����������û�");
		System.out.println("��4����Ϊ�û���ֵ");
		System.out.println("��5����Ϊ�û���������");
		System.out.println("��6���������ϼ��б�");
		System.out.println("��7����������ҳ");
		System.out.println("��8�����˳�");
		UserViewChoose uvc = new UserViewChoose();
		try {
			uvc.adminOperateUserPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateFilMTicketPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1�����鿴���е�ӰƱ��Ϣ");
		System.out.println("��2�����鿴ĳ��ӰƬȫ����ӰƱ��Ϣ");
		System.out.println("��3�����鿴ĳ��ӰƬĳ��ӰԺ��ȫ����ӰƱ��Ϣ");
		System.out.println("��4�����鿴ĳ��ӰԺ��ȫ����ӰƱ��Ϣ");
		System.out.println("��5�����鿴ĳ���û���ȫ����ӰƱ��Ϣ");
		System.out.println("��6���������ϼ��б�");
		System.out.println("��7����������ҳ");
		System.out.println("��8�����˳�");
		FilmTicketChoose ftc = new FilmTicketChoose();
		try {
			ftc.adminOperateFilMTicketPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateMoviePage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1������ӵ�Ӱ");
		System.out.println("��2����ɾ����Ӱ");
		System.out.println("��3�����޸ĵ�Ӱ״̬");
		System.out.println("��4�����޸ĵ�Ӱ����");
		System.out.println("��5�����鿴ȫ����Ӱ");
		System.out.println("��6�������ҵ�����Ӱ");
		System.out.println("��7���������ϼ��б�");
		System.out.println("��8����������ҳ");
		System.out.println("��9�����˳�");
		MovieChoose mc = new MovieChoose();
		try {
			mc.adminOperateMoviePageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateCinemaPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1������ӵ�ӰԺ");
		System.out.println("��2����ɾ����ӰԺ");
		System.out.println("��3�����鿴���е�ӰԺ");
		System.out.println("��4�����鿴ĳ���������е�ӰԺ");
		System.out.println("��5�������ҵ�����ӰԺ");
		System.out.println("��6���������ϼ��б�");
		System.out.println("��7����������ҳ");
		System.out.println("��8�����˳�");
		CinemaChoose cc = new CinemaChoose();
		try {
			cc.adminOperateCinemaPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void adminOperateHallPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1�������Ӱ��");
		System.out.println("��2����ɾ��Ӱ��");
		System.out.println("��3�����鿴����Ӱ��");
		System.out.println("��4�����鿴ĳ��ӰԺ����Ӱ��");
		System.out.println("��5�������ҵ���Ӱ��");
		System.out.println("��6���������ϼ��б�");
		System.out.println("��7����������ҳ");
		System.out.println("��8�����˳�");
		HallChoose hs = new HallChoose();
		try {
			hs.adminOperateHallPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateSeatPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1���������λ");
		System.out.println("��2����ɾ����λ");
		System.out.println("��3�����鿴ĳ��Ӱ��������λ");
		System.out.println("��4������ĳ������λ״̬�ָ�Ϊ��");
		System.out.println("��5���������ϼ��б�");
		System.out.println("��6����������ҳ");
		System.out.println("��7�����˳�");
		SeatChoose sch = new SeatChoose();
		try {
			sch.adminOperateSeatPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateSessionPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1������ӳ���");
		System.out.println("��2����ɾ������");
		System.out.println("��3�����鿴���г���");
		System.out.println("��4�����鿴ĳ��ӰԺ���г���");
		System.out.println("��5�����鿴ĳ����Ӱ���г���");
		System.out.println("��6�����鿴ĳ����Ӱ��ĳ��ӰԺ�����г���");
		System.out.println("��7�������ҵ�������");
		System.out.println("��8���������ϼ��б�");
		System.out.println("��9����������ҳ");
		System.out.println("��10�����˳�");
		//System.out.println("��8�����޸ĳ�����Ϣ");
		SessionChoose sec = new SessionChoose();
		try {
			sec.adminOperateSessionPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateAssessmentPage() {
		System.out.println("����ҹ涨����ֻ�ܲ鿴���ۣ���ѡ��鿴��ʽ��");
		System.out.println("��1�����鿴��������");
		System.out.println("��2�����鿴ĳ��ӰƬȫ������");
		System.out.println("��3�����鿴ĳ��ӰƬĳ��ӰԺ��ȫ������");
		System.out.println("��4�����鿴ĳ��ӰԺ��ȫ������");
		System.out.println("��5�����鿴ĳ���û���ȫ������");
		System.out.println("��6���������ϼ��б�");
		System.out.println("��7����������ҳ");
		System.out.println("��8�����˳�");
		AssessmentChoose amc = new AssessmentChoose();
		try {
			amc.adminOperateAssessmentPageChoose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void adminOperateCityPage() {
		System.out.println("������Ҫѡ��ı�ţ�");
		System.out.println("��1������ӳ���");
		System.out.println("��2�����鿴���г���");
		System.out.println("��3���������ϼ��б�");
		System.out.println("��4����������ҳ");
		System.out.println("��5�����˳�");
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
			System.out.println("�������˻����ƣ�");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String adminName=input.next();
			AdminDao ad = new AdminDaoImpl();
			if(ad.comparisonAdminName(adminName)!=-1) {
				b:while(true) {
					System.out.println("�������˻����룺");
					String adminPassword=input.next();
					if(ad.comparisonAdminPas(adminName, adminPassword)!=-1) {
						System.out.println("��¼�ɹ�����ӭ����"+adminName);
						AdminView.adminMeanPage();
						break;
					}else {
						System.out.println("����������������룺");
						continue b;
					}
				}
				break;
			}else {
				System.out.println("��������˻����Ʋ���ȷ�����������룺");
				continue a;
			}
		}		
	}
	public static String AdminToString(Admin admin) {
		return admin.getAdminId()+"\t"+admin.getAdminName();
	}
}
