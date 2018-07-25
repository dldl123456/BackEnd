package common;

import java.util.Random;
import java.util.Scanner;

/**
 * 验证码类，包含生成和操作验证码方法
 * @author Administrator
 *
 */
public class ProvingNum {
	static Scanner input = new Scanner(System.in);
	/**
	 * 验证码方法
	 */
	private static String provingNum() {
		String prov ="";//声明一个字符串来承载生成的验证码
		Random ran = new Random();//随机数方法，生成一个随机数对象
		for(int i=0;i<4;i++) {
			String charOrInt = ran.nextInt(2) %2 == 0 ? "ch" : "in";//生成一个0和1之间的随机数并取模，三目运算符判断后赋给String
			//判断是字符还是整形后进行操作
			if("ch".equalsIgnoreCase(charOrInt)) {//如果是字符，则随机输出一个大写或小写字母
				int en = ran.nextInt(2) %2 ==0 ? 65 : 97;
				prov += (char)(ran.nextInt(26)+en);//生成一个0-25的随机数，加上65或97，肯定是字母
			}else if("in".equalsIgnoreCase(charOrInt)) {
				prov += String.valueOf(ran.nextInt(10));//String.valueOf(int i) 表示返回一个int参数的字符串表现形式
			}
		}		
		return prov;
	}
	//验证码的具体操作方法
	public static void operateProv() {
		System.out.println("请输入验证码：");
		a:while(true) {
			String prov =provingNum();
			System.out.println(prov);
			String pro1 = input.next();
			if(!pro1.equalsIgnoreCase(prov)) {
				System.out.println("验证码输入错误，请重新输入新验证码：");
				continue a;
			}else {
				System.out.println("请输入密码：");
				break;
			}
		}		
	}
}
