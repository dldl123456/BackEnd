/*
 *  �Ӽ�������һ���ַ��������й������֮�������
 *  ���ܵķ����ǽ�ÿ���ַ�ӳ�����ĸ���еĶԳ��ַ�������a��Ӧz��b��Ӧy���ַ�����Java�����ܺ�ͳ�Ϊ��Qzfz����
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
