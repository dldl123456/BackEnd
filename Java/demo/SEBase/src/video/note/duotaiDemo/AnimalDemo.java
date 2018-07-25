/*
 *  多态的存在提高了程序的扩展性和后期可维护性（低耦合）
 */

package video.note.duotaiDemo;

public class AnimalDemo {
	public static void main(String[] args) {
		//父类的引用变量可以引用其子类的的对象
		Animal anim1 = new Dog("旺财");  //向上转型
		anim1.eat();
		//向上转型首先是安全的，但可能会导致子类方法的丢失
		//anim1.sleep();方法丢失
		//父类的引用变量只能调用父类中有的方法，或子类重写父类的方法
		
		Animal anim2 = new Cat("招财猫");
		anim2.eat();
		
		//向下转型是不安全的
		//把父类型（动物）强制类型转换成子类型（猫）
		// Cat cat = (Cat)anim1;  //报错转换异常
		//判断anim1是不是指向猫（判断狗这个对象是不是猫这个类的实例）
		/*if(anim1 instanceof Cat){
			Cat cat = (Cat)anim1;
		}*/
		
		//判断狗这个对象是不是猫这个类的实例
		if(anim2 instanceof Cat){
			Cat cat = (Cat)anim2;
			cat.sleep();
		}
	}
}

//父类
class Animal{
	@SuppressWarnings("unused")
	private String name;
	public Animal(String name){
		this.name = name;
	}
	
	//这是一个通用的方法，通用的方法实现没有太大的意义，
	//只是告诉其子类去实现它
	public void eat(){
		
	}
}

//子类
class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
	//对父类的方法进行重写
	public void eat(){
		System.out.println("啃骨头");
	}
	
	//子类自己的方法
	public void sleep(){
		System.out.println("睡觉");
	}
}

//子类
class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
	//对父类的方法进行重写
	public void eat(){
		System.out.println("吃鱼肉");
	}
	
	//子类自己的方法
	public void sleep(){
		System.out.println("睡觉");
	}
}