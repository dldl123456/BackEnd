package test1;

//子类（电灯）
public class Light extends Electrical {
	//子类构造函数获取父类构造函数的方法
	public Light(String name) {
		super(name);  //super是父类对象
	}

	//重写父类打开电器方法（打开电灯）
	public void turnOn(){
		System.out.println(this.getName() + "打开电灯");
	}
	
	//重写父类关闭电器方法（关闭电灯）
	public void turnOff(){
		System.out.println(this.getName() + "关闭电灯");
	}
	
	//定义私有的方法（电灯故障）
	public void trouble(){
		System.out.println("Dr." + this.getName() + ", the light is brokened，please connect manager soon.");
	}
}
