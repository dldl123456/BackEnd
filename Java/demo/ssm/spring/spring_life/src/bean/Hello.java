package bean;

public class Hello {
	
	private String name;

	public Hello() {
		System.out.println("constructor");
	}
	
	public Hello(String name) {
		super();
		this.name = name;
	}
	
	//初始化方法
	public void init(){
		System.out.println("init，初始化方法....");
	}
	
	//销毁方法
	public void destroy(){
		System.out.println("destroy，销毁方法....");
	}


	public void sayHello(){
		System.out.println(this.name + "~~say hello");
	}
}
