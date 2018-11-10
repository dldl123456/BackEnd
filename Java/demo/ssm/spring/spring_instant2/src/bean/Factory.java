/*
 * 	静态工厂实例化
 *  工厂类
 *  用来实例化对象
 */

package bean;

public class Factory {
	//实例化hello
	public static Hello getHelloIntance(){
		System.out.println("静态方法");
		return new Hello();
	}
}
