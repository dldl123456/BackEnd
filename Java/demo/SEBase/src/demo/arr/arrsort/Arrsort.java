/*
 *  为指定成绩加分，直到分数大于等于 60 为止，输出加分前和加分后的成绩，并统计加分的次数
 */

package demo.arr.arrsort;

import java.util.Scanner;

public class Arrsort {
	public static void main(String[] args){
        System. out.print( "请输入考试成绩：" );
        Scanner input = new Scanner(System. in);
        int score = input.nextInt();
        System. out.println( "加分前的考试成绩为：" +score );
        input.close();
        int count = 0;
        while( score < 60 ){
           count++;
           score++;
        }
        System. out.println( "一共加了"+count +"次" );
        System. out.println( "加分后的成绩为" +score );
	}
}
