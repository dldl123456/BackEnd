package test;

import bean.Hello;

public class TestBean1 {
	public static void main(String[] args) {
		//这个实例化对象是由程序员硬编码来实例化的
		Hello hw = new Hello();
		hw.sayHello();
	}
}
