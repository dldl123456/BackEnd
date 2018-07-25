/*
 *  ѧ������ϵͳ
 *  (����ʹ���������)
 *  ��¼��ע�ᡢ���ӡ�ɾ�����޸ġ���ѯ
 *  �γ̹���(���������ſγ̾���һ�ſγ�)
 *  �ɼ������а��쳣����
 *  ɾ��ʱ�������м䲻��������
 *  ��߲��֣���֤�� 
 */

package StudentMS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMS {
	public static void main(String[] args) {
		//��������
		int num = 0;  //���������û�������
		boolean isTrue = false;  //�����ж��Ƿ����
		
		//ʵ����
		Student[] stuInfo = Student.getStudent();  //ʵ����ѧ����Ϣ��������
		Student[] stuAccount = Student.stuAccount();  //ʵ����ѧ���˺Ŷ�������
		Administrator[] adminAccount = Administrator.adminAccount();  //ʵ��������Ա�˺Ŷ�������
		
		BaseMethod m = new BaseMethod();  //ʵ����������

		Scanner in=new Scanner(System.in);  //����
		
		do{
			//������
			System.out.println("--��ӭ����ѧ������ϵͳ--");
			System.out.println("[1]��¼     [2]ע��     [3]�˳�\n");
			System.out.print("��ѡ������Ҫ�Ĳ�����");
			
			try{
				num = in.nextInt();  //���û�������Ҫѡ�����Ŀ
			}catch(InputMismatchException e){
				System.out.println("�Ƿ����룬�������!");
				System.exit(0);
			}
			
			switch(num){
				case 1:
					m.login(in, m, stuAccount, stuInfo, adminAccount);
					isTrue = true;  //����ѭ��
					break;
				case 2:
					m.register(in, m, adminAccount, stuAccount, stuInfo);
					isTrue = true;  //����ѭ��
					break;
				case 3:
					System.out.println("\n�����˳�ѧ������ϵͳ");
					isTrue = false;  //����ѭ��
					break;
				default:
					System.out.println("������������");
					isTrue = true;  //����ѭ��
					break;
			}
		}while(isTrue);
		
		//�������
		System.out.println("��ӭ�´�ʹ�ã�");
		in.close();  //�رռ���
		System.exit(0);
	}
}
