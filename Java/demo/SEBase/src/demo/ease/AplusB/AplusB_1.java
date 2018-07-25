package demo.ease.AplusB;

import java.util.Scanner;

public class AplusB_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		
		System. out.println( a + " + " + b + " = " + ( a + b) );
	}
}
