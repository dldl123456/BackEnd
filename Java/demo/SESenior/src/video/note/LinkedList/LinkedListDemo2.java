package video.note.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo2 {
	public static void main(String[] args) {
		//栈
		MyStack<String> myStack = new MyStack<>();
		
		//压栈
		myStack.push("zhangsan");
		myStack.push("lisi");
		myStack.push("wangwu");
		myStack.push("zhaoliu");
		
		//出栈
		myStack.pop();
		myStack.pop();
		
		//遍历
		Iterator<String> it1 = myStack.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		//队列
		MyQueue<Integer> myQueue = new MyQueue<>();
		
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		
		myQueue.pop();
		myQueue.pop();
		
		Iterator<Integer> it2 = myQueue.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}

//栈(泛型)
class MyStack<T> {
	//用LinkedList容器
	private LinkedList<T> data = null;
	
	//构造方法
	public MyStack(){
		//产生一个容器对象
		data = new LinkedList<T>();
	}
	
	//push方法(压栈的方法)
	public void push(T obj){
		data.addFirst(obj);
	}
	
	//出栈的方法
	public T pop(){
		return data.removeFirst();
	}
	
	//用迭代器遍历
	public Iterator<T> iterator(){
		return data.iterator();
	}
}

//队列
class MyQueue<T>{
	private LinkedList<T> data = null;
	public MyQueue(){
		data = new LinkedList<T>();
	}
	
	public void push(T obj){
		data.addFirst(obj);
	}
	
	public T pop(){
		return data.removeLast();
	}
	
	public Iterator<T> iterator(){
		return data.iterator();
	}
}