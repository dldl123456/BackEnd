package operate;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.TeacherArr;
import common.HandleInputMismatchException;
/**
 * ��ʦ��¼������
 * �̳е�¼������
 * @author Administrator
 *
 */
public class TeacherOperate extends LoginTemplet {
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
		for(int i =0;i<TeacherArr.tc.length;i++) {
			if(account==TeacherArr.tc[i].getAccount()) {
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
		for(int j=0;j<TeacherArr.tc.length;j++) {
			if(psd.equals(TeacherArr.tc[j].getPassword())) {
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
		int times = TeacherArr.tc[LoginTemplet.indexAccount].getLoginTimes();
		times+=1;
		TeacherArr.tc[LoginTemplet.indexAccount].setLoginTimes(times);
		System.out.println("��ӭ����"+TeacherArr.tc[indexPassword].getName()+"��ʦ������"+"��ǰΪ�����յ�"+TeacherArr.tc[LoginTemplet.indexAccount].getLoginTimes()+"�ε�¼");
	}
}
