package test1;

public class BigDog extends Dog {
	//子类构造函数获取父类构造函数的方法
	public BigDog(String name, String colour, int age) {
		super(name, colour, age);  //super是父类对象
	}

	//方法（行为）:吃食物(肉骨头)
	public void eat() {
		System.out.println("吃肉骨头");
	}
}
