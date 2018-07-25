/*
 *  字符串练习(常用)
 */

package video.note.StringDemo;

public class StringDemo {
	public static void main(String[] args) {
		String content = "hello , my frIend !";
		//根据索引选择
		System.out.println(content.charAt(4));
		//比较
		System.out.println(content.compareTo("Hello"));
		//拼接 等同content += "10086";
		content = content.concat("10086");
		System.out.println(content);
		//以什么结束
		System.out.println(content.endsWith("10086"));
		//以什么开始
		System.out.println(content.startsWith("hello"));
		//是否包含某个字符串
		System.out.println(content.contains("my"));
		//比较
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		//比较2
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		//查询(第一次出现的下标)
		System.out.println(content.indexOf("o"));
		//查询(最后一次出现的下标)
		System.out.println(content.lastIndexOf("o"));
		//查询(从下标为5的地方去找第一次出现o的下标)
		System.out.println(content.indexOf("o", 5));
		//长度
		System.out.println(content.length());
		//替换字符串
		System.out.println(content.replace('h', 's'));
		//拆分字符串(以空格区分)
		String[] arr = content.split(" ");
		System.out.println(arr.length);
		for(String i : arr){
			System.out.println(i);
		}
		//截取字符串
		System.out.println(content.substring(4));
		System.out.println(content.substring(4, 15));
		//大小写
		System.out.println(content.toLowerCase());
		System.out.println(content.toUpperCase());
	}
}
