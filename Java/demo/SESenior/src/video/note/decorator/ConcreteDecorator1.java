package video.note.decorator;

/**
 * BufferedInputStream
 * @author hjkjkj
 *
 */
public class ConcreteDecorator1 extends Decorator {
	public ConcreteDecorator1(Component component) {
		super(component);
	}
	
	//重写接口方法
	@Override
	public void doThingA() {
		super.doThingA();  //调用摆包装类的方法
		doThingB();
	}
	
	//扩展
	private void doThingB(){
		System.out.println("do B thing");
	}
}
