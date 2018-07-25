/*
 *  士兵作战计划(多态，模板，重写，重载)
 *  使用抽象类
 */

package video.note.soldierDemo;

public class SoldierDemo {
	//测试类
	public static void main(String[] args) {
		Officer officer = new Officer("我");  //产生一个军官
		officer.callToAttack();  //让所有的士兵攻击
		System.out.println("**************");
		officer.callToAttack(officer.getSoldiers()[0]);  //让数组里面第一个人进行攻击
		System.out.println("**************");
		officer.callToAttack(officer);
	}
}

//士兵（父类，抽象类，模板）
//一旦这个类里面有一个方法是抽象方法，则这个类是抽象类
abstract class Soldier{
	//定义变量
	private String name;
	//构造方法初始化变量
	public Soldier(String name){
		this.name = name;
	}
	//get方法获取(返回)其名字
	public String getName(){
		return name;
	}
	
	//start
	public void start(){
		System.out.println("准备攻击");
	}
	
	//attack----声明抽象方法
	public abstract void attack();
	
	//end
	public void end(){
		System.out.println("攻击完成");
	}
	
	//一个方法（行动）
	public void action(){
		start();  //开始
		attack();  //攻击（延迟到子类实现，所以需要声明抽象方法）
		end();  //结束
	}
}

//子类（陆军）
//一个类只能继承一个父类
class LandSolider extends Soldier{
	//构造方法
	public LandSolider(String name){
		super(name);  //调用父类带一个参数的构造方法
	}
	
	//重写父类被声明的抽象方法 attack
	//实现抽象类中的抽象方法
	public void attack(){
		System.out.println(getName() + "使用步枪射击");
	}
}

//子类（海军）
class OceanSolider extends Soldier{
	public OceanSolider(String name){
		super(name);
	}
	
	//攻击
	public void attack(){
		System.out.println(getName() + "使用鱼雷射击");
	}
}

//子类（军官）
//军官持有若干士兵
class Officer extends Soldier{
	private Soldier[] soldiers = new Soldier[2];  //军官持有2个士兵
	public Officer(String name){
		super(name);
		//父类的引用变量可以引用子类对象
		soldiers[0] = new LandSolider("张三");
		soldiers[1] = new OceanSolider("张三");
	}
	
	//士兵都在数组里面，需要返回
	public Soldier[] getSoldiers(){
		return soldiers;
	}

//方法重载：方法名相同，参数不同（个数）
	//军官有自己特有的方法，指挥方法
	//让所持有的所有士兵一起发动攻击，包括自己
	public void callToAttack(){
		for(int i=0; i<soldiers.length; i++){
			soldiers[i].action();  //每个士兵调用其自身的行动方法
		}
		//自己也参与攻击
		this.action();
	}
	
	//让一个士兵去攻击
	public void callToAttack(Soldier soldier){
		soldier.action();
	}
	
	//攻击
	public void attack(){
		System.out.println(getName() + "使用手枪射击");
	}
}