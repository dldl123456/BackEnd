package operate;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.ManagerArr;
import common.HandleInputMismatchException;
/**
 * 学生登录操作类
 * 继承登录抽象类
 * @author Administrator
 *
 */
public class ManagerOperate extends LoginTemplet {
	Scanner input =new Scanner(System.in);
	/**
	 * 遍历姓名方法，并与输入值进行比较
	 */
	@Override
	public int ergodicName() {
		/**
		 * 处理输入异常
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
	 * 遍历并拿到密码下标，完成登录
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
				System.out.println("→→→→→→当前密码为初始密码，安全系数为0，请您尽快修改密码←←←←←←");
			}
		}else {
			affirmPwCount();//确认输入密码次数方法，已实现
			ergodicPw();
		}
	}
	/**
	 * 增加登录次数，显示登录状态
	 */
	@Override
	public void loginTime() {
		int times = ManagerArr.ma[LoginTemplet.indexAccount].getLoginTimes();
		times+=1;
		ManagerArr.ma[LoginTemplet.indexAccount].setLoginTimes(times);
		System.out.println("欢迎您："+ManagerArr.ma[indexPassword].getName()+"老师！！！"+"当前为您今日第"+ManagerArr.ma[LoginTemplet.indexAccount].getLoginTimes()+"次登录");
	}
}
