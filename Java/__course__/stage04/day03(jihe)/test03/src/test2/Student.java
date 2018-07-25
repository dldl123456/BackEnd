package test2;

public class Student {
	//学生属性(初始化)
	private int id = 0;  //学号
	private String name = null;  //姓名
	private int age = 0;  //年龄
	private char sex = 0;  //性别
	private double grades = 0.0;  //分数	
	
	//为学生属性开放接口
	public int getId() {  //id
		return id;
	}
	public void setId(int id) {
		if(id>0) {
			this.id = id;
		}
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
		if(age>0){
			this.age = age;
		}
	}
	
	public char getSex() {  //sex
		return sex;
	}
	public void setSex(char sex) {
		if(sex=='男'||sex=='女'){
			this.sex = sex;
		}
	}
	
	public double getGrades() {  //grades
		return grades;
	}
	public void setGrades(double grades) {
		if(grades>=0||grades<=100){
			this.grades = grades;
		}
	}
	
	//无参构造方法
	public Student() {}
	
	//有参构造方法(初始化)
	public Student(int id, String name, int age, char sex, double grades) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.grades = grades;
	}
	
	//toString方法
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", grades=" + grades + "]";
	}
}
