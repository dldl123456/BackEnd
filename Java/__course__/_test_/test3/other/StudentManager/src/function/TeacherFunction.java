  package function;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.StudentArr;
import arrays.TeacherArr;
import common.HandleInputMismatchException;
import common.RankingList;
import common.ReviseMessage;
import entity.Teacher;
import operate.TeacherOperate;
import test.Page;
/**
 * ����Ϊ����Ա��½������ľ���ʵ���࣬�������й��ܵ�ʵ��
 * @author Administrator
 *
 */
public class TeacherFunction extends TeacherArr{
	Scanner input = new Scanner(System.in);
	StudentArr stuArr = new StudentArr();
	int stuIndex=-1;//��������õ���ѧ�������±�
	String stuName;//�������ռ��������ѧ������
	/**
	 * ʵ������ѡ���
	 */
	public void overall() {
		/**
		 * ���������쳣
		 */
		int choose = 0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);	
		switch(choose) {
		case 1://�鿴����ѧ����Ϣ
			System.out.println("����ѧ����Ϣ���£�");
			System.out.println("�˺�\t"+ "����\t"+"����\t"+"�Ա�\t"+"��ͥסַ\t"+"��Ȥ����\t"+"״̬");
			stuArr.ergodicStuu();
			break;
		case 2://�鿴����ѧ����Ϣ
			System.out.println("������Ҫ�鿴��ѧ��������");
			stuName = input.next();
			stuArr.sayStuuOfName(stuName);
			break;
		case 3://�鿴�ɼ����а�
			RankingList.sayRankingList();
			break;
		case 4://�鿴����ѧ���ɼ�
			System.out.println("����ѧ���ɼ����£�");
			System.out.println("����\t���ĳɼ�\t��ѧ�ɼ�\tӢ��ɼ�\t�ܳɼ�");
			stuArr.ergodicStuuScore();
			break;
		case 5://�޸�ѧ���ɼ�
			System.out.println("������Ҫ�޸ĵ�ѧ��������");
			stuName = input.next();
			stuArr.reviseStuuScore(stuName);
			break;
		case 6://���ѧ��
			stuArr.addStu();
			break;
		case 7://ע��ѧ����Ϣ
			stuArr.deleteStu();
			break;
		case 8://�鿴�˻���Ϣ
			System.out.println("�����������˻���Ϣ��");
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t" +"ְλ\t"+"״̬");
			int i = LoginTemplet.indexAccount;
			Teacher tt = tc[i]; 
			System.out.println(tt.toString());
			break;
		case 9://�޸��˻���Ϣ
			System.out.println("������Ҫ�޸ĵ�ѡ�[1]������\t[2]����ַ\t\t[3]������");
			ReviseMessage.reviseMa(tc);
			break;
		case 10://�޸��˻�����(�ֲ��ڲ���)
			class Inner extends RevisePassword {
				public void againLogin() {						
					LoginTemplet lt = new TeacherOperate();//��̬
					lt.Login();
				}
			}
			Inner in = new Inner();
			in.revisePassword(tc);
			break;
		case 11://������ҳ��
			Page.homePage();
			break;
		case 12://�˳�ϵͳ
			Page.exit();
			break;
		default:
			System.out.println("�������ָ��������Ϊ���л��������б����������룺");
			break;
		}
		System.out.println("��ѡ��������һ��������");
		Page.loginSuccess();
	}
	
}
