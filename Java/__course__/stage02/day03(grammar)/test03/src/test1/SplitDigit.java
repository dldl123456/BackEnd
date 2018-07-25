/*
 *  打印输出12.25的各个位的数字
 */

package test1;

public class SplitDigit {
	public static void main(String[] args) {
		int num = (int)(12.25*100);  //去掉小数点，并将浮点型数字转换成整型

		String str = String.valueOf(num);  //将整型转换成字符串
		char[] ch=str.toCharArray();  //将字符串存入数组
		
		//遍历数组输出，用空格分割
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i]+"  ");
		}
	}
}
