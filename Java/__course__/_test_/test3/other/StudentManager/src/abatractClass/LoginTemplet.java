package abatractClass;
import common.AssistClass;
//登录系列方法的模板模式
import common.ProvingNum;
import test.Page;
/**
 * 抽象类，用来被三类成员继承，实现登录系列操作
 * @author Administrator
 *
 */
public abstract class LoginTemplet {
	int PwCount =0;//用来记录输入密码的次数
	public static int indexAccount=-1;//用来存放账号存在时的下标
	public static int indexPassword =-1;//用来存放密码存在时的下标
	/**
	 * 登录方法,公用的
	 * 模板模式，被其他实现类调用
	 */
	public void Login(){
		System.out.println("欢迎进入登录页面：");
		int count =0;
		b:while(count<3) {
			count++;
			System.out.println("请输入您的账号：");
			ergodicName();//由各类实现
			if(indexAccount!=-1){
				System.out.println("请输入密码：");
				ergodicPw();//遍历并拿到密码下标，完成登录,抽象方法
				break;
			}else {
				if(count<3) {
					System.out.println("对不起，您输入的账号有误，请重新输入！！！");
					continue b;
				}else {
					System.out.println("对不起，由于您已经连续三次账号输入错误，系统将自动返回主页面！！！");
					Page.homePage();
				}
			}
		}
		System.out.println("登陆成功，请选择下一步操作：");
		AssistClass.nowTime();//调用辅助类的方法产生时间
		loginTime();//登陆次数
		Page.loginSuccess();
	}
	/**
	 * 增加登录次数，显示登录状态
	 */
	public abstract void loginTime();
	/**
	 * 公共遍历姓名方法，并与输入值进行比较
	 */
	public abstract int ergodicName();
	/**
	 * 确认输入密码次数方法，已实现
	 */
	public void affirmPwCount() {
		PwCount++;
		if(PwCount<=2) {
			System.out.println("对不起，您输入的密码错误，请重新输入：");
			System.out.println("请输入密码：");
		}
		if(PwCount>2&&PwCount<5) {
			System.out.println("您已经输错"+PwCount+"次密码，为了安全起见，请您输入四位验证码（不区分大小写）：");
			ProvingNum.operateProv();
		}
		if(PwCount==5) {
			System.out.println("您已经输错"+PwCount+"次密码，您还有一次机会，输入错误，则账号锁定并自动退出系统！！！");
			ProvingNum.operateProv();
		}
		if(PwCount==6) {
			System.out.println("密码错误，您已经输错"+PwCount+"次密码\n您今日的账号密码错误达到上限，当前账户属于锁定状态，请联系管理员进行密码更改或明天再来尝试！！！");
			System.exit(0);
		}
	}

	/**
	 * 遍历并拿到密码下标，完成登录
	 */
	public abstract void ergodicPw();
}
