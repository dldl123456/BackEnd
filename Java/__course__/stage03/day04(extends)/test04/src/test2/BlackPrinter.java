package test2;

//���ࣨ�ڰ״�ӡ����
public class BlackPrinter extends Printer {
	public BlackPrinter(String brand) {
		super(brand);
	}

	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "�ڰ״�ӡ" + content);
	}
}
