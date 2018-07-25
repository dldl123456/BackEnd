/*
 *  从键盘输入一个字符，若为小写字母，则转化为大写字母，否则保持不变。
 */

package classic.choosing.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_1 {
	public static void main(String[] args) {
		System.out.print("请任意输入一个字母：");
		char ch = 0;  //用来保存一个任意字母
		
		//输入一个任意字母
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//判断该字母的大小写，并按条件输出
		if(Character.isUpperCase(ch)){
			System.out.println("该字母为大写，该字母为：" + ch);
		} else {
			System.out.println("该字母为小写");
			System.out.println("该字母的大写为：" + (ch -= 32));
		}
	}
}
