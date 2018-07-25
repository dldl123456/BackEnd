package step3.course.note.l171212;

public abstract class Bird {

	public Bird() {
		System.out.println("Bird........");
	}
	
	public void test(){
		System.out.println("test.........");
	}
	
	//不是抽象方法，是一个空方法
	public void show(){
		
	}
	
	//这才是抽象方法
	public abstract void method();
	
	
}
