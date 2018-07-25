package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @param �����࣬�û�����
 * @author zmx2321
 *
 */
public class Help {
	//��ȡ����
	private static Scanner in = new Scanner(System.in);
	//ʱ���ʽ
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//�ӿ���̨����һ���ַ���
	public static String getString(String str) {
		System.out.print(str);
		return in.next();
	}

	//�ӿ���̨����һ������
	public static int getInt(String str) {
		System.out.print(str);
		while (true) {
			try {
				int num = in.nextInt();
				return num;
			} catch (Exception e) {
				System.out.print("����������������������\n������һ��������");
				in.nextLine();
			}
		}
	}
	
	//�ӿ���̨����һ��������
	public static float getFloat(String str) {
		System.out.print(str);
		while (true) {
			try {
				float num = in.nextFloat();
				return num;
			} catch (Exception e) {
				System.out.print("����������������������\n������һ��С����");
				in.nextFloat();
			}
		}
	}
	
	//����̨����һ����������
	public static String getData(String str){
		System.out.print(str);
		while (true) {
			String time = in.next();
			try {
				Date date = sdf.parse(time);
				String strtime = sdf.format(date);
				
				return strtime;
			} catch (Exception e) {
				System.out.print("�������ʱ�����ʹ���ϵͳ�޷�ʶ��\n�밴��ģ����ʽ����(yyyy-MM-dd)��");
				in.nextLine();
			}
		}
	}
	
	//test
	public static void main(String[] args) {
		//System.out.println(getInt("�������֣�"));
		
		//System.out.println(getString("�����ַ�����"));
		
		//System.out.println(getFloat("���븡������"));
		
		//System.out.println(getData("�������ڣ�"));
	}
}
