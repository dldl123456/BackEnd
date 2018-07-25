package eg.arr.objectArray_3;

import java.util.Arrays;
import java.util.Comparator;

public class objectArray {
	public static void main(String[] args) {
		// 创建学生数组(对象数组)。
		Student[] stu = new Student[5];
		
		// 创建5个学生对象，并赋值。
		Student s1 = new Student("张三", 27);
		Student s2 = new Student("李四", 30);
		Student s3 = new Student("王五", 80);
		Student s4 = new Student("刘琪", 60);
		Student s5 = new Student("王力", 35);
		
		// 把C步骤的元素，放到数组中。
		stu[0] = s1;
		stu[1] = s2;
		stu[2] = s3;
		stu[3] = s4;
		stu[4] = s5;
		
		// 遍历
		System.out.println("排序前：");
		for(Student s:stu){
			System.out.println(s);
		}
		System.out.println("排序后：");
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
