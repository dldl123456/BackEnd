/*
 *  以字符串格式从键盘输入，用汉字大写方式显示一串数字,若不是数字则进行报错(自定义异常)，
 *  将结果存储到名为newStrBuf的StringBuilder的对象并打印内容
 */

package dm.tip.StringBufferTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBuilderTest {
	//声明静态常量
	private final static String[] STR_strBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	
	//用正则判断某字符串是否为整数
	public static boolean isstreric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isstr = pattern.matcher(str);
	   if(!isstr.matches() ){
	       return false; 
	   } 
	   return true; 
	}
	
	//将字符串转换成大写汉字
	public static String toUppercaseChineseCharacters(String str) throws Exception{
		if(StringBuilderTest.isstreric(str)){
			//该字符串为整数时进行转换
			StringBuilder temp = new StringBuilder();  //声明一个字符串数组
			
			for (int i = 0; i < str.length(); i++) {
				temp.append(STR_strBER[str.charAt(i) - 48]);  //str.charAt(i)-48获取数值
			}
			
			str = temp.toString();  //将字符串数组中的值赋给str
		}else{
			//该字符串不为整数时，报错(自定义异常)，并终止程序
			throw new Exception("input error!");
		}
		
		return str;
	}
	
	//测试类
	public static void main(String[] args) /*throws Exception*/ {
		String str = "";  //声明一个空字符串
		System.out.print("请输入一组数字：");
		
		Scanner in = new Scanner(System.in);  //获取输入
		str = in.next();  //让用户输入
		in.close();  //关闭键盘
		
		try {
			System.out.println(StringBuilderTest.toUppercaseChineseCharacters(str));
		} catch (Exception e) {
			System.out.println("error：" + e.getMessage());
		}finally{
			//程序结束
			System.exit(0);
		}
	}
}
