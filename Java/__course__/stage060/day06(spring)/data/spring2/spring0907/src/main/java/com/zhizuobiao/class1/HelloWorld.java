package com.zhizuobiao.class1;

public class HelloWorld {

	public HelloWorld() {
		System.out.println("HelloWorld���췽��");
	}

	// pageContext/request/session/application

	// ���Ʒ�ת IOC
	// ����ע�� DI

	// UserDao userdao = new UserDaoImpl();
	// UserDao userdao ;

	public void sayHello() {
		System.out.println("hello spring!!!");
	}

	public void myInit() {
		System.out.println("��ʼ������");
	}

	public void myDestory() {
		System.out.println("���ٷ���");
	}

}
