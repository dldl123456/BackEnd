package view;

import view.choose.PageChoose;

public class HomePage {
	public static void homePage() {
		UserView.userNum=0;//����
		System.out.println("��ӭ����С����Ӱ��Ʊϵͳ");
		System.out.println("��ѡ��������ݣ�");
		System.out.print("��1�����û�\t\t");
		System.out.print("��2��������Ա\t");
		System.out.println("��3�����˳�ϵͳ");
		PageChoose.homeChoose();
	}
	
	public static void exitSystem() {
		System.out.println("��лʹ��С����Ӱ��Ʊϵͳ����ֿ�ڴ������ٴ�ʹ�ã�лл������");
		System.exit(0);
	}
}
