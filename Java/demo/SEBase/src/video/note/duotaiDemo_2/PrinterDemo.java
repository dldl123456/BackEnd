package video.note.duotaiDemo_2;

public class PrinterDemo {
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("惠普");
		BlackPrinter bp = new BlackPrinter("戴尔");
		
		/*School school1 = new School();
		school1.setColorPrinter(cp);
		school1.print("hello,java");*/
		
		/*School school2 = new School();
		school2.setBlackPrinter(bp);
		school2.print("hello,oracle");*/
		
		School school1 = new School();
		school1.setPrinter(bp);
		school1.print("hello,oracle");
		
		School school2 = new School();
		school2.setPrinter(cp);
		school2.print("hello,java");
		
	}
}

//父类（打印机）
class Printer{
	//私有变量
	private String brand;  //品牌
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	//构造函数初始化私有变量
	public Printer(String brand){
		this.brand = brand;
	}
	
	//打印的方法应该由子类来具体地实现
	public void print(String content){  //打印内容
		System.out.println("这是给父类打印的方法");
	}
}

//开闭原则：对修改是封闭的，对扩展是开放的
//不能违背开闭原则，可以用多态解决，父类的引用变量可以引用其子类的对象
//越是抽象的东西代表越稳定
//子类（学校）
class School{
	/*private ColorPrinter cp = null;  //彩色打印机
	private BlackPrinter bp = null;  //黑白打印机*/
	private Printer p = null;  //安装打印机
	
	/*//安装彩色打印机
	public void setColorPrinter(ColorPrinter cp){
		this.cp = cp;
	}
	
	//安装黑白打印机
	public void setBlackPrinter(BlackPrinter bp){
		this.bp = bp;
	}*/
	
	//安装打印机
	//拿父类的引用变量作为参数，好处就是可以接受任何其子类的对象
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	//打印的方法
	public void print(String content){
		//交给中心所安装的彩色打印机来打印
		/*//cp.print(content);
		bp.print(content);*/
		p.print(content);
	}
}

//子类（彩色打印机）
class ColorPrinter extends Printer{
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "彩色打印" + content);
	}
}

//子类（黑白打印机）
class BlackPrinter extends Printer{
	public BlackPrinter(String brand) {
		super(brand);
	}
	
	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "黑白打印" + content);
	}
}
