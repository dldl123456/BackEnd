/*
 *  匿名内部类
 */

package video.note.anomymousInnerClass;

public class AnomymousInnerClass {
	public static void main(String[] args) {
		Person p = new Person();
		Person1 p1 = new Person1();
		
		p.feed(new Animal(){  //new出来的是一个子类，一个类去继承Animal
			//实现(重写)抽象类里面的抽象方法
			//匿名内部类构造出了一个对象
			public void eat(){
				System.out.println("啃饭");
			}
		});
		
		p.feed(new Animal(){
			public void eat(){
				System.out.println("吃肉");
			}
		});
		
		//拿匿名内部类构建出的对象赋值给dog
		//dog指向了你这个匿名内部类在内存中所构造出的对象
		//父类引用变量引用子类对象，只能调用父类里面有的方法
		Animal dog = new Animal(){
			public void eat(){
				System.out.println("吃狗肉");
			}
		};
		p.feed(dog);  //最后把dog传过来
		p.feed(dog);
		
		//调用匿名内部类中的私有属性和方法
		new Animal(){
			private String name = "小鸡";
			
			/*static {
				
			}*/  //匿名内部类不能用静态块
			
			//代码块，比构造方法先执行，用来对属性和方法进行初始化
			{
				name = "jj";
			}
			
			public void eat(){
				System.out.println("吃狗肉");
			}
			
			public void show(){
				System.out.println("自己的方法" + name);
			}
		}.show();
		
		//interface
		p1.feed1(new IAnimal(){
			public void eat1(){
				System.out.println("I吃肉");
			}
		});
		
		//new出来的是接口里面的实现类对象
		//调用匿名内部类中的私有属性和方法
		new IAnimal(){
			private String name = "小鸡";
			
			/*static {
				
			}*/  //匿名内部类不能用静态块
			
			//代码块，比构造方法先执行，用来对属性和方法进行初始化
			{
				name = "jj";
			}
			
			public void eat1(){
				System.out.println("I吃狗肉");
			}
			
			public void show(){
				System.out.println("I自己的方法" + name);
			}
		}.show();
	}
}

//抽象类
abstract class Animal{
	//声明抽象方法
	public abstract void eat();
}

//接口
interface IAnimal{
	//声明抽象方法
	public abstract void eat1();
}

//喂食
class Person{
	public void feed(Animal animal){  //传一个实例化的对象
		//animal指向了你构建出来的匿名内部类的对象
		animal.eat();
	}
}

//喂食
class Person1{
	public void feed1(IAnimal animal){
		animal.eat1();
	}
}

