/*
 *  �����������͵ıȽ�
 */

package step3.course.day11_23;

public class Demo_1 {
	public static void main(String[] args) {	
		String aa = new String("abc");
		String bb = new String("abc");
		
		System.out.println(aa==bb);
		System.out.println(aa.equals(bb));
		
		String str1 = "abc";  //ֻ���String���ڶ��ڴ���Ѱ��abc
		String str2 = "abc";
		
		System.out.println(str1==str2);
		System.exit(0);  //ִ�е�ǰ�������
	}
}
