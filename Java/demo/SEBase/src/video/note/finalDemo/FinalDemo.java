package video.note.finalDemo;

public class FinalDemo {
	public static void main(String[] args) {
		A a = new A();
		a.showNum1();
		
		B b = new B();  //还继续输出是因为，子类会自动调用父类的无参构造方法
		b.showNum2();
		
	//final用在引用变量上，代表此引用变量只能引用
	//一开始所引用的对象，中途不能改变指向
		//a2类似一个指针，它指向的是new A()这个对象
		//a2保存的是new A()这个堆里面的内存地址
		//a2引用了new出来的A类型的对象
		//加了final表示a2只能指向这个new出来的A类型的对象
		final A a2 = new A();
		//a2 = new A(); 错误
		//a2本来指向new A()堆里面的内存地址，
		//而下面那个new A()在内存里又产生了一个对象
		//这样a2改变了方向，就出错了
		a2.num2 = 5;
		a2.showNum2();
	}
}

//父类
//常量类不能被继承
/*final*/ class A{
	public final int num1 = 1;  //加了final就是常量
	public int num2 = 2;
	
	public void showNum1(){
		//不能进行num1 ++;常量是不能被修改的
		System.out.println(num1);
	}
	
	//子类不能对父类中的常量方法进行改写（重写）
	public /*final*/ void showNum2(){  //加了final表示常量方法
		System.out.println(num2);
	}
}

//子类
class B extends A{
	public void showNum2(){  //常量方法不能被重写
		super.showNum1();
		super.showNum1();
		System.out.println(num2 + "!");
	}
}
