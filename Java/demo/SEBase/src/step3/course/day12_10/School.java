package step3.course.day12_10;

public class School {
	private Printer prin;
	
	//构造方法中把打印机传进来
	public School(Printer prin){  
		this.prin = prin;
	}
	
	//打印的方法
	public void print(){
		//用打印机调用打印的方法
		prin.print();  //父类(父类引用|指向子类对象)
	}
}
