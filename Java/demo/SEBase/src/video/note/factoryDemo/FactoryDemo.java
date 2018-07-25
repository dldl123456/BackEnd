/*
 *  简单工厂模式：违反开闭规则
 */

package video.note.factoryDemo;

public class FactoryDemo {
	//主方法，测试类
	public static void main(String[] args) {
		//用接口的引用变量来接收
		//意思是，只要实现这个接口的水果，我都可以接收
		IFruit fruit = Factory.getFruit("苹果");
		
		//判断该厂里是否有该水果
		if(fruit != null){
			System.out.println(fruit.get());  //多态，动态绑定
		}else{
			System.out.println("不存在");
		}
	}
}

//摘水果接口
interface IFruit{
	//定义抽象方法
	public String get();
}

//一个工厂类
class Factory{
	//返回接口的实现类
	//他的返回类型是接口(IFruit)的引用变量，所以return的接口的实现类都可以
	public static IFruit getFruit(String name){
		if(name.equals("苹果")){
			return new Apple();
		}else if(name.equals("橘子")){
			return new Orange();
		}else{
			return null;
		}
	}
}

//要使用接口的水果类（苹果）
class Apple implements IFruit{
	//重写接口类的方法
	public String get(){
		return "采摘苹果";
	}
}

//要使用接口的水果类（橘子）
class Orange implements IFruit{
	//重写接口类的方法
	public String get(){
		return "采摘橘子";
	}
}