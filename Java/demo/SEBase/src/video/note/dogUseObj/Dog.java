/*
 *  学会使用对象
 */

package video.note.dogUseObj;

public class Dog {
	public String brand;  //品种
	public int age;
	
	//返回类型 方法名
	public String toString(){
		return "这是一条" + age + "岁的" + brand;
	}
	
	//程序操作的是对象，所以需要一个入口
	public static void main(String[] args) {
		Dog dog = new Dog();  //构造了一个Dog类型的对象
		dog.brand = "中华田园犬";
		dog.age = 3;
		System.out.println(dog.toString());
	}
}
