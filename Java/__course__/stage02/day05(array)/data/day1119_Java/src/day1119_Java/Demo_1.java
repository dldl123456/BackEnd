package day1119_Java;

import java.util.Scanner;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = -1;// �±�
		int num = 0;// �޸���
		boolean flag = true;// ѭ������
		// ����Դ
		int[] nums = new int[4];// 4��ʾ������鳤��Ϊ4������д�����������涼��Ĭ��ֵ
		Scanner input = new Scanner(System.in);
		// ���ҵ���Ԫ��
		// System.out.println("��������Ҫ���ĸ��±��Ԫ�أ�");
		// index = input.nextInt();// �û����±�
		// System.out.println(nums[index]);// ��ʾ�±�����Ӧ��Ԫ��
		// ����/��ȡ������ĳ���±��������е�Ԫ�أ���������[�±�ֵ]��nums[1]��
		// ��ĳһ���±��Ԫ�ظ�ֵ
		// System.out.println("���������ֵ��");
		// ������/������ݣ������������Ч�����ˣ��Ǿ��Ǹ�
		// nums[3]=input.nextInt();//������±꣬�����±����ֵ�����鳤��-1��������.length-1��
		// ������ÿ��Ԫ�ظ�ֵ
		// for (int i = 0; i < nums.length; i++) {
		// System.out.println("�����" + (i + 1) + "��ֵ��");
		// nums[i] = input.nextInt();
		// }
		// �����û����������޸�������ĳһ��Ԫ�أ��ĸ�Ԫ�أ��޸ĳ�ʲô��ѭ�� ����
		// 1.�û������ĸ�Ԫ��ȥ���±�Ȼ���޸ģ�2.�û������±��޸�
		// ����1
		while (flag) {//�����Ҫ�޸ĺ����/�����޸ģ��Ӹ��ж��Ƿ����
			System.out.println("��������Ҫ�޸ĵ�����");
			num = input.nextInt();
			// �û���������Ƿ�����������ڣ�����������Ǿ�Ҫ�����û�����������Ǿ�Ҫ��¼���Ԫ�ص��±�
			for (int i = 0; i < nums.length; i++) {
				if (num == nums[i]) {
					index = i;
					break;
				}
			}
			// ����index�е�ֵ�ж��Ƿ����
			if (index == -1) {
				System.out.println("û�и�����");
				// flag = false;
				continue;
			}
			System.out.println("������Ҫ�޸ĺ������");
			nums[index] = input.nextInt();
			// ����2
			// System.out.println("������Ҫ�޸ĵ��±꣺");
			// index = input.nextInt();
			// System.out.println("������Ҫ�޸ĺ������");
			// nums[index] = input.nextInt();
			// ���������Ԫ��
			for (int i = 0; i < nums.length; i++) {
				// ��ô����ÿһ��Ԫ�أ�
				// System.out.println(nums[i]);
				System.out.print(nums[i] + "�ո�");
			}
			System.out.println();
		}
	}
}
