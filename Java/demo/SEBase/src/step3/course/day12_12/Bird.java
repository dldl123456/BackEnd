package step3.course.day12_12;

//抽象类
//没有抽象方法也可以是抽象类，抽象类不能被实例化
public abstract class Bird {
	public Bird(){
		
	}
	
	public void test(){
		System.out.println("...");  //可以包含具体实现的方法
	}
	
	//一个空方法
	public void show(){
		
	}
	
	//抽象方法
	public abstract void method();

}
