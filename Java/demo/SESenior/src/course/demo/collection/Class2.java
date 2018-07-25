package course.demo.collection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * Collection -- LinkedList
 *
 */

public class Class2 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedList linkedlist = new LinkedList();
		
		linkedlist.add(1);  //Collection接口的方法
		linkedlist.add("b");
		
		linkedlist.iterator();
		linkedlist.addFirst("first");
		
		//从堆栈处弹出第一个元素
		Object value = linkedlist.pop();
		
		System.out.println(linkedlist.getFirst());
		System.out.println(value);
		System.out.println(linkedlist.getLast());
		
		linkedlist.addAll(linkedlist);
		
		Iterator iterator = linkedlist.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		linkedlist.add(3, "add_3_value");
		System.out.println(linkedlist.get(3));
		//会下标越界
		
		//LinkedList地址可以是非连续的空间地址（数组是连续的）
		//LinkedList查询，需要遍历链表中的元素，找到指定值并返回，效率低
		//LinkedList
		/*linkedlist.add(3);
		System.out.println(linkedlist.get(3));*/
	}
}
