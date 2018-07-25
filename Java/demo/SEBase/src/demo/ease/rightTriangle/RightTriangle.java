package demo.ease.rightTriangle;

import java.util.Scanner;

public class RightTriangle {
	public static void main(String args[]){
		System.out.println("请输入行数");
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		in.close();
		
        System. out.println( "输出"+ a +"行星号" ); 
        
        // 外层循环控制行数
		for(int i=1; i<=a; i++){
			// 内层循环控制每行的*号数
            // 内层循环变量的最大值和外层循环变量的值相等
			for ( int j = 1; j <= i ; j ++ ){
				System. out.print( "*" );
			}
			// 每打印完一行后进行换行
            System. out.println();
		}
	}
}
