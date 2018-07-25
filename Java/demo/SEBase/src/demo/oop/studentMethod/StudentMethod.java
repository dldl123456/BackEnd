package demo.oop.studentMethod;

public class StudentMethod {
	//定义变量
	public String name;  //名字
	public String major;  //专业
	public int age;  //年龄
	public char sex;  //性别
	
	//构造方法，给StudentMethod类赋默认值（初始化）
	public StudentMethod(){
		name = "Anne";  //名字
		major = "IOS";  //专业
		age = 3;  //年龄
		sex = '女';
	}	

	//自我介绍
	public void StudentTest(String name, String major, int age, char sex){
		System.out.println("大家好！我叫" + name + "，一个乐观的" + sex + "生，" + "今年" + age + "岁了，我现在主修的专业是" + major);
	}
	
	//主方法（程序入口）
	public static void main(String[] args) {
		StudentMethod stu1 = new StudentMethod();  //new一个学生对象（实例化一个stu1）
		stu1.StudentTest(stu1.name, stu1.major, stu1.age, stu1.sex);  //调用自我介绍的方法
		
		StudentMethod stu2 = new StudentMethod();  //new一个学生对象（实例化一个stu1）
		stu2.major = "Android";  //给实例化的学生对象的major属性赋值
		stu2.sex = '男';  ////给实例化的学生对象的sex属性赋值
		stu1.StudentTest(stu1.name, stu2.major, stu1.age, stu2.sex);  //调用自我介绍的方法
	}
}
