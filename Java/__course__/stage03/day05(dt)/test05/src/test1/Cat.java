package test1;

//Cat类调用接口
public class Cat implements CanCry {
	//对接口中的抽象方法进行具体实现
	public void cry() {
		System.out.println("猫，叫声是喵喵喵");
    }
}
