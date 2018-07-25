package project.StudentMS_4;

public class Student {
	//学生账号
	private String user = "";	//学生用户名
	private String pwd = "";	//学生密码
	//学生属性
	private String name = "";	//名字
	private int age = 0;	//年龄
	private char sex = 0;	//性别
	private String address = "";	//地址
	//学生成绩
	private double math = 0.0;	//数学分数
	private double chinese = 0.0;  //语文
	private double English = 0.0;	//英语分数
	private double sum = 0.0;	//总分
	
	//构造方法(无参)
	public Student() {
		
	}
	//构造方法(学生账号)
	public Student(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	//构造方法(学生属性)
	public Student(String name, int age, char sex, String address, double math, double chinese, double English, double sum) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.math = math;
		this.chinese = chinese;
		this.English = English;
		this.sum = sum;
	}
	
	//为学生私有属性开放接口
	public String getUser() {  //user
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPwd() {  //pwd
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {  //name
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {  //age
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getSex() {  //sex
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String getAddress() {  //address
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getMath() {  //math
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public double getChinese() {  //chinese
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	
	public double getEnglish() {  //English
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
	
	public double getSum() {  //sum
		return sum;
	}
	public void setSum(int math,int English) {
		this.sum = math+English;
	}
	
	//返回Student对象数组(默认学生)
	public static Student[] getStudent() {
	    Student[] stu = new Student[3];
		Student stu1 = new Student("张三", 18, '男', "北京", 61, 90, 63, (61+90+63));
		Student stu2 = new Student("李四", 45, '女', "上海", 35, 88, 42.5, (35+88+42.5));
		Student stu3 = new Student("王五", 33, '男', "广东", 26.5, 55, 60, (26.5+55+60));
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		return stu;	
	}
	
	//默认学生账号
	public static Student[] stuAccount(){
		Student[] stu = new Student[1];
		Student stu1 = new Student("stu000", "123");
		stu[0] = stu1;
		return stu;
	}
	
	//重写String方法
	public String toString() {
		return  name + "\t" + sex + "\t" + age + "\t" + 
				math + "\t" + chinese + "\t" + English + "\t" + 
				sum + "\t" + address;
	}
	
	//测试类
	public static void main(String[] args) {
		//返回默认学生信息
		Student[] stuInfo = Student.getStudent();  //实例化学生对象数组
		Student[] stuAccount = Student.stuAccount();  //实例化学生账号对象数组
		//学生属性
		for(Student i:stuInfo){
			System.out.println(i);  //等同于i.toSting
		}
		//学生账号
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
	}
}
