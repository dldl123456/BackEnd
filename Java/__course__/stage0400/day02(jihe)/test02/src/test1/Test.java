/*
	学生类：id name age
	写一个方法，循环录入五条数据
	写一个方法，删除id为10的人
	写一个方法，查询集合中是否存在一个叫李四的人
	写一个方法，查询集合中是否有一个叫王五并且年龄为32的人
	写一个方法，获取集合中名字叫王五，年龄为32，id为4的人的下标
	通过这个下标对这个人进行修改 修改他的年龄为55
	写一个方法，遍历输出所有学生的信息
	写一个方法，遍历输出所有年龄为4的学员信息
 */

package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Student> arylist = new ArrayList<>();
		
		//循环录入五条数据
		Test.addStudent(arylist);
		
		//删除id为10的人
		Test.delete(arylist);
		
		//查询集合中是否存在一个叫李四的人
		Test.query1(arylist);
		
		//查询集合中是否存在一个叫李四的人
		Test.query2(arylist);
		
		//获取集合中名字叫王五，年龄为32，id为4的人的下标,通过这个下标对这个人进行修改 修改他的年龄为55
		Test.query3(arylist);
		
		//遍历输出所有学生的信息
		Test.output1(arylist);
		
		//遍历输出所有年龄为4的学员信息
		Test.output2(arylist);
	}
	
	//写一个方法，循环录入五条数据
	public static void addStudent(List<Student> arylist){
		//实例化学生
		Student stu1 = new Student(10, "张三", 20);
		Student stu2 = new Student(2, "李四", 22);
		Student stu3 = new Student(4, "王五", 32);
		Student stu4 = new Student(1, "赵六", 4);
		Student stu5 = new Student(3, "王五", 4);
		
		arylist.add(stu1);
		arylist.add(stu2);
		arylist.add(stu3);
		arylist.add(stu4);
		arylist.add(stu5);
		
		System.out.println("容器中的初始数据为：");
		
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//写一个方法，删除id为10的人
	public static void delete(List<Student> arylist){
		//不知道为什么会报错（java.util.ConcurrentModificationException）
		/*for(Student stu : arylist){
			if(stu.getId()==10){
				arylist.remove(stu);
			}
		}*/
		//删除
		Iterator<Student> iter = arylist.iterator(); 
		while(iter.hasNext()){
			Student str = iter.next();
			if(str.getId()==10){
				iter.remove();
			}
		}
		
		System.out.println("删除id为10的人之后的数据为：");
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//写一个方法，查询集合中是否存在一个叫李四的人
	public static void query1(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("李四")){
				System.out.println("李四存在");
			}
		}
	}
	
	//写一个方法，查询集合中是否有一个叫王五并且年龄为32的人
	public static void query2(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("王五") && stu.getAge()==32){
				System.out.println("32岁的王五存在");
			}
		}
	}
	
	//写一个方法，获取集合中名字叫王五，年龄为32，id为4的人的下标,通过这个下标对这个人进行修改 修改他的年龄为55
	public static void query3(List<Student> arylist){
		for(Student stu : arylist){
			if(stu.getName().equals("王五") && stu.getAge()==32 && stu.getId() == 4){
				System.out.println("王五，年龄为32，id为4的人在集合中的索引为" + arylist.indexOf(stu));
				stu.setAge(55);
				arylist.set(arylist.indexOf(stu), stu);
				System.out.println(stu);
			}
		}
	}
	
	//写一个方法，遍历输出所有学生的信息
	public static void output1(List<Student> arylist){
		System.out.println("遍历输出所有学生的信息：");
		for(Student stu : arylist){
			System.out.println(stu);
		}
	}
	
	//写一个方法，遍历输出所有年龄为4的学员信息
	public static void output2(List<Student> arylist){
		System.out.println("遍历输出所有年龄为4的学员信息：");
		for(Student stu : arylist){
			if(stu.getAge()==4){
				System.out.println(stu);
			}
		}
	}
}