package project.MorraGame_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * �˻���ȭ
 * @author ASUS
 *
 */
@SuppressWarnings("unused")
public class Login {
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {
		String answer=null;//�����Ƿ�����Ľ���answer 
		boolean choice=false;
		int winner=0;
		User user=new User();//ʵ����User����;
	    List< Integer> first = new ArrayList<Integer>(); //ʤ���� 
	    first.add(5);
	    first.add(18);
	    first.add(3);
	    first.add(11);
		do {
			/*����������*/
			System.out.println("��VS����,��ȭ��Ϸ~~!");
			System.out.println("********************");
			System.out.println("1.����Ϸ");
			System.out.println("2.Ӣ�����а�");
			System.out.println("0.����");
			System.out.println("********************");
			System.out.println("====>������ѡ��(0-2)");
			Scanner input=new Scanner(System.in);//ɨ����ʵ����
			int number=input.nextInt();
			/*��ʼ�ж�*/
			switch (number) {
			case 1:
				do {
					System.out.println("�����������ǳ�");
					user.setUser(input.next());
					System.out.println("���������Ķ���  1.��Ȩ    2.�ܲ�   3.����");
					user.setOpponent(input.next());//�����û�����Ķ�����
					do {
						System.out.println("���û���ȭ"+"1.����  2.ʯͷ  3��");
						boolean istrue=input.hasNextInt();//�ж��Ƿ�Ϊ����
						while (!istrue) {//�������ֽ���
							String str =  input.next();
							System.out.println("���������:"+str+"�������������");
							System.out.println("�����³�ȭ+"+"1.����  2.ʯͷ  3��");
							istrue=input.hasNextInt();//�ж��Ƿ�Ϊ����,������ǣ�����ѭ��
						}
						number=input.nextInt();//ȡ������
						while (number>3||number<0) {
							System.out.println("������ĸ�ʽ,���������Ŀ�ζŶ");
							System.out.println("���������룺"+"���û���ȭ"+"1.����  2.ʯͷ  3��");
							number=input.nextInt();//�ж��Ƿ���1~3��,�������ѭ��
						}
						int computer=new Random().nextInt(3)+1;//������Զ�����ֵ(1-3)
						first=Filtering_Method.getlist(first, number, winner, computer, user);
						System.out.println("�Ƿ������Ϸ(y/n)");
						answer=input.next();//�����û������Ƿ���Ҫ������Ϸ
						if (answer.equals("y")) {
							choice=true;
						}else {
							choice=false;
						}
					} while (choice);
					System.out.println(winner);
				} while (choice);
				
				break;
			case 2:
				/**
				 * ��ʾ���а�
				 */
				try {
					Collections.sort(first);
					System.out.println("���а����£�");
		        for (int i = first.size()-1; i >=0; i--) {
					System.out.println(first.get(i));
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				break;
			case 0:
				System.out.println("�������");
				return;
				
			default:
				System.out.println("����������");
				break;
			}
			System.out.println("�Ƿ���Ҫ������Ϸ����(y/n)");
			answer=input.next();
			if (answer.equals("y")) {
				choice=true;
			}else {
				choice=false;
			}
		} while (choice);
		System.out.println("�������");
	}
}
