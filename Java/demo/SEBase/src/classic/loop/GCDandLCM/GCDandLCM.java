/*
 *  �Ӽ��������������������Լ������С������
 */

package classic.loop.GCDandLCM;

import java.util.Scanner;

public class GCDandLCM {
	static public int gcd1_1(int x, int y)   //�ǵݹ��շת�����
	 {
	  int temp;
	  
	  do{
	  temp = x % y;
	  x = y;
	  y = temp;
	  }while(temp != 0); 
	  
	  return x;
	 }
	 
	 static public int gcd2_1(int x, int y)   //�ǵݹ��շת�����
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
	 
	 static public int gcd1_2(int x, int y)   //�ݹ��շת�����
	 {
	  return (y == 0) ? x : gcd1_2(y, x % y);
	 }
	 
	 static public int gcd2_2(int x, int y)   //�ݹ��շת�����
	 {
	  if(x == y) return x;
	  return (x > y) ? gcd2_2(x - y, y) : gcd2_2(x, y - x);
	 }
	 
	public static void main(String[] args) {
		//�������
		int num1 = 0;  //Ҫ���û����������1
		int num2 = 0;  //Ҫ���û����������2
		int res = 0;  //����������
		
		//��ʾ
		System.out.print("��Ӽ������������������ÿո������");
		
		//��ȡ����
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();   
		in.close();
		
		 res = gcd1_1(num1, num2);
		  System.out.println("���Լ��Ϊ��" + res);
		  res = gcd1_2(num1, num2);
		  System.out.println("���Լ��Ϊ��" + res);
		  res = gcd2_1(num1, num2);
		  System.out.println("���Լ��Ϊ��" + res);
		  res = gcd2_2(num1, num2);
		  System.out.println("���Լ��Ϊ��" + res);
		  System.out.println("��С������Ϊ�� " + num1 * num2 / res); // ��С������
	}
}
