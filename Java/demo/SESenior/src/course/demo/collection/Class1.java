package course.demo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * Collection -- ArrayList
 *
 */

public class Class1 {
	@SuppressWarnings({"rawtypes", "unchecked" })
	public static void main(String[] args) {
		//ArrayList (数组结构的集合)
		User user = new User();
		
		/*
		 	数据结构
		 	堆
		 	栈
		 	队列
		 	数组
		 */
		
		ArrayList arrayList = new ArrayList();
		
		//字符串
		arrayList.add("a");
		arrayList.add("b");
		arrayList.clear();  //清空
		arrayList.add("c");
		//对象
		arrayList.add(user);
		//boolean
		arrayList.add(false);
		//float
		arrayList.add(3.1415);
		//放入集合不同的类型，取出时都是object类型，也就是说，失去原有类型
		
		
		
		/*demo1(arrayList);
		demo2(arrayList);*/
		// demo3(arrayList);
		demo5(arrayList);
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void demo(){
		//java基本数据类型 8 种
		//byte,short,int,long,float,double,char,boolean
		int[] arr = new int[10];  //数组
		
		//java集合只能存对象
		Collection collection;
		//set list
		
		//set -- 一个不包含重复元素的collection
		//list -- 有序的collection（也称为序列），允许重复的元素
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void demo1(ArrayList arrayList){
		//输出
		//默认10，自动扩容
		for(int i=0; i<10; i++){
			arrayList.add(i);
		}
		
		arrayList.remove(0);  //按下标删除
		System.out.println("集合大小" + arrayList.size());
		
		//循环遍历，从0到集合的大小
		for(int i=0; i<arrayList.size(); i++){
			//get（int index）返回列表指定位置的元素
			//获取集合中的元素
			Object value = arrayList.get(i);
			System.out.println(value);
		}
		
		//判断是否包含某个元素
		boolean exist = arrayList.contains("c");
		System.out.println("exist:" + exist);
	}
	
	@SuppressWarnings("rawtypes")
	public static void demo2(ArrayList arrayList){
		//迭代器（所有父类是Collection的集合都有迭代器）
		Iterator iterator = arrayList.iterator();  //返回一个迭代器
		System.out.println(iterator.next());  //返回当前对象并移动到下一个位置，
		//到最后报异常
		System.out.println(iterator.hasNext());  //是否有下一个指向
		
		//迭代器迭代
		while(iterator.hasNext()){  //如果集合中有元素，就返回true，没有返回false
			System.out.println("有");
			Object obj = iterator.next();
			System.out.println("iterator = " + obj);
			
			//System.out.println("有" + iterator.next());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void demo3(ArrayList arrayList){
		for(Object obj : arrayList){
			System.out.println(obj);
		}
	}
	
	@SuppressWarnings("unused")
	public static void demo4(){
		//拆装箱自动完成
		// int -- Integer
		int x = 10;
		Integer y = 20;
		double d1 = 1;
		Double d2 = 2d;
		
		// 基本数据类型对应的对象类
		Byte b;
		Short s;
		Long l;
		Float f;
		Boolean b1;
		Character ct;
		
		//基本数据类型，转成对应的对象类型（装箱）
		Integer xObj = Integer.valueOf(x);
		// Double.valuef(arg0);
		// Float.valuef(arg0);
		
		//对象类型，转成基本数据类型（拆箱）
		int xValue = xObj.intValue();
		
		//调用demo4_1
		demo4_1(10);  //自动拆装箱
	}
	
	public static void demo4_1(Integer value){
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void demo5(ArrayList arrayList){
		System.out.println("index0=" + arrayList.get(0));
		arrayList.remove(0);
		System.out.println("index0=" + arrayList.get(0));
		
		//在某个下标加
		arrayList.add(0, "rrr");
		System.out.println("index0=" + arrayList.get(0));
	}
}
