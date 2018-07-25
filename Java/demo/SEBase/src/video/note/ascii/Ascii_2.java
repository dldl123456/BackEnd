/*
 * 用ASCII变换大小写 
 */

package video.note.ascii;

import java.util.Scanner;

public class Ascii_2 {
	public static void main(String[] args){
		System.out.print("请输入一个小写字母：");
		
		Scanner in = new Scanner(System.in);
		char ch = in.next().charAt(0);
		in.close();
	    
	    ch -= 32;	
	    
	    System.out.println("该小写字母的大写是：" + ch);
	}
}