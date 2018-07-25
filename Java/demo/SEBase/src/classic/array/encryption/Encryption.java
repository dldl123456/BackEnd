/*
 *  从键盘输入一行字符，按下列规则加密之后输出。
 *  加密的方法是将每个字符映射成字母表中的对称字符。例如a对应z，b对应y，字符串“Java”加密后就成为“Qzfz”。
 */

package classic.array.encryption;

import java.util.Scanner;

public class Encryption {
	public static void main(String[] args) {
		String input = null;
		Scanner in = new Scanner(System.in);
		input = in.next();
		in.close();
		StringBuffer changed = new StringBuffer();
		
		for(int i = 0;i < input.length();i++){
			char x = input.charAt(i);
			
			if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
				x = (char) ('a'  + 'z' - x);
				changed.append(x);
			}else if(x >= 'A' && x <= 'Z'){
				x = (char) ('A'  + 'Z' - x);
				changed.append(x);
			}else{
				continue;
			}
		}
		System.out.println(changed);
	}
}
