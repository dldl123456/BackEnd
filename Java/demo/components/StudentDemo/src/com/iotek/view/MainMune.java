package com.iotek.view;

import com.iotek.util.Util;

/**
 * ��ҳ��
 * @author Administrator
 *
 */
public class MainMune {
	
	private StudentView stuView;
	public MainMune() {
		stuView =  new StudentView();
	}
	
	public void mune(){
		System.out.println("---��ӭ����ѧ������ϵͳ----");
	 
		boolean flag = true;
		while(flag ){
			System.out.println("1:��¼");
			System.out.println("2:ע��");
			System.out.println("3:�˳�");
			
		 /**
		  * ��¼֮��
		  */
		String num = Util.getString("���������ѡ��:");
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
			System.out.println("�������,û�и�ѡ��");
			break;
		}
		
	}
		}

}
