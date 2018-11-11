/*
 * set注入 
 */

package bean;

public class Hello {
	
	private String name;

	public void setName(String name) {
		System.out.println("setter 注入");
		this.name = name;
	}

	public Hello() {
		System.out.println("constructor");
	}

	public void sayHello(){
		System.out.println(this.name + "~~say hello");
	}
}
