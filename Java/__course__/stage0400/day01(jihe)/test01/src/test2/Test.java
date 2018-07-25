/*
	HashMap
	1）创建Student类，包含String类型的name，int类型的age，double类型的score，并重写getter、setter等方法。
	2）创建5个Student对象。已知一个Integer类型的学号对应唯一的一个Student对象
	3）将5个Student对象保存到HashMap容器中。
	4）遍历该容器，打印出来。
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
		
		Student stu1 = new Student("张三", 18, 90);
		Student stu2 = new Student("李四", 15, 60);
		Student stu3 = new Student("王五", 19, 80);
		Student stu4 = new Student("小张", 21, 99);
		Student stu5 = new Student("小明", 35, 88);
		
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