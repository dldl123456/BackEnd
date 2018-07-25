/*
 *   张三可以开关家里的任何电器，比如电灯、电视、电扇等。使用继承和多态来实现开关电器的方法。
 */

package test1;

//父类，电器
public class Electrical {
	//定义私有变量
	private String name;  //使用者的名字
	
	//使用get/set方法为私有变量提供接口
	//name
	public String getName() {  //设置name属性
		return name;
	}
	public void setName(String name) {  //获取name属性
		this.name = name;
	}

	//构造函数初始化变量
	public Electrical(String name){
		this.name = name;
	}
	
	//定义电器开启方法
	public void turnOn(){
		System.out.println("the methods of turn on");
	}
	
	//定义电器关闭方法
	public void turnOff(){
		System.out.println("the methods of turn off");
	}
	
	//测试类
	public static void main(String[] args) {
		//父类调用子类创建对象（电灯）
		//向上转型,会导致子类方法的丢失
		Electrical ectl1 = new Light("张三");  //父类的引用变量可以引用其子类的的对象(父类引用子类Light类的对象实例化ectl1对象)
		ectl1.turnOn();  //子类（Light）的对象调用重写的开启电器方法
		ectl1.turnOff();  //子类（Light）的对象调用重写的开启电器方法
		
		//子类调用私有方法(向上转型)
		//判断电灯这个对象是不是电器这个类的实例
		if(ectl1 instanceof Light){
			Light lgt = (Light)ectl1;  //把父类型（电器）强制类型转换成子类型（电灯）
			lgt.trouble();  //调用子类的trouble方法
		}
		
		System.out.println("====================");  //格式换行
		
		
		//电视
		Electrical ectl2 = new TV("李四");  //引用TV类，实例化Electrical类，创建ectl2（TV）对象
		ectl2.turnOn();  //ectl2对象调用其重写的开启电器方法
		ectl2.turnOff();  //ectl2对象调用其重写的关闭电器的方法
		
		//调用该对象所属子类的私有方法
		if(ectl2 instanceof TV){  //判断该对象是否是TV类的实例
			TV tv = (TV)ectl2;  //将TV类对象强转成ectl2对象
			tv.trouble();  //调用TV类私有方法
		}
		
		System.out.println("====================");  //格式换行
		
		
		//风扇
		Electrical ectl3 = new Fan("张三");  //实例化Electrical创建ectl3对象
		ectl3.turnOn();  //ectl3对象调用该子类的打开电器方法
		ectl3.turnOff();  //ectl3对象调用该子类关闭电器的方法
	}
}
