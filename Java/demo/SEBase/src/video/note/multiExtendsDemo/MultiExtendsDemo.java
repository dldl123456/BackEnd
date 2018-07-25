package video.note.multiExtendsDemo;

public class MultiExtendsDemo {
	//测试类
	public static void main(String[] args) {
		C c = new C();  //先产生外部类对象
		c.showA();
		c.showB();
	}
}

class A{
	public void showA(){
		System.out.println("A");
	}
}

class B{
	public void showB(){
		System.out.println("B");
	}
}

//用内部类实现多继承
class C {
	//内部类A1继承A
	private class A1 extends A{
		public void showA(){
			super.showA();  //调用父类里面的showA方法
		}
	}
	
//通过他内部类对象来分别调用他各自内部类对象里的show方法
//通过内部类来间接地实现多继承
	
	//内部类B1继承B
	private class B1 extends B{
		public void showB(){
			super.showB();  //调用父类里面的showB方法
		}
	}
	
	//返回A1对象
	public void showA(){
		new A1().showA();
	}

	//返回B1对象
	public void showB(){
		new B1().showB();
	}
}