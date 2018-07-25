/*
 * 从键盘输入一个字母，判断其为大写还是小写字母，将其转化为相应的大小写字母输出。 
 */

package classic.sequentially.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_1 {
	public static void main(String[] args) {
		System.out.print("请任意输入一个字母：");
		char ch = 0;  //用来保存一个任意字母
		
		//输入一个任意字母
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//判断该字母的大小写，并将其转换为相应的大小写，并输出
		if(Character.isUpperCase(ch)){
			System.out.println("该字母为大写");
			System.out.println("该字母的小写为：" + Character.toLowerCase(ch));
		} else {
			System.out.println("该字母为小写");
			System.out.println("该字母的大写为：" + Character.toUpperCase(ch));
		}
	}
}
