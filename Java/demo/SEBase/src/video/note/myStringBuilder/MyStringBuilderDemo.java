/*
 *  自定义一个自己的StringBuilder类
 */

package video.note.myStringBuilder;

import java.util.Arrays;

public class MyStringBuilderDemo {
	//主方法，程序入口
	public static void main(String[] args) {
		MyStringBuilder msb = new MyStringBuilder();
		
		msb.append("1sd");
		msb.append("123").append("zzz123123");
		
		System.out.println("字符个数：" + msb.length());
		System.out.println("总容量大小：" + msb.capacity());
		System.out.println("字符个数：" + msb);  //相当于toString方法
	}
}

class MyStringBuilder{
	private char[] value;  //字符数组
	private int count = 0;  //字符数组存放字符的个数
	
	//构造方法
	public MyStringBuilder(){  //重载
		value = new char[16];
	}
	
	public MyStringBuilder(int capacity){
		value = new char[capacity];
	}
	
	public MyStringBuilder(String str){
		value = new char[str.length()+16];
	}
	
	//得到字符数组中的字符个数
	public int length(){
		return count;
	}
	
	//返回容器的容量大小
	public int capacity(){
		return value.length;
	}
	
	//实现追加字符串
	public MyStringBuilder append(String str){
		int len = str.length();  //获取要添加字符串的长度
		//确保字符数组能放进去所添加的字符串
		ensureCapacity(count+len);
		//把要添加的字符串追加到新的指定数组的指定位置的后面
		str.getChars(0, len, value, count);
		count += len;  //元素的个数增加了
		
		//返回当前你所创建的动态字符串
		return this;
	}
	
	//确保字符数组能放进去所添加的字符串(本类的一个帮助方法)
	//判断是否要扩容
	private void ensureCapacity(int capacity){
		//数据超出了容量大小
		if(capacity-value.length>0){
			int newCapacity = value.length*2+2;  //扩容后新字符数组的大小
			value = Arrays.copyOf(value, newCapacity);  //拷贝旧数组到新数组中并命名为旧数组的名字
		}
	}
	
	//将字符数组中的字符转换成字符串表示
	public String toString(){
		return new String(value, 0, count);
	}
}

