/*
 *  从键盘输入一个字符，若为小写字母，则转化为大写字母;若为大写字母，则转化为小写字母，否则保持不变。
 */

package classic.choosing.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_2 {
	public static void main(String[] args) {
		System.out.print("请输入一个字符：");
		
		char ch = 0;  //用来保存一个字符
		
		//输入一个字符
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//判断字符并按条件输出
		if(Character.isUpperCase(ch)){
			System.out.println("该字母为大写");
			System.out.println("该字母的小写为：" + (ch += 32));
		} else if (Character.isLowerCase(ch)){
			System.out.println("该字母为小写");
			System.out.println("该字母的大写为：" + (ch -= 32));
		} else {
			System.out.println("该字符不是字母，该字符为：" + ch);
		}
	}
}
