package video.note.staticDemo;

public class StaticDemo {
	public static void main(String[] args) {
		//ÿ��������һ���Լ�����������
		
		//acc1
		Account acc1 = new Account();  //ʵ����һ��acc1����
		//���÷���
		acc1.num3 ++;  //public��������ֱ�ӵ���
		Account.num4 ++;  //һ�㲻��acc1.num4
		acc1.showNum1();
		acc1.showNum2();
		acc1.showNum3();
		acc1.showNum4();
		
		//acc2
		Account acc2 = new Account();  //ʵ����һ��acc2����
		//���÷���
		acc2.showNum1();
		acc2.showNum2();
		acc1.showNum3();
		acc1.showNum4();
		
		//���þ�̬����
		Account.showTxt();  //���þ�̬����������.������
		
		//acc3
		//���췽��(ֻҪ�����������ÿ�ζ���ִ��)
		Account acc3 = new Account();  //ʵ����һ��acc3����
		acc3.showNum1();
	}
}

class Account{
	//����˽�б���
	private int num1 = 1;
	private int num2 = 2;
	//���幫������
	public int num3 = 3;
	//���徲̬���� -- ��̬����(�����)�����������κ�һ�����󣬱����������
	public static int num4 = 4;
	
	//���췽��(ֻҪ�����������ÿ�ζ���ִ��)
	public Account(){
		System.out.println("���췽��");
	}
	
	//static����
	//�౻���ص�ʱ��ͻ�ִ�У�ֻ��ִ��һ�Σ������Ծ�̬�ı�����ֵ
	//ֻ�ܶԾ�̬�ı�����ֵ
	//�����ڹ��췽����ִ��
	//����ȫ��static���ƻ������������ص㣬��ռ��ʱ��Ƚϳ�
	//һ��������û���κ����ԣ�ֻ�з�������Щ����ר��Ϊ����������ʱ���ã�Arrays�ࣩ
	static{
		System.out.println("static");
		num4 = 100;
	}
	
	//����num1
	public void showNum1(){
		System.out.println("num1 = " + num1);
	}
	
	//����num2
	public void showNum2(){
		System.out.println("num2 = " + num2);
	}
	
	//����num3
	//�Ǿ�̬�������ʾ�̬���ݺͷǾ�̬�����Ժͷ���
	//��̬��ֻ�ܷ��ʾ�̬�ģ��Ǿ�̬�Ķ����Է���
	public void showNum3(){
		System.out.println("�Ǿ�̬�������ʾ�̬����(num4)��" + num4);
		System.out.println("num3 = " + num3 + "(public)");
	}
	
	//����num4
	public void showNum4(){
		System.out.println("num4 = " + num4 + "(static(����))");
	}
	
	//��̬��������̬���������static��
	//��̬�����в��ܷ��ʷǾ�̬�ı��������ԣ�
	//���������ڶ���ģ�����̬�Ķ����ڵ��õ�ʱ�����û�в���
	//��̬�����в�����this��thisָ��ǰ�������ã���Ϊ��û�в����������Բ���ʹ��
	public static void showTxt(){
		System.out.println("num4 = " + num4 + "(static(��̬�������ܷ����ⲿ��̬�Ķ��������ܷ����ⲿ�Ǿ�̬�Ķ���))");
		System.out.println("���Ǿ�̬����");
	}
}

