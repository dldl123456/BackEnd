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
import java.util.List;
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
					System.out.println("����Ա��");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					System.out.println("ѧ����");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
					m.login(in, m, stuAccount, stuInfo, adminAccount);
					isTrue = true;  //����ѭ��
					break;
				case 2:
					List list=m.register(in, m, adminAccount, stuAccount, stuInfo);
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) instanceof Student[]) {
							stuAccount=(Student[]) list.get(i);//ǿ��ת��
						}else {
							adminAccount=(Administrator[]) list.get(i);
						}
					}
					System.out.println("����Ա��");
					for (int i = 0; i < adminAccount.length; i++) {
						System.out.println(adminAccount[i].getUser()+" "+adminAccount[i].getPwd());
					}
					System.out.println("ѧ����");
					for (int i = 0; i < stuAccount.length; i++) {
						System.out.println(stuAccount[i].getUser()+" "+stuAccount[i].getPwd());
					}
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
