/*
 *  创建一个动物类，具有属性name,age,colour，行为有吃 打印吃东西
 *  创建一个狗类，继承于动物，并且有自己的行为玩耍，玩飞盘
 *  创建一个小狗类，继承于狗类，吃东西的行为中吃的是牛奶
 *  创建一个大狗类，继承于狗类，吃的东西是肉骨头
 *  要求打印出小狗和大狗的所有属性，属性格式为：我是xxx，我的颜色是xxx，我的年龄是xxx
 *  调用行为，打印出效果 xxx在玩飞盘，xxx在吃xxx
 */

package test1;

public class Animal {
	//定义Animal类私有变量
	private String name;  //名字
	private String colour;  //颜色
	private int age;  //年龄
	
	//用get,set方法给Animal类私有属性开放接口
	//name属性
	public String getName() {  //获取name
		return name;
	}
	public void setName(String name) {  //定义name
		this.name = name;
	}
	//colour属性
	public String getColour() {  //获取colour
		return colour;
	}
	public void setColour(String colour) {  //定义colour
		this.colour = colour;
	}
	//age属性
	public int getAge() {  //获取age
		return age;
	}
	public void setAge(int age) {  //定义age
		if(age>0){
			this.age = age;
		}
	}
	
	//构造函数（初始化变量）
	public Animal(String name, String colour, int age) {
		this.name = name;
		this.colour = colour;
		this.age = age;
	}
	
	//方法（行为）：吃食物
	public void eat(String food) {
		System.out.println("吃" + food);
	}
	
	//输出方法
	public String toString() {
		return "我是" + name + "，我的颜色是" + colour + "，我的年龄是" + age;
	}
	
	//主函数（程序入口）
	public static void main(String[] args) {
		//打印动物吃东西
		Animal anim = new Animal("小黄", "紫色", 18);  //实例化Animal类创建anim对象
		System.out.print(anim.name);  //输出这个anim对象的名字
		anim.eat("鸡蛋");  //调用anim对象吃食物的方法
		System.out.println("============");  //格式换行
		
		//小狗
		SmallDog smd = new SmallDog("小狗", "白色", 2);  //实例化SmallDog类创建smd对象
		System.out.println(smd.toString());  //子类对象调用父类对象的toString方法
		smd.play();  //调用子类对象的play方法
		smd.eat();  //调用子类对象的eat方法
		System.out.println("============");  //格式换行
		
		//大狗
		BigDog bid = new BigDog("大狗", "黑色", 15);  //实例化BigDog类创建bid对象
		System.out.println(bid.toString());  //子类对象调用父类对象的toString方法
		bid.play();  //调用子类对象的play方法
		bid.eat();  //调用子类对象的eat方法
	}
}
