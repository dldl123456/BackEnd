package function;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.ManagerArr;
import arrays.TeacherArr;
import common.HandleInputMismatchException;
import common.ReviseMessage;
import operate.ManagerOperate;
import test.Page;
/**
 * ����Ϊ����Ա��½������ľ���ʵ���࣬�������й��ܵ�ʵ��
 * @author Administrator
 *
 */
public class ManagerFunction extends ManagerArr{
	Scanner input = new Scanner(System.in);
	TeacherArr tcArr =new TeacherArr();
	int tcIndex=-1;//��������õ�����ʦ�����±�
	/**
	 * ʵ������ѡ���
	 */
	public void overall() {
		/**
		 * ���������쳣
		 */
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://�鿴���й���Ա��Ϣ
			System.out.println("���й���Ա��Ϣ���£�");
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t" +"ְλ\t"+"״̬");
			ergodicMa();
			break;
		case 2://�鿴������ʦ��Ϣ
			System.out.println("������ʦ��Ϣ���£�");
			tcArr.ergodicTc();
			break;
		case 3://�鿴������ʦ��Ϣ
			System.out.println("������Ҫ�鿴����ʦ������");	
			String tcName = input.next();
			tcArr.sayTcOfName(tcName);
			break;
		case 4://�����ʦ
			tcArr.addTeacher();
			break;
		case 5://ע����ʦ��Ϣ
			tcArr.deleteStu();
			break;
		case 6://�鿴�˻���Ϣ
			System.out.println("��������ĸ�����Ϣ��");
			int index = LoginTemplet.indexAccount;
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t" +"ְλ\t"+"״̬");
			System.out.println(ma[index]);
			break;
		case 7://�޸��˻���Ϣ
			System.out.println("������Ҫ�޸ĵ�ѡ�[1]������\t[2]����ַ\t\t[3]������");
			ReviseMessage.reviseMa(ma);
			break;
		case 8://�޸��˻�����(�����ڲ���)
			new RevisePassword() {
				public void againLogin() {
					LoginTemplet lt = new ManagerOperate();//��̬
					lt.Login();
				}
			}.revisePassword(ma);//������ø��෽��
			break;
		case 9://ע�����˻�
			deleteMan();
			break;
		case 10://������ҳ��
			Page.homePage();
			break;
		case 11://�˳�ϵͳ
			System.out.println("ллʹ�ñ�ϵͳ����ӭ���ٴ�ʹ�ã�����");
			System.exit(0);
			break;
		default:
			System.out.println("�������ָ��������Ϊ���л��������б����������룺");
			Page.loginSuccess();
			break;
		}
		System.out.println("��ѡ��������һ��������");
		Page.loginSuccess();
	}
}
