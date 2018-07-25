package test1;

public class Dog extends Animal {
	//子类构造函数获取父类构造函数的方法
	public Dog(String name, String colour, int age) {
		super(name, colour, age);  //super是父类对象
	}
	
	//方法（行为）:玩东西(飞盘)
	public void play(){
		System.out.println("玩飞盘");
	}
}
