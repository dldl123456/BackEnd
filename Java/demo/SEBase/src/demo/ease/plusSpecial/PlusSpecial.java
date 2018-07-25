/*
 *  用特殊的加法计算用户输入的三个数之和
 *  
 *  5+3+2=151022
 *  9+2+4=183652
 *  8+6+3=482466
 *  5+4+5=202541
 *  7+2+5=？
 */

package demo.ease.plusSpecial;

import java.util.Scanner;

public class PlusSpecial {
	public static void main(String[] args) {
		System.out.println("***********特殊的加法计算***********");
		
		//定义变量
		int num1 = 0, 
			num2 = 0, 
			num3 = 0;  //用来保存用户输入的三个数
		int n = 0;  //用来保存用户需要计算的次数
		int res = 0;  //用来保存计算结果
		
		String answer = "";  //保存重新输入的y/n
		
		boolean isTrue = false;  //用来判断执行次数
		
		Scanner in = new Scanner(System.in);  //获取输入
		
		//循环控制输入次数
		do{
			System.out.print("请问您需要进行几次计算：");
			
			n = in.nextInt();  //获取用户输入的次数
			
			System.out.println("计算开始了！\n");
			
			for(int i=1; i<=n; i++){
				System.out.println("第" + i + "次计算");
				
				System.out.print("请输入三个正整数，用空格隔开：");
				
				num1 = in.nextInt();
				num2 = in.nextInt();
				num3 = in.nextInt();  //获取用户输入的三个数
				
				//根据特殊公式计算结果
				res = Integer.parseInt(Integer.toString(num1*num2) + Integer.toString(num1*num3) + Integer.toString((num1*num2)+(num1*num3)-num2));
				
				//输出计算结果
				System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + res + "\n");
			}
			
			//让用户判断是否继续执行
			System.out.print("是否要继续进行计算?(y/n)：");
			
			answer = in.next();  //获取用户输入的（y/n）
			
			//判断
			if (answer.equals("y")){  //“==”比较两个变量本身的值，即两个对象在内存中的首地址；“equals()”比较字符串中所包含的内容是否相同。
				isTrue = true;
			}else{
				isTrue = false;
			}
		}while(isTrue);
		
		//程序结束
		System.out.println("计算结束！");
		
		in.close();  //关闭键盘
	}
}
