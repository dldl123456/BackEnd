package operate;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.StudentArr;
import common.HandleInputMismatchException;
/**
 * ѧ����¼������
 * �̳е�¼������
 * @author Administrator
 *
 */
public class StudentOperate extends LoginTemplet {
	Scanner input =new Scanner(System.in);
	/**
	 * ����������������������ֵ���бȽ�
	 */
	@Override
	public int ergodicName() {
		/**
		 * ���������쳣
		 */
		int account = 0;
		account =HandleInputMismatchException.handleInputMismatchException(account);
		for(int i =0;i<StudentArr.stuu.length;i++) {
			if(account==StudentArr.stuu[i].getAccount()) {
				indexAccount=i;
				break;
			}
		}
		return 0;
	}
	/**
	 * �������õ������±꣬��ɵ�¼
	 */
	@Override
	public void ergodicPw() {
		String psd = input.next();
		for(int j=0;j<StudentArr.stuu.length;j++) {
			if(psd.equals(StudentArr.stuu[j].getPassword())) {
				indexPassword=j;
				break;
			}
		}
		if(indexPassword!=-1&&indexAccount==indexPassword) {
			if(psd.equals("000000")) {
				System.out.println("��������������ǰ����Ϊ��ʼ���룬��ȫϵ��Ϊ0�����������޸����������������");
			}
		}else {
			affirmPwCount();//ȷ���������������������ʵ��
			ergodicPw();
		}
	}
	/**
	 * ���ӵ�¼��������ʾ��¼״̬
	 */
	@Override
	public void loginTime() {
		int times = StudentArr.stuu[LoginTemplet.indexAccount].getLoginTimes();
		times+=1;
		StudentArr.stuu[LoginTemplet.indexAccount].setLoginTimes(times);
		System.out.println("��ӭ����"+StudentArr.stuu[indexPassword].getName()+"ͬѧ������"+"��ǰΪ�����յ�"+StudentArr.stuu[LoginTemplet.indexAccount].getLoginTimes()+"�ε�¼");
	}
}
