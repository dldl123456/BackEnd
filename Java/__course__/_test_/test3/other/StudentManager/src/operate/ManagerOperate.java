package operate;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.ManagerArr;
import common.HandleInputMismatchException;
/**
 * ѧ����¼������
 * �̳е�¼������
 * @author Administrator
 *
 */
public class ManagerOperate extends LoginTemplet {
	Scanner input =new Scanner(System.in);
	/**
	 * ����������������������ֵ���бȽ�
	 */
	@Override
	public int ergodicName() {
		/**
		 * ���������쳣
		 */
		int ManagerId = 0;
		ManagerId =HandleInputMismatchException.handleInputMismatchException(ManagerId);	
		for(int i =0;i<ManagerArr.ma.length;i++) {
			if(ManagerId==ManagerArr.ma[i].getAccount()) {
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
		for(int j=0;j<ManagerArr.ma.length;j++) {
			if(psd.equals(ManagerArr.ma[j].getPassword())) {
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
		int times = ManagerArr.ma[LoginTemplet.indexAccount].getLoginTimes();
		times+=1;
		ManagerArr.ma[LoginTemplet.indexAccount].setLoginTimes(times);
		System.out.println("��ӭ����"+ManagerArr.ma[indexPassword].getName()+"��ʦ������"+"��ǰΪ�����յ�"+ManagerArr.ma[LoginTemplet.indexAccount].getLoginTimes()+"�ε�¼");
	}
}
