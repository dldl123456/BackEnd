/*
 *  ��������,�ͷ��������޹�
 */

package video.note.overloadDemo;

public class OverloadDemo {
	public static void main(String[] args) {
		//û���޲εĹ��췽��������Ҫд����
		Printer p1 = new Printer(1000);  //ʵ��������
		p1.print("hello");
		p1.print(123123);
		p1.print("cmcc", 132);
		
		Printer p2 = new Printer("����", 1000);  //ʵ��������
		p2.print("---");
		Printer p3 = new Printer(1000);  //ʵ��������
		p3.print("---");
		Printer p4 = new Printer("����");  //ʵ��������
		p4.print("---");
	}
}

class Printer{
	//����˽�б���
	private String brand = "����";
	private double price = 10086;
	
	//һ�������Ĺ��췽��
	public Printer(String brand){
		this.brand = brand;
		System.out.println(brand + "--" + price);
	}
	
	//һ�������Ĺ��췽��
	public Printer(double price){
		this.price = price;
		System.out.println(brand + "--" + price);
	}
	
	//���������Ĺ��췽��
	public Printer(String brand, double price){
		this.brand = brand;
		this.price = price;
		System.out.println(brand + "--" + price);
	}
	
	//һ���������ַ���
	public void print(String content){
		System.out.println("�ַ���" + content);
	}
	
	//һ������������
	public void print(int content){
		System.out.println("����" + content);
	}
	
	//����������
	public void print(String str, int content){
		System.out.println(str + "---" + content);
	}
}
