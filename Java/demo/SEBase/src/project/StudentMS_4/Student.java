package project.StudentMS_4;

public class Student {
	//ѧ���˺�
	private String user = "";	//ѧ���û���
	private String pwd = "";	//ѧ������
	//ѧ������
	private String name = "";	//����
	private int age = 0;	//����
	private char sex = 0;	//�Ա�
	private String address = "";	//��ַ
	//ѧ���ɼ�
	private double math = 0.0;	//��ѧ����
	private double chinese = 0.0;  //����
	private double English = 0.0;	//Ӣ�����
	private double sum = 0.0;	//�ܷ�
	
	//���췽��(�޲�)
	public Student() {
		
	}
	//���췽��(ѧ���˺�)
	public Student(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	//���췽��(ѧ������)
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
	
	//Ϊѧ��˽�����Կ��Žӿ�
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
	
	//����Student��������(Ĭ��ѧ��)
	public static Student[] getStudent() {
	    Student[] stu = new Student[3];
		Student stu1 = new Student("����", 18, '��', "����", 61, 90, 63, (61+90+63));
		Student stu2 = new Student("����", 45, 'Ů', "�Ϻ�", 35, 88, 42.5, (35+88+42.5));
		Student stu3 = new Student("����", 33, '��', "�㶫", 26.5, 55, 60, (26.5+55+60));
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		return stu;	
	}
	
	//Ĭ��ѧ���˺�
	public static Student[] stuAccount(){
		Student[] stu = new Student[1];
		Student stu1 = new Student("stu000", "123");
		stu[0] = stu1;
		return stu;
	}
	
	//��дString����
	public String toString() {
		return  name + "\t" + sex + "\t" + age + "\t" + 
				math + "\t" + chinese + "\t" + English + "\t" + 
				sum + "\t" + address;
	}
	
	//������
	public static void main(String[] args) {
		//����Ĭ��ѧ����Ϣ
		Student[] stuInfo = Student.getStudent();  //ʵ����ѧ����������
		Student[] stuAccount = Student.stuAccount();  //ʵ����ѧ���˺Ŷ�������
		//ѧ������
		for(Student i:stuInfo){
			System.out.println(i);  //��ͬ��i.toSting
		}
		//ѧ���˺�
		for(Student i:stuAccount){
			System.out.println(i.getUser() + "--" + i.getPwd());
		}
	}
}
