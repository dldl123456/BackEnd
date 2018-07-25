/*
 *  从键盘两个整数，求其最大公约数和最小公倍数
 */

package classic.loop.GCDandLCM;

import java.util.Scanner;

public class GCDandLCM {
	static public int gcd1_1(int x, int y)   //非递归的辗转相除法
	 {
	  int temp;
	  
	  do{
	  temp = x % y;
	  x = y;
	  y = temp;
	  }while(temp != 0); 
	  
	  return x;
	 }
	 
	 static public int gcd2_1(int x, int y)   //非递归的辗转相减法
	 {
	  int max, min;
	  int temp;
	  max = (x > y) ? x : y;
	  min = (x < y) ? x : y;
	  
	  while (max != min)
	  {
	   temp = max - min;
	   max = (temp > min) ? temp : min;
	   min = (temp < min) ? temp : min;   
	  }
	  
	  return max;
	 }
	 
	 static public int gcd1_2(int x, int y)   //递归的辗转相除法
	 {
	  return (y == 0) ? x : gcd1_2(y, x % y);
	 }
	 
	 static public int gcd2_2(int x, int y)   //递归的辗转相减法
	 {
	  if(x == y) return x;
	  return (x > y) ? gcd2_2(x - y, y) : gcd2_2(x, y - x);
	 }
	 
	public static void main(String[] args) {
		//定义变量
		int num1 = 0;  //要求用户输入的数字1
		int num2 = 0;  //要求用户输入的数字2
		int res = 0;  //用来保存结果
		
		//提示
		System.out.print("请从键盘输入两个整数，用空格隔开：");
		
		//获取输入
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();   
		in.close();
		
		 res = gcd1_1(num1, num2);
		  System.out.println("最大公约数为：" + res);
		  res = gcd1_2(num1, num2);
		  System.out.println("最大公约数为：" + res);
		  res = gcd2_1(num1, num2);
		  System.out.println("最大公约数为：" + res);
		  res = gcd2_2(num1, num2);
		  System.out.println("最大公约数为：" + res);
		  System.out.println("最小公倍数为： " + num1 * num2 / res); // 最小公倍数
	}
}
