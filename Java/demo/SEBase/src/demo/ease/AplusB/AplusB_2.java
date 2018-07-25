package demo.ease.AplusB;

import java.util.Scanner;

public class AplusB_2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextInt()){
			int a = in.nextInt();
			int b = in.nextInt();
			
			System. out.println( a + " + " + b + " = " + ( a + b) );
		}
		
		in.close();
	}
}
