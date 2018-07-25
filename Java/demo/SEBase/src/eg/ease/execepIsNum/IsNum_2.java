package eg.ease.execepIsNum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IsNum_2 {
	public static void main(String[] args) {
		int num = 0;  //用来保存一个整数
		System.out.print("请输入一个整数：");
		
		do{
			//因为这段程序可能出现异常，所以用try来监测这块代码
			try{  //监测
				Scanner in = new Scanner(System.in);  //获取输入
				num = in.nextInt();  //让用户输入一个整数(如果用户输入不是整数，则会报错InputMismatchException,所以需要抛出异常)
				in.close();
				break;
			}catch(InputMismatchException e){
				System.out.print("您输入的不是整数，请输入整数：");  //打印错误信息
			}catch(Exception e){
				System.out.print("您输入的不是整数，请输入整数：");  //打印错误信息
			}
		}while(true);
		
		System.out.println("\n您输入的" + num + "是整数，程序结束！");
		System.exit(0);
	}
}
