package test1;

//子类（电视）
public class TV extends Electrical {
	//子类构造函数获取父类构造函数的方法
	public TV(String name){
		super(name);  //super()是父类对象
	}

	//重写父类的打开电器方法(电视)
	public void turnOn(){
		System.out.println(this.getName() + "打开电视");
	}
	
	//重写父类的关闭电器方法(电视)
	public void turnOff(){
		System.out.println(this.getName() + "关闭电视");
	}
	
	//定义私有方法（电视机故障）
	public void trouble(){
		System.out.println("Dr." + this.getName() + ", the TV is brokened，please connect manager soon.");
	}
}
