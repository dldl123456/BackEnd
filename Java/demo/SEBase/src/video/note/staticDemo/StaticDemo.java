package video.note.staticDemo;

public class StaticDemo {
	public static void main(String[] args) {
		//每个对象都有一份自己独立的属性
		
		//acc1
		Account acc1 = new Account();  //实例化一个acc1对象
		//调用方法
		acc1.num3 ++;  //public变量可以直接调用
		Account.num4 ++;  //一般不用acc1.num4
		acc1.showNum1();
		acc1.showNum2();
		acc1.showNum3();
		acc1.showNum4();
		
		//acc2
		Account acc2 = new Account();  //实例化一个acc2对象
		//调用方法
		acc2.showNum1();
		acc2.showNum2();
		acc1.showNum3();
		acc1.showNum4();
		
		//调用静态方法
		Account.showTxt();  //调用静态方法，类名.方法名
		
		//acc3
		//构造方法(只要构造过对象，他每次都会执行)
		Account acc3 = new Account();  //实例化一个acc3对象
		acc3.showNum1();
	}
}

class Account{
	//定义私有变量
	private int num1 = 1;
	private int num2 = 2;
	//定义公共变量
	public int num3 = 3;
	//定义静态变量 -- 静态变量(类变量)，它不属于任何一个对象，被多个对象共享
	public static int num4 = 4;
	
	//构造方法(只要构造过对象，他每次都会执行)
	public Account(){
		System.out.println("构造方法");
	}
	
	//static语句块
	//类被加载的时候就会执行，只会执行一次，用来对静态的变量赋值
	//只能对静态的变量赋值
	//优先于构造方法的执行
	//不能全用static，破坏了面向对象的特点，所占的时间比较长
	//一个类里面没有任何属性，只有方法，这些方法专门为其他类服务的时候用（Arrays类）
	static{
		System.out.println("static");
		num4 = 100;
	}
	
	//访问num1
	public void showNum1(){
		System.out.println("num1 = " + num1);
	}
	
	//访问num2
	public void showNum2(){
		System.out.println("num2 = " + num2);
	}
	
	//访问num3
	//非静态方法访问静态内容和非静态的属性和方法
	//静态的只能访问静态的，非静态的都可以访问
	public void showNum3(){
		System.out.println("非静态方法访问静态变量(num4)：" + num4);
		System.out.println("num3 = " + num3 + "(public)");
	}
	
	//访问num4
	public void showNum4(){
		System.out.println("num4 = " + num4 + "(static(共享))");
	}
	
	//静态方法（静态方法必须加static）
	//静态方法中不能访问非静态的变量（属性）
	//属性是属于对象的，而静态的东西在调用的时候对象还没有产生
	//静态方法中不能有this，this指向当前对象引用，因为还没有产生对象，所以不能使用
	public static void showTxt(){
		System.out.println("num4 = " + num4 + "(static(静态方法中能访问外部静态的东西，不能访问外部非静态的东西))");
		System.out.println("这是静态方法");
	}
}

