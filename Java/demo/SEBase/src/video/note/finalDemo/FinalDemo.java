package video.note.finalDemo;

public class FinalDemo {
	public static void main(String[] args) {
		A a = new A();
		a.showNum1();
		
		B b = new B();  //�������������Ϊ��������Զ����ø�����޲ι��췽��
		b.showNum2();
		
	//final�������ñ����ϣ���������ñ���ֻ������
	//һ��ʼ�����õĶ�����;���ܸı�ָ��
		//a2����һ��ָ�룬��ָ�����new A()�������
		//a2�������new A()�����������ڴ��ַ
		//a2������new������A���͵Ķ���
		//����final��ʾa2ֻ��ָ�����new������A���͵Ķ���
		final A a2 = new A();
		//a2 = new A(); ����
		//a2����ָ��new A()��������ڴ��ַ��
		//�������Ǹ�new A()���ڴ����ֲ�����һ������
		//����a2�ı��˷��򣬾ͳ�����
		a2.num2 = 5;
		a2.showNum2();
	}
}

//����
//�����಻�ܱ��̳�
/*final*/ class A{
	public final int num1 = 1;  //����final���ǳ���
	public int num2 = 2;
	
	public void showNum1(){
		//���ܽ���num1 ++;�����ǲ��ܱ��޸ĵ�
		System.out.println(num1);
	}
	
	//���಻�ܶԸ����еĳ����������и�д����д��
	public /*final*/ void showNum2(){  //����final��ʾ��������
		System.out.println(num2);
	}
}

//����
class B extends A{
	public void showNum2(){  //�����������ܱ���д
		super.showNum1();
		super.showNum1();
		System.out.println(num2 + "!");
	}
}
