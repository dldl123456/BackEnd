/*
 *  ѧУ�����䱸һ̨��ӡ���������Ǻڰ״�ӡ����Ҳ�����ǲ�ɫ��ӡ������
 *  ���Ŀ���ͨ����ӡ����ӡѧԱ�ĸ�����Ϣ�����������ĵȣ���
 *  ͨ���̳кͶ�̬������������ʹ������и��õ���չ�Ժ�ά���ԡ�
 */

package test2;

public class Printer {
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
	
	//��������������ڡ������ࣩ
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("����");
		BlackPrinter bp = new BlackPrinter("����");
		
		School school1 = new School();
		school1.setPrinter(bp);
		school1.print("����");
		
		School school2 = new School();
		school2.setPrinter(cp);
		school2.print("����");
		
	}
}
