package function;


import abatractClass.LoginTemplet;
import abatractClass.RevisePassword;
import arrays.StudentArr;
import common.HandleInputMismatchException;
import common.RankingList;
import common.ReviseMessage;
import entity.Student;
import operate.StudentOperate;
import test.Page;
/**
 * ����Ϊ����Ա��½������ľ���ʵ���࣬�������й��ܵ�ʵ��
 * @author Administrator
 *
 */
public class StudentFunction extends StudentArr{
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
		case 1://�鿴�˻���Ϣ
			System.out.println("��������ĸ�����Ϣ��");
			System.out.println("�˺�\t"+ "����\t"+"����\t"+"�Ա�\t"+"��ͥסַ\t"+"��Ȥ����\t"+"״̬");
			int index = LoginTemplet.indexAccount;
			Student ss = stuu[index]; 
			System.out.println(ss);
			break;
		case 2://�޸��˻���Ϣ
			System.out.println("������Ҫ�޸ĵ�ѡ�[1]������\t[2]����ַ\t\t[3]������");
			ReviseMessage.reviseMa(stuu);
			break;
		case 3://�鿴���Գɼ������ˣ�
			System.out.println("�������㱾�ο��Եĳɼ��嵥��");
			System.out.println("����\t���ĳɼ�\t��ѧ�ɼ�\tӢ��ɼ�\t�ܳɼ�");
			int e = LoginTemplet.indexAccount;
			Student exam = stuu[e];
			System.out.println(exam.toString2());
			break;
		case 4://�鿴�ɼ����а�
			RankingList.sayRankingList();
			break;
		case 5://�޸��˻�����(�ֲ��ڲ���)
			class Inner extends RevisePassword {
				public void againLogin() {						
					LoginTemplet lt = new StudentOperate();//��̬
					lt.Login();
				}
			}
			Inner in = new Inner();
			in.revisePassword(stuu);
			break;
		case 6://������ҳ��
			Page.homePage();
			break;
		case 7://�˳�
			Page.exit();
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
