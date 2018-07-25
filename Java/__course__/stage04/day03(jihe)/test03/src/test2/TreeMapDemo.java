/*
 *  使用TreeMap保存一组学生(按照“学生对象/学号”键值对存储,按照学生考分升序排序)，
 *  遍历输出学生对象：学号
 */

package test2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapDemo {
	public static void main(String[] args) {
		//产生一个TreeMap容器,用匿名内部类根据分数升序排序(小到大)
		TreeMap<Student, Integer> pdata = new TreeMap<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int) (o1.getGrades() - o2.getGrades());
			}
		});
		
		//往容器中添加数据
		pdata.put(new Student(1, "张三", 18, '男', 56), 1);
		pdata.put(new Student(2, "李四", 15, '男', 33), 2);
		pdata.put(new Student(3, "王五", 22, '女', 98), 3);
		
		//遍历输出key和value
		Set<Entry<Student, Integer>> entrys = pdata.entrySet();
		for(Entry<Student, Integer> entry:entrys){
			System.out.println(entry.getKey() + "  -  " + entry.getValue());
		}
	}
}
