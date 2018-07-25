package test1;

//子类(电扇)
public class Fan extends Electrical {
	//子类构造函数获取父类构造函数的方法
	public Fan(String name){
		super(name);  //super表示父类对象
	}
	
	//重写父类开启电器方法（电扇）
	public void turnOn(){
		System.out.println(this.getName() + "打开电扇");
	}
	
	//重写父类关闭电器的方法（电扇）
	public void turnOff(){
		System.out.println(this.getName() + "关闭电扇");
	}
}
