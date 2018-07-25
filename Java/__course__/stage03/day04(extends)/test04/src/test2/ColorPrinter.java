package test2;

//子类（彩色打印机）
public class ColorPrinter extends Printer {
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "彩色打印" + content);
	}
}
