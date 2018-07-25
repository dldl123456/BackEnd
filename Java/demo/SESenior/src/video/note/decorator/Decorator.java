package video.note.decorator;

/**
 * 装饰类--FilterInputStream
 * @author hjkjkj
 *
 */
public class Decorator implements Component {
	//持有Component对象的实例，持有Component类型的引用变量
	private Component component = null;
	
	public Decorator(Component component){
		this.component = component;
	}
	
	@Override
	public void doThingA() {
		//调用被装饰对象的方法
		component.doThingA();
	}
}
