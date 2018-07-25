package com.zhizuobiao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * collection -- arraylist 
 */
public class Class1 {

	public static void main(String[] args) {

		User user = new User();
		// ArrayList (数组结构集合)
		ArrayList arrayList = new ArrayList();
		// 字符串
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("a");
		// user对象
		arrayList.add(user); // User是类，user是类的实例（对象），Object是类，obj实例（对象）
		// boolean值
		arrayList.add(false);
		// float
		arrayList.add(3.1415926);
		// 往集合放入不同的类型数据，取出时都是object类型，也就是失去原有类型。{集合默认内部是object元素类型}
		// 想获取原有数据的类型，相当复杂！！！！（强制转换）

		// demo2(arrayList);
		// demo3(arrayList);
		demo5(arrayList);

	}

	/**
	 * ArrayList集合特点
	 * 
	 * @param arrayList
	 */
	public static void demo5(ArrayList arrayList) {

		System.out.println("index_0 = " + arrayList.get(0)); // a
		arrayList.remove(0);
		System.out.println("index_0 = " + arrayList.get(0)); // b
		arrayList.add(0, "0_new");
		System.out.println("index_0 = " + arrayList.get(0)); // 0_new
		// 数组存储结构图
		//  0,1,2,3,4,5,6
		// [a,b,c,a,user,false,3.1415926] --> remove(0);
		//  0,1,2,3,4,5
		// [b,c,a,user,false,3.1415926] --> 删除元素后，后续的内容，自动前移
		//  删除效率？ 集合数据越大，速度回变慢
		// 获取元素？ 使用数组的下标，一次就可以拿到，eg：3--user[3]
		// ArrayList 查询快，添加删除慢

	}

	/**
	 * 包装类
	 * 
	 * @param arrayList
	 */
	public static void demo4(ArrayList arrayList) {
		// 差装箱 自动完成
		// int -- Integer
		int x = 10;
		Integer y = 20;
		double d1 = 1;
		Double d2 = 2d;
		// 基本数据类型，对应的对象类
		Byte b;
		Short s;
		Long l;
		Float f;
		Boolean bl;
		Character ct;

		// 基本数据类型，转成对应的对象类型 --> 装箱
		Integer xObj = Integer.valueOf(x);
		// Double.valueOf(arg0)
		// Float.valueOf(arg0)
		// ...

		// 对象类型，转成基本数据类型 --> 拆箱
		int xValue = xObj.intValue();

		// 调用demo4_1
		demo4_1(10); // 自动拆装箱
	}

	public static void demo4_1(Integer value) {
	}

	/**
	 * foreach
	 * 
	 * @param arrayList
	 */

	public static void demo3(ArrayList arrayList) {
		for (Object obj : arrayList) {
			System.out.println(obj);
		}
	}

	/**
	 * 迭代器
	 * 
	 * @param arrayList
	 */
	public static void demo2(ArrayList arrayList) {

		// 迭代器
		Iterator iterator = arrayList.iterator();
		// System.out.println(iterator.next()); // a
		// System.out.println(iterator.next()); // b
		// System.out.println(iterator.next()); // c
		// System.out.println(iterator.next()); // a
		// System.out.println(iterator.next()); // user
		// System.out.println(iterator.next()); // java.util.NoSuchElementException

		// for循环，需要知道开始和结束
		// 迭代器 不适合
		// while，boolean值循环
		while (iterator.hasNext()) { // 如果集合中有元素，就返回true，没有元素就返回false
			System.out.println("有");
			// Object obj = iterator.next();
			// System.out.println("iterator = " + obj);
			iterator.next();
		}
	}

	/**
	 * 集合分类
	 * 
	 * @param arrayList
	 */
	public static void demo(ArrayList arrayList) {
		// java 基本数据类型 8种
		// byte short int long float double char boolean
		int[] arr = new int[10];

		// 集合存放的数据是对象

		Collection collection;
		// collection 的元素上进行迭代的迭代器。
		// set list
		// set -- 一个不包含重复元素的 collection
		// list -- 有序的 collection（也称为序列）,允许重复的元素

		// 数据结构
		// 堆
		// 栈
		// 队列
		// 数组
	}

	/**
	 * 集合基本操作
	 * 
	 * @param arrayList
	 */
	public static void demo1(ArrayList arrayList) {
		// 10 (x,x,x,x,x,x,x,x,x,x)
		// 10 (1,2,3,4,5,6,7,8,9,10)
		// 10 (1,2,3,4,5,6,7,8,9,10,x,x,x,x,x,x,x,x,x,x)
		for (int i = 0; i < 10000; i++) {
			// arrayList.add(i);
		}

		// 删除集合内，下标为0的元素
		// arrayList.remove(0);

		// 输出集合的大小
		System.out.println(arrayList.size());

		// 循环从0-N集合的大小
		for (int i = 0; i < arrayList.size(); i++) {

			// get(int index) 返回列表中指定位置的元素。
			// 获取集合中的元素
			Object value = arrayList.get(i);

			System.out.println(value);
		}

		// arrayList.clear();

		System.out.println(arrayList.size());

		// 包含
		boolean exist = arrayList.contains("c");

		System.out.println("exist = " + exist);
	}
}
