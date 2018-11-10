/*
 * 	实例化工厂方法
 *  工厂类
 *  用来实例化对象
 *  先实例化自己，再实例化引用
 */

package bean;

public class Factory {
	
	private static Hello hello = new Hello();
	
	//实例化hello
	public Hello getHelloIntance(){
		System.out.println("实例方法");
		return hello;
	}
}
