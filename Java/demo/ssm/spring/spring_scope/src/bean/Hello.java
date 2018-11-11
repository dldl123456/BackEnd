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

	public void sayHello(){
		System.out.println(this.name + "~~say hello");
	}
}
