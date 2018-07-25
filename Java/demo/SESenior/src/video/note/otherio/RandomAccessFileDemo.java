package video.note.otherio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException{
		Person[] persons = {new Person("zz", 90), new Person("we", 50), new Person("vfvfd", 44)};
		
		RandomAccessFile raf = new RandomAccessFile("D:\\_site_\\aaa\\io2.txt", "rw");
		
		//写入数据到RandomAccessFile这个对象中
		for(int i=0; i<persons.length; i++){
			raf.writeChars(persons[i].getName());
			raf.writeInt(persons[i].getAge());
		}
		
		//读取指定位置的Person对象
		Scanner in = new Scanner(System.in);
		
		System.out.println("读取第几个Person对象数据");
		int num = in.nextInt();
		//使用seek方法来操作存取位置
		raf.seek((num-1)*Person.size());
		
		Person p = new Person();
		
		//读
		p.setName(readName(raf));
		
		p.setAge(raf.readInt());
		
		System.out.println("姓名：" + p.getName());
		System.out.println("年龄：" + p.getAge());
		
		raf.close();
		in.close();
	}
	
	private static String readName(RandomAccessFile raf) throws IOException{
		char[] name = new char[15];
		for(int i=0; i<name.length; i++){
			name[i] = raf.readChar();
		}
		return new String(name).replace('\u0000', ' ');
	}
}

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		StringBuilder builder = null;
		if(name!=null){
			builder = new StringBuilder(name);
		}else{
			//自定义长度的动态字符串
			builder = new StringBuilder(15);
		}
		
		//设定builder的固定长度(空字符'\u0000')
		//15个字符，占30个字节（java是Unicode编码）
		builder.setLength(15);
		
		this.name = builder.toString();
		this.age = age;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		StringBuilder builder = null;
		if(name!=null){
			builder = new StringBuilder(name);
		}else{
			//自定义长度的动态字符串
			builder = new StringBuilder(15);
		}
		
		//设定builder的固定长度(空字符'\u0000')
		//15个字符，占30个字节（java是Unicode编码）
		builder.setLength(15);
		
		this.name = builder.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	//每个对象所占的字节数
	public static int size(){
		return 34;
	}
}
