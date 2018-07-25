package video.note.extendsDemo;

public class AandB {
	public static void main(String[] args) {
		B b = new B();  //产生b的对象的时候也调用了b的构造方法
		//产生子类对象的时候也调用了父类的构造方法
		b.showB();  //调用B的showB方法
	}
}

class A{
	public A(){
		System.out.println("A的构造方法");
	}
	
	public void showA(){
		System.out.println("A");
	}
	
	public void showB(){
		System.out.println("我是showA方法里的showB");
	}
}

class B extends A{
	public B(){
		//默认编译
		super();  //调用父类无参数的构造方法，可以省略
		System.out.println("B的构造方法");
	}
	
	public void showB(){
		System.out.println("B");
		//子类方法里调用父类方法(子类可以调用父类非私有的方法)
		showA();  //等价于super.showA();
		//当有同名方法的时候不能省略super
		super.showB();  //调用父类showB方法
	}
}