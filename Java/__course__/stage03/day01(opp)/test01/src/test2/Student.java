/*
 *  编写一个类Student，代表学员，要求：
 *  1) 具有属性：姓名、年龄、性别、专业
 *  2) 具有方法：自我介绍，负责输出该学员的姓名、年龄、性别以及专业
 *  3) 具有两个带参数的构造方法：
 *  第一个构造方法中，设置学员的性别为男，专业为Android，其余属性的值由参数给定；第二个构造方法中，所有属性都由参数给定
 *  编写测试类StudentTest进行测试，分别以两种方式对两个Student对象进行初始化，并分别调用他们的自我介绍方法，看看输出结果是否正确
 *  
 */

package test2;

public class Student {
	//定义变量
	private String name;  //名字
	private String major;  //专业
	private int age;  //年龄
	private char sex;  //性别
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
		this.sex = '男';
		this.major = "Android";
	}
	
	public Student(String name, String major, int age, char sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.major = major;
	}

	// alt + shift + s ==> Generate Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String studentTest() {
		return "大家好！我叫" + name + "，一个乐观的" + sex + "生，" + "今年" + age + "岁了，我现在主修的专业是" + major;
	}
	
	//主方法（程序入口）
	public static void main(String[] args) {
		Student stu1 = new Student("Jack", 3);  //new一个学生对象（实例化一个stu1）
		Student stu2 = new Student("Anne", "IOS", 5, '女');  //new一个学生对象（实例化一个stu2）
		
		System.out.println(stu1.studentTest());
		System.out.println(stu2.studentTest());
	}
}