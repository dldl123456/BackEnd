package com.zhizuobiao.class1;

public class HelloWorld {

	public HelloWorld() {
		System.out.println("HelloWorld构造方法");
	}

	// pageContext/request/session/application

	// 控制反转 IOC
	// 依赖注入 DI

	// UserDao userdao = new UserDaoImpl();
	// UserDao userdao ;

	public void sayHello() {
		System.out.println("hello spring!!!");
	}

	public void myInit() {
		System.out.println("初始化方法");
	}

	public void myDestory() {
		System.out.println("销毁方法");
	}

}
