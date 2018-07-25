package video.note.stringBuilderDemo;

public class StringBuilderDemo {
	public static void main(String[] args) {
		//StringBuilder sb = "abc";  //无此种声明方式
		StringBuilder sb = new StringBuilder();  //是一个无参的构造方法，默认开辟16个字符大小的容量的数组
		//StringBuilder sb = new StringBuilder(100);  //初始化容量大小
		//StringBuilder sb = new StringBuilder("abc");  //前三个abc
		
		sb.append("aa");  //在字符串数组中追加
		sb.append(1.5);  //很多方法的重载，所以可以放任意类型，并且都转换成字符串
		System.out.println(sb.length());  //长度
		System.out.println(sb.capacity());  //容量
		sb.insert(1, "www");  //在某个地方插入
		System.out.println(sb.toString());  //输出
		sb.replace(1, 3, "1008686");  //替换
		System.out.println(sb.toString());
		System.out.println(sb.indexOf("w"));  //w首次出现的下标
		System.out.println(sb.reverse());  //反转输出，倒着输
	}
}