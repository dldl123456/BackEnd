package eg.arr.objectArray_3;

import java.util.Arrays;
import java.util.Comparator;

public class objectArray {
	public static void main(String[] args) {
		// ����ѧ������(��������)��
		Student[] stu = new Student[5];
		
		// ����5��ѧ�����󣬲���ֵ��
		Student s1 = new Student("����", 27);
		Student s2 = new Student("����", 30);
		Student s3 = new Student("����", 80);
		Student s4 = new Student("����", 60);
		Student s5 = new Student("����", 35);
		
		// ��C�����Ԫ�أ��ŵ������С�
		stu[0] = s1;
		stu[1] = s2;
		stu[2] = s3;
		stu[3] = s4;
		stu[4] = s5;
		
		// ����
		System.out.println("����ǰ��");
		for(Student s:stu){
			System.out.println(s);
		}
		System.out.println("�����");
		Arrays.sort(stu, new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				return s2.getAge() - s1.getAge();
		}});
		for(Student s:stu){
			System.out.println(s);
		}
	}
}
