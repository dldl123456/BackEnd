/*
 * ��̬�õ���֪ʶ�㣺
 * ��������ñ������������������
 * ����������ñ������������������
 * �ӿ�������ñ�����������ʵ�������
 * ��д
 */

package video.note.PrinterDemo;

public class PrinterDemo {
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("����");
		BlackPrinter bp = new BlackPrinter("����");
		
		School school = new School();
		Teacher tcr = new Teacher("����" , 30);
		school.setPrinter(cp);
		
		school.print(tcr);
		school.print(school);
		
		
		School school1 = new School();
		Teacher tcr1 = new Teacher("����" , 30);
		school1.setPrinter(bp);
		
		school1.print(tcr1);
		school1.print(school1);
		
		/*School school1 = new School();
		school1.setPrinter(bp);
		school1.print("hello,oracle");
		
		School school2 = new School();
		school2.setPrinter(cp);
		school2.print("hello,java");*/
		
	}
}

//�����ϸ��Ϣ�ӿ�
interface IInfo{
	//�������󷽷�(Ҫ����ӡ�ľ�������)
	/*public abstract*/ String detail();
}

//���ࣨ��ӡ����
//������
abstract class Printer{
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
	/*public void print(String content){  //��ӡ����
		System.out.println("���Ǹ������ӡ�ķ���");
	}*/
	//���󷽷�
	public abstract void print(String content);
}

//���ࣨѧУ��
//���ýӿ�
class School implements IInfo{
	private Printer p = null;  //��װ��ӡ��
	
	//��װ��ӡ��
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	/*//��ӡ�ķ���
	public void print(String content){
		//������������װ�Ĳ�ɫ��ӡ������ӡ
		p.print(content);
	}*/
	//��̬��������Ƶ�ʱ��������Ҫ�ýӿڻ�����࣬ʹ�����кܺõ���չ�ԺͿ�ά����
	public void print(IInfo info){
		p.print(info.detail());
	}
	
	public String detail(){
		return "hello,hello";
	}
}

//���ࣨ��ɫ��ӡ����
class ColorPrinter extends Printer{
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "��ɫ��ӡ��" + content);
	}
}

//���ࣨ�ڰ״�ӡ����
class BlackPrinter extends Printer{
	public BlackPrinter(String brand) {
		super(brand);
	}
	
	//�Ը��෽��������д
	public void print(String content){
		System.out.println(this.getBrand() + "�ڰ״�ӡ��" + content);
	}
}

//��Ա��
class Teacher implements IInfo{
	private String name;
	private int age;
	
	public Teacher(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//��д�ӿ���ķ���
	public String detail(){
		return "��ã��ҵ����ֽУ�" + name + ",�ҵ�������" + age;
	}
}

