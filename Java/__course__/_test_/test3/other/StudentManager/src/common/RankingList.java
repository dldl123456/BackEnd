package common;

import arrays.StudentArr;
import test.Page;

//���а�
public class RankingList {
	public static void rankingList(int num) {		
		double[] sum = new double[StudentArr.stuu.length];
		String[] st = new String[StudentArr.stuu.length];//ѧ������
		//������ѧ�����ܳɼ��浽һ��������
		for(int i=0;i<StudentArr.stuu.length;i++) {
			switch(num) {
			case 1:
				sum[i]=StudentArr.stuu[i].getSum();
				break;
			case 2:
				sum[i]=StudentArr.stuu[i].getChiness();
				break;
			case 3:
				sum[i]=StudentArr.stuu[i].getMath();
				break;
			case 4:
				sum[i]=StudentArr.stuu[i].getEnglish();
				break;
			default:
				System.exit(0);
				break;
			}
			st[i]=StudentArr.stuu[i].getName();
		}
		for(int x=0;x<sum.length-1;x++) {
			for(int y=0;y<sum.length-x-1;y++) {
				if(sum[y]<sum[y+1]) {
					double n = sum[y];
					String ss = st[y];
					sum[y] =sum[y+1];
					st[y] =st[y+1];
					sum[y+1]=n;
					st[y+1] = ss;
				}
			}
		}
		for(int i=0;i<StudentArr.stuu.length;i++) {
			System.out.println(st[i]+"\t\t"+sum[i]+"\t\t"+"��"+(i+1)+"��");
		}
	}
	/**
	 * �鿴���а񷽷�
	 */
	public static void sayRankingList() {
		a:while(true) {
			System.out.println("��������Ҫ�鿴�����а���ţ�");
			System.out.print("��1�����ܳɼ����а�\t\t��2�������ĳɼ����а�\t\t��3������ѧ�ɼ����а�\t\t��4����Ӣ��ɼ����а�\n");
			/**
			 * ���������쳣
			 */
			int num = 0;
			num =HandleInputMismatchException.handleInputMismatchException(num);
			switch(num) {
			case 1:
				System.out.println("���ο����ܳɼ���������");
				System.out.println("����"+"\t\t"+"�ɼ�"+"\t\t"+"����");
				rankingList(1);	
				break;
			case 2:
				System.out.println("���ο������ĳɼ���������");
				System.out.println("����"+"\t\t"+"�ɼ�"+"\t\t"+"����");
				rankingList(2);				
				break;
			case 3:
				System.out.println("���ο�����ѧ�ɼ���������");
				System.out.println("����"+"\t\t"+"�ɼ�"+"\t\t"+"����");
				rankingList(3);				
				break;
			case 4:
				System.out.println("���ο���Ӣ��ɼ���������");
				System.out.println("����"+"\t\t"+"�ɼ�"+"\t\t"+"����");
				rankingList(4);				
				break;
			default:
				System.out.println("�������ָ���������������룺");
				continue a;
			}
			System.out.println("��ѡ����һ��������");
			System.out.print("��1�����鿴�����ɼ����а�\t\t��2����������һ��\t\t��3����������ҳ��\t\t��4�����˳�ϵͳ\n");
			next();
			break;
		}
	}
	private static int next() {
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			sayRankingList();
			break;
		case 2:
			Page.loginSuccess();
			break;
		case 3:
			Page.homePage();
			break;
		case 4:
			Page.exit();
			break;
		default:
			System.out.println("�������ָ���������������룺");
			next();
		}
		return choose;
	}
}
