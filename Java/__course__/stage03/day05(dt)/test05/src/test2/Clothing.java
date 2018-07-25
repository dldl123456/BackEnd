/*
 *  服装类都可以穿戴
 */

package test2;

public class Clothing extends Goods implements IWearable {
	//构造方法
	public Clothing(String name) {
		super(name);  //调用父类带一个参数的构造方法
	}

	//重写（实现）接口穿戴方法
	public void wearable(){
		System.out.println(getName() + "可以穿戴");
	}
}
