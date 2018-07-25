/*
	创建一个Worker类，具有属性 name sex salary level
	创建一个linkedlist作为容器，数据源定义在main方法中
	写出一下方法：
	1.录入5条工人信息
	2.输出所有工人信息
	3.根据工人的id通过匿名内部类进行排序，并且输出，要求工人的排序不影响源数据顺序
	通过存放在一个新的arraylist中进行排序
	4.所有男性工人的工资在原有基础上加200
	5.通过使用listiterator修改所有工资超过5000的员工级别为H
 */

package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Test.linkedListTest();
	}
	
	public static void linkedListTest(){
		//实例化存放worker对象的LinkedList和集合
		List<Worker> sList = new LinkedList<>();
		List<Worker> aryList = new ArrayList<>();
		
		Worker worker1 = new Worker(4, "张三", "高级", '男', 6000);
		Worker worker2 = new Worker(5, "李四", "中级", '男', 2500);
		Worker worker3 = new Worker(3, "王五", "初级", '男', 1235);
		Worker worker4 = new Worker(1, "赵六", "高级", '男', 9000);
		Worker worker5 = new Worker(2, "*七", "中级", '男', 5000);
		
		//录入5条工人信息
		sList.add(worker1);
		sList.add(worker2);
		sList.add(worker3);
		sList.add(worker4);
		sList.add(worker5);
		
		System.out.println("未排序：");
		
		//实现Iterator接口输出所有工人信息
		Iterator<Worker> it = sList.iterator();
		while(it.hasNext()){
			Worker works = it.next();
			System.out.println(works);
		}
		
		//linkedlist存入arraylist
		aryList.addAll(sList);
		
		//根据工人的id通过匿名内部类进行排序，并且输出，要求工人的排序不影响源数据顺序
		Collections.sort(aryList, new Comparator<Worker>(){
			@Override
			public int compare(Worker o1, Worker o2) {
				if(o1.getId() - o2.getId()<0){
					return -1;
				}else{
					return 1;
				}
			}
		});
		
		System.out.println("排序后：");
		
		//用foreach输出排序后的工人
		for(Worker work : aryList){
			System.out.println(work);
			
		}
		
		System.out.println("工资添加200：");
		
		//工资添加200
		for(Worker worker : aryList){
			worker.setSalary(worker.getSalary()+200);
			
			System.out.println(worker);
		}
		
		System.out.println("设置超过工资5000的员工级别为H:");
		
		//设置超过工资5000的员工级别为H
		Iterator<Worker> iter = sList.listIterator();
		while(iter.hasNext()){
			Worker worker = iter.next();
			if(worker.getSalary()>=5000){
				worker.setLevel("H");
			}
			
			System.out.println(worker);
        } 
	}
}