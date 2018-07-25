/*
 *  计算 1 到 n 之间不能被 3 整除的数之和
 */

package demo.ease.cal;

import java.util.Scanner;

public class Cal {
	public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	in.close();
    	
        int sum = 0;
        for( int i=1 ; i<=n ; i++){
              if( i%3 != 0 ){
                    sum += i;
             }
       }
       System. out.println( "1到" + n + "之间不能被3整除的数之和为：" +sum );
    }
}
