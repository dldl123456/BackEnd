/*
 *   在Arraylist中存放以下数据：
 *   “张三”、“李四”、“王五”、“张三”、“aaa”、“aaa”、“bbb”
 *   要求：去除ArrayList中的重复元素。
 */

package test1;

import java.util.ArrayList;
import java.util.List;

public class ArraylistDemo {
	public static void main(String[] args) {
		//实例化List容器获得其对象
		List<String> list = new ArrayList<>();
		
		//往该容器中添加数据
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("张三");
		list.add("aaa");
		list.add("aaa");
		list.add("bbb");
		
		//实例化一个新容器，用来存放去重后的集合
		List<String> newList = new  ArrayList<String>(); 
		
		//遍历,并判断
		for(String name:list){
			//遍历并判断，容器中是否包含前面遍历出的值，如果没有，则添加，否则不添加
			if(!newList.contains(name)){
				//往新容器中添加判断后的数据
                newList.add(name);
            }
		}
		
		//输出
		System.out.println("去重前的集合：" + list);  //初始容器
		System.out.println("去重后的集合：" + newList);  //新容器
	}
}
