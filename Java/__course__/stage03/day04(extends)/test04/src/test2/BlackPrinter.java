package test2;

//子类（黑白打印机）
public class BlackPrinter extends Printer {
	public BlackPrinter(String brand) {
		super(brand);
	}

	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "黑白打印" + content);
	}
}
