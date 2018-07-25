package video.note.abstractDemo2;

public class Demo2 {
	//测试类
	public static void main(String[] args) {
		Son son = new Son();
		son.show();
		son.show2();
	}
}

//抽象类
abstract class Parent{
	public abstract void show();  //抽象方法
}

//接口
interface IShow{
	public abstract void show();  //抽象方法
}

/*class Son extends Parent implements IShow{
	//重写
	public void show() {
		
	}
}*/

//通过内部类实现重写接口和内部类里的抽象方法
class Son extends Parent{
	public void show(){
		System.out.println("抽象类中的show方法");
	}
	
	//创建内部类，用内部类来实现接口
	private class Inner2 implements IShow{
		public void show() {
			System.out.println("接口中的show方法");
		}
	}
	
	public void show2(){
		//构建一个内部类的对象
		new Inner2().show();
	}
}
