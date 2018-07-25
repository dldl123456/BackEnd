package video.note.decorator;

/**
 * BufferedInputStream
 * @author hjkjkj
 *
 */
public class ConcreteDecorator2 extends Decorator {
	public ConcreteDecorator2(Component component) {
		super(component);
	}
	
	//重写接口方法
	@Override
	public void doThingA() {
		super.doThingA();  //调用摆包装类的方法
		doThingC();
	}
	
	//扩展
	private void doThingC(){
		System.out.println("do C thing");
	}
}
