/*
 *  电器类都可以充电
 */

package test2;

public class Elec extends Goods implements IChargeable {
	//构造方法
	public Elec(String name){
		super(name);  //调用父类带一个参数的构造方法
	}
	
	//重写（实现）接口充电方法
	public void chargeable(){
		System.out.println(getName() + "可以充电");
	}
}
