package test2;

//���ࣨ��ɫ��ӡ����
public class ColorPrinter extends Printer {
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "��ɫ��ӡ" + content);
	}
}
