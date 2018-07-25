/*
	HashMap
	1������Student�࣬����String���͵�name��int���͵�age��double���͵�score������дgetter��setter�ȷ�����
	2������5��Student������֪һ��Integer���͵�ѧ�Ŷ�ӦΨһ��һ��Student����
	3����5��Student���󱣴浽HashMap�����С�
	4����������������ӡ������
 */

package test2;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Test {
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer, Student> map = new HashMap<>();
		
		Student stu1 = new Student("����", 18, 90);
		Student stu2 = new Student("����", 15, 60);
		Student stu3 = new Student("����", 19, 80);
		Student stu4 = new Student("С��", 21, 99);
		Student stu5 = new Student("С��", 35, 88);
		
		map.put(1001, stu1);
		map.put(1002, stu2);
		map.put(1003, stu3);
		map.put(1004, stu4);
		map.put(1005, stu5);
		
		Set<Entry<Integer, Student>> entrys = map.entrySet();
		
		for(Entry<Integer, Student> entry:entrys){
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
	}
}