package abatractClass;

import java.util.Scanner;

import entity.Person;
/**
 * ������  ������
 * �����޸��˻�����
 * @author Administrator
 *˵���������࣬�ں����µ�¼�ĳ��󷽷�,�̳д�����ڲ���ʵ�ִ˷���
 */
public abstract class RevisePassword {
	Scanner input = new Scanner(System.in);
	/**
	 * �޸�����ķ���
	 * @param pe������ݵĸ�������
	 */
	public void revisePassword(Person [] pe) {
		int w = LoginTemplet.indexAccount;
		System.out.println("����������룺");
		String oldPw = input.next();
		if(oldPw.equals(pe[w].getPassword())) {
			a:while(true) {
				System.out.println("�����������룺");
				String newPw =input.next();
				if(oldPw.equals(newPw)) {
					System.out.println("�����벻����ԭ������ͬ�����������������룺");
					continue a;
				}
				int con =0;
				b:while(true) {
					con++;
					if(con>3) {
						System.out.println("ȷ�������������,�������޸����룺");
						revisePassword(pe);
					}else {
						System.out.println("��ȷ�������룺"); 
						String newPw1 = input.next();
						if(newPw.equals(newPw1)) {
							pe[w].setPassword(newPw1);
							System.out.println("�����޸ĳɹ��������µ�¼��");
							LoginTemplet.indexPassword=-1;
							LoginTemplet.indexAccount=-1;
							againLogin();
						}else {
							System.out.println("ȷ���������������ȷ�����룺");     
							continue b;
						}							
					}
					break;
				}
				break;
			}						
		}else {
			System.out.println("���������������������:");
			revisePassword(pe);
		}
	}
	/**
	 * ���µ�¼�������̳к���дʹ��
	 */
	public abstract void againLogin();
}
