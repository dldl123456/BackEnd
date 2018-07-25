package video.note.decorator;

public class Test {
	public static void main(String[] args) {
		ConcreteComponent Ccmponent = new ConcreteComponent();
		
		Ccmponent.doThingA();  //基本功能
		
		//用装饰类对组件类进行包装
		ConcreteDecorator1 decorator1 = new ConcreteDecorator1(Ccmponent);
		decorator1.doThingA();  //2个功能
		
		ConcreteDecorator2 decorator2 = new ConcreteDecorator2(decorator1);
		decorator2.doThingA();
	}
}
