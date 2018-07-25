/**
 * 对任意两个正整数x和k，我们定义repeat(x, k)为将x重复写k次形成的数
 * 例如repeat(1234, 2) = 12341234, repeat(20, 3) = 202020
 * 现在给出4个整数x1, k1, x2, k2, 其中
 * v1 = (x1, k1)
 * v2 = (x2, k2)
 * 比较v1和v2的大小
 */

package dm.tip.loopNumCompare;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoopNumCompare {
	//测试类
	public static void main(String[] args) {
		System.out.println("repeat(x, k) ==> 将x重复写k次");
		
		//定义变量
		String x1="", x2="";
		int k1=0, k2=0;
		
		//获取输入
		Scanner in = new Scanner(System.in);
		
		//异常
		try{
			//x1和k1
			System.out.print("x1：");
			x1 = in.next();
			System.out.print("k1：");
			k1 = in.nextInt();
			
			//x2和k2
			System.out.print("x2：");
			x2 = in.next();
			System.out.print("k2：");
			k2 = in.nextInt();
		}catch(InputMismatchException e){
			System.out.println("您的输入有误\n程序结束！");
			System.exit(0);
		}catch(Exception e){
			System.out.println("您的输入有误\n程序结束！");
			System.exit(0);
		}
		
		//调用比较方法
		System.out.println(repeat(x1, k1, x2, k2));
		
		//关闭键盘
		in.close();
	}

	//比较方法
	public static String repeat(String x1, int k1, String x2, int k2){
		String s1="", s2="";  //存放repeat(x, k)得到的字符串
		long v1=0, v2=0;  //存放数值v
		int i;  //循环
		
		//repeat(x1, k1)即v1
		for(i=0; i<k1; i++){
			s1 += x1;
		}
		System.out.println("v1:" + s1);
		
		//repeat(x1, k1)即v2
		for(i=0; i<k2; i++){
			s2 += x2;
		}
		System.out.println("v2:" + s2);
		
		//异常
		try{
			//将字符串转成数值类型，并赋值给v
			v1 = Long.parseLong(s1);
			v2 = Long.parseLong(s2);
		}catch(NumberFormatException e){
			System.out.println("error：" + e.getMessage());
			System.out.println("您的输入超出限定值\n程序结束！");
			System.exit(0);
		}
		
		//比较和返回
		if(v1==v2){
			return "Equal";
		}else{
			return v1<v2?"Less(v1<v2)":"Greater(v1>v2)";
		}
	}
}
