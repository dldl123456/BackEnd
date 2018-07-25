package video.note.duotaiDemo_2;

public class PrinterDemo {
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("����");
		BlackPrinter bp = new BlackPrinter("����");
		
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

//���ࣨ��ӡ����
class Printer{
	//˽�б���
	private String brand;  //Ʒ��
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	//���캯����ʼ��˽�б���
	public Printer(String brand){
		this.brand = brand;
	}
	
	//��ӡ�ķ���Ӧ���������������ʵ��
	public void print(String content){  //��ӡ����
		System.out.println("���Ǹ������ӡ�ķ���");
	}
}

//����ԭ�򣺶��޸��Ƿ�յģ�����չ�ǿ��ŵ�
//����Υ������ԭ�򣬿����ö�̬�������������ñ�����������������Ķ���
//Խ�ǳ���Ķ�������Խ�ȶ�
//���ࣨѧУ��
class School{
	/*private ColorPrinter cp = null;  //��ɫ��ӡ��
	private BlackPrinter bp = null;  //�ڰ״�ӡ��*/
	private Printer p = null;  //��װ��ӡ��
	
	/*//��װ��ɫ��ӡ��
	public void setColorPrinter(ColorPrinter cp){
		this.cp = cp;
	}
	
	//��װ�ڰ״�ӡ��
	public void setBlackPrinter(BlackPrinter bp){
		this.bp = bp;
	}*/
	
	//��װ��ӡ��
	//�ø�������ñ�����Ϊ�������ô����ǿ��Խ����κ�������Ķ���
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	//��ӡ�ķ���
	public void print(String content){
		//������������װ�Ĳ�ɫ��ӡ������ӡ
		/*//cp.print(content);
		bp.print(content);*/
		p.print(content);
	}
}

//���ࣨ��ɫ��ӡ����
class ColorPrinter extends Printer{
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "��ɫ��ӡ" + content);
	}
}

//���ࣨ�ڰ״�ӡ����
class BlackPrinter extends Printer{
	public BlackPrinter(String brand) {
		super(brand);
	}
	
	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "�ڰ״�ӡ" + content);
	}
}
