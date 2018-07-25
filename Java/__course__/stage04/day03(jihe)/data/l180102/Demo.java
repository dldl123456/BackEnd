package com.lesson.phase4.l0907.l180102;

import java.util.List;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
	
		//List<E>
		Test<Integer> tst  = new Test<Integer>();
		tst.setData(12345);
		System.out.println(tst.getData());
		
	}

}


class Test<T> { //∑∫–Õ¿‡
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

class Test2 {
	
	public <T> void show(T obj){}
	
}








