package video.note.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		//接口的引用变量引用实现类对象
		
		//LinkedList它内部封装的是双向链表数据结构
		//每个节点是一个node对象，node对象中封装的是你要添加的
		//元素，还有一个指向上一个node对象的应用指向下一个node对象的引用
		
		/*
		 *  不同的容器有不同的数据结构，不同的数据结果
		 *  操作起来性能是不一样的
		 *  
		 *  链表数据结构，做插入，删除的效率比较高，但
		 *  查询效率比较低
		 *  
		 *  数组结构他做查询的时候效率高，因为可以通过下标
		 *  直接找到元素，但插入和删除效率比较低，因为要做移位操作
		 */
		
		//创建一个容器
		LinkedList<String> sList = new LinkedList<>();
		
		//添加
		sList.add("张三");
		sList.add("李四");
		sList.add("王五");
		sList.add("jack");
		
		//在列表头部添加
		sList.addFirst("ccc");
		//在列表头部删除(第一个元素)
		sList.removeFirst();  //如果为空抛出异常
		
		//在列表末尾添加
		sList.addLast("ddd");
		//在列表尾部删除(最后一个元素)
		sList.removeLast();  //如果为空抛出异常
		
		//清空
		sList.clear();
		
		//sList.removeFirst();  //如果为空抛出异常  NoSuchElementException
		System.out.println(sList.pollFirst());  //如果为空返回null
		//last相同
		
		//遍历（迭代器对象）
		Iterator<String> it = sList.iterator();
		while(it.hasNext()){  //迭代器判断有没有下一个元素
			String name = it.next();
			System.out.println(name);
		}
		
		System.out.println("-**-**-**-");
		
		//遍历(增强for循环)只要实现了Iterator接口就能用增强for循环
		for(String name:sList){
			System.out.println(name);
		}
	}
}
