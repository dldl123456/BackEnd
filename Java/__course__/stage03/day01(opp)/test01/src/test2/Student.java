/*
 *  ��дһ����Student������ѧԱ��Ҫ��
 *  1) �������ԣ����������䡢�Ա�רҵ
 *  2) ���з��������ҽ��ܣ����������ѧԱ�����������䡢�Ա��Լ�רҵ
 *  3) ���������������Ĺ��췽����
 *  ��һ�����췽���У�����ѧԱ���Ա�Ϊ�У�רҵΪAndroid���������Ե�ֵ�ɲ����������ڶ������췽���У��������Զ��ɲ�������
 *  ��д������StudentTest���в��ԣ��ֱ������ַ�ʽ������Student������г�ʼ�������ֱ�������ǵ����ҽ��ܷ����������������Ƿ���ȷ
 *  
 */

package test2;

public class Student {
	//�������
	private String name;  //����
	private String major;  //רҵ
	private int age;  //����
	private char sex;  //�Ա�
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
		this.sex = '��';
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
		return "��Һã��ҽ�" + name + "��һ���ֹ۵�" + sex + "����" + "����" + age + "���ˣ����������޵�רҵ��" + major;
	}
	
	//��������������ڣ�
	public static void main(String[] args) {
		Student stu1 = new Student("Jack", 3);  //newһ��ѧ������ʵ����һ��stu1��
		Student stu2 = new Student("Anne", "IOS", 5, 'Ů');  //newһ��ѧ������ʵ����һ��stu2��
		
		System.out.println(stu1.studentTest());
		System.out.println(stu2.studentTest());
	}
}