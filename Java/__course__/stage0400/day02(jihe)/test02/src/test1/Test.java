/*
	ѧ���ࣺid name age
	дһ��������ѭ��¼����������
	дһ��������ɾ��idΪ10����
	дһ����������ѯ�������Ƿ����һ�������ĵ���
	дһ����������ѯ�������Ƿ���һ�������岢������Ϊ32����
	дһ����������ȡ���������ֽ����壬����Ϊ32��idΪ4���˵��±�
	ͨ������±������˽����޸� �޸���������Ϊ55
	дһ�������������������ѧ������Ϣ
	дһ�����������������������Ϊ4��ѧԱ��Ϣ
 */

package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Student> arylist = new ArrayList<>();
		
		//ѭ��¼����������
		Test.addStudent(arylist);
		
		//ɾ��idΪ10����
		Test.delete(arylist);
		
		//��ѯ�������Ƿ����һ�������ĵ���
		Test.query1(arylist);
		
		//��ѯ�������Ƿ����һ�������ĵ���
		Test.query2(arylist);
		
		//��ȡ���������ֽ����壬����Ϊ32��idΪ4���˵��±�,ͨ������±������˽����޸� �޸���������Ϊ55
		Test.query3(arylist);
		
		//�����������ѧ������Ϣ
		Test.output1(arylist);
		
		//���������������Ϊ4��ѧԱ��Ϣ
		Test.output2(arylist);
	}
	
	//дһ��������ѭ��¼����������
	public static void addStudent(List<Student> arylist){
		//ʵ����ѧ��
		Student stu1 = new Student(10, "����", 20);
		Student stu2 = new Student(2, "����", 22);
		Student stu3 = new Student(4, "����", 32);
		Student stu4 = new Student(1, "����", 4);
		Student stu5 = new Student(3, "����", 4);
		
		arylist.add(stu1);
		arylist.add(stu2);
		arylist.add(stu3);
		arylist.add(stu4);
		arylist.add(stu5);
		
		System.out.println("�����еĳ�ʼ����Ϊ��");
		
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//дһ��������ɾ��idΪ10����
	public static void delete(List<Student> arylist){
		//��֪��Ϊʲô�ᱨ��java.util.ConcurrentModificationException��
		/*for(Student stu : arylist){
			if(stu.getId()==10){
				arylist.remove(stu);
			}
		}*/
		//ɾ��
		Iterator<Student> iter = arylist.iterator(); 
		while(iter.hasNext()){
			Student str = iter.next();
			if(str.getId()==10){
				iter.remove();
			}
		}
		
		System.out.println("ɾ��idΪ10����֮�������Ϊ��");
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//дһ����������ѯ�������Ƿ����һ�������ĵ���
	public static void query1(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("����")){
				System.out.println("���Ĵ���");
			}
		}
	}
	
	//дһ����������ѯ�������Ƿ���һ�������岢������Ϊ32����
	public static void query2(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("����") && stu.getAge()==32){
				System.out.println("32����������");
			}
		}
	}
	
	//дһ����������ȡ���������ֽ����壬����Ϊ32��idΪ4���˵��±�,ͨ������±������˽����޸� �޸���������Ϊ55
	public static void query3(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("����") && stu.getAge()==32 && stu.getId() == 4){
				System.out.println("���壬����Ϊ32��idΪ4�����ڼ����е�����Ϊ" + arylist.indexOf(stu));
				stu.setAge(55);
				arylist.set(arylist.indexOf(stu), stu);
				System.out.println(stu);
			}
		}
	}
	
	//дһ�������������������ѧ������Ϣ
	public static void output1(List<Student> arylist){
		System.out.println("�����������ѧ������Ϣ��");
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//дһ�����������������������Ϊ4��ѧԱ��Ϣ
	public static void output2(List<Student> arylist){
		System.out.println("���������������Ϊ4��ѧԱ��Ϣ��");
		for(Student stu : arylist){
			if(stu.getAge()==4){
				System.out.println(stu);
			}
		}
	}
}