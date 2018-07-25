package video.note.interfaceDemo;

public class InterfaceDemo {
	public static void main(String[] args) {
		System.out.println(IAbility.number);
		System.out.println(IAbility.number1);
		
		Person p = new Person();
		Child chd = new Child();
		Dog dg = new Dog();
		p.feed(chd);
		p.feed(dg);
	}
}

class Person{
	//接口的引用变量可以引用其实现类的对象
	//接口实现了多态
	public void feed(IAbility abilty){
		abilty.eat();  //动态绑定实现了多态
	}
}

//声明一个接口
//接口中只能放公有的静态常量和抽象方法
interface IAbility{
	//公有静态常量
	public static final int number = 1;
	int number1 = 2;  //默认公有静态常量（和上面等同）
	
	//抽象方法
	/*public abstract*/ void show();  //默认public abstract
	
	void eat();
}

//让Clild类 具备 IAbility 的能力
class Child implements IAbility/*多个接口可以用逗号隔开*/{
	//表示重写了接口里的东西
	public void eat(){
		System.out.println("吃饭");
	}
	
	public void show() {
		
	}
}

//
class Dog implements IAbility{
	public void eat(){
		System.out.println("啃骨头");
	}

	public void show() {
		
	}
}

/*class Person{
//方法重载
	//喂小孩
	public void feed(Child chd){
		chd.eat();
	}
	
	//喂狗
	public void feed(Dog dg){
		dg.eat();
	}
}*/

/*class Child{
	public void eat(){
		System.out.println("吃饭");
	}
}

class Dog{
	public void eat(){
		System.out.println("啃骨头");
	}
}*/