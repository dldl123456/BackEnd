package demo.oop.studentMethod;

public class StudentMethod {
	//�������
	public String name;  //����
	public String major;  //רҵ
	public int age;  //����
	public char sex;  //�Ա�
	
	//���췽������StudentMethod�ำĬ��ֵ����ʼ����
	public StudentMethod(){
		name = "Anne";  //����
		major = "IOS";  //רҵ
		age = 3;  //����
		sex = 'Ů';
	}	

	//���ҽ���
	public void StudentTest(String name, String major, int age, char sex){
		System.out.println("��Һã��ҽ�" + name + "��һ���ֹ۵�" + sex + "����" + "����" + age + "���ˣ����������޵�רҵ��" + major);
	}
	
	//��������������ڣ�
	public static void main(String[] args) {
		StudentMethod stu1 = new StudentMethod();  //newһ��ѧ������ʵ����һ��stu1��
		stu1.StudentTest(stu1.name, stu1.major, stu1.age, stu1.sex);  //�������ҽ��ܵķ���
		
		StudentMethod stu2 = new StudentMethod();  //newһ��ѧ������ʵ����һ��stu1��
		stu2.major = "Android";  //��ʵ������ѧ�������major���Ը�ֵ
		stu2.sex = '��';  ////��ʵ������ѧ�������sex���Ը�ֵ
		stu1.StudentTest(stu1.name, stu2.major, stu1.age, stu2.sex);  //�������ҽ��ܵķ���
	}
}
