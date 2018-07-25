package test2;

public class School {
	private Printer p = null;  //安装打印机
	
	//安装打印机
	//拿父类的引用变量作为参数，好处就是可以接受任何其子类的对象
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	//打印的方法
	public void print(String content){
		//交给中心所安装的彩色打印机来打印
		p.print(content);
	}
}
