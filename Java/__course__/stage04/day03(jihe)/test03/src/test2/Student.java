package test2;

public class Student {
	//ѧ������(��ʼ��)
	private int id = 0;  //ѧ��
	private String name = null;  //����
	private int age = 0;  //����
	private char sex = 0;  //�Ա�
	private double grades = 0.0;  //����	
	
	//Ϊѧ�����Կ��Žӿ�
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
		if(sex=='��'||sex=='Ů'){
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
	
	//�޲ι��췽��
	public Student() {}
	
	//�вι��췽��(��ʼ��)
	public Student(int id, String name, int age, char sex, double grades) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.grades = grades;
	}
	
	//toString����
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", grades=" + grades + "]";
	}
}
