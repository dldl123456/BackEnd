package com.zhizuobiao.class1;

import java.util.ArrayList;

/**
 * 集合-ArrayList
 */
public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		User user = new User();

		// 保存
		list.add(user);
		list.add("zhizuobiao");

		// 获取
		Object obj0 = list.get(0);
		User u = (User) obj0;
		System.out.println(obj0);
		System.out.println(u.getId());

		Object obj1 = list.get(1);
		System.out.println(obj1);

		// 把object强转成User，然后调用user类中的方法
		// 1 类型转换
		// 2 方法调用
		((User) list.get(0)).getName();
		// 含义如下：
		// 1、从list集合中获取第0个元素：类型【Object】--> 顶级父类
		// 2、将返回值强转成User类型 Object --> User
		// 3、调用User类中的getName()方法

		// 删除
		Object removeEle = list.remove(0);
		System.out.println("删除的元素：" + removeEle);
		
		System.out.println("删除后的数组，0的元素："+list.get(0));
		
		// 清空集合
		list.clear();
		// 集合大小
		list.size();
		// 判断集合是否为空
		list.isEmpty();

		
	}
}
