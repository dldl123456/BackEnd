package video.note.extendsDemo;

public class AandB {
	public static void main(String[] args) {
		B b = new B();  //����b�Ķ����ʱ��Ҳ������b�Ĺ��췽��
		//������������ʱ��Ҳ�����˸���Ĺ��췽��
		b.showB();  //����B��showB����
	}
}

class A{
	public A(){
		System.out.println("A�Ĺ��췽��");
	}
	
	public void showA(){
		System.out.println("A");
	}
	
	public void showB(){
		System.out.println("����showA�������showB");
	}
}

class B extends A{
	public B(){
		//Ĭ�ϱ���
		super();  //���ø����޲����Ĺ��췽��������ʡ��
		System.out.println("B�Ĺ��췽��");
	}
	
	public void showB(){
		System.out.println("B");
		//���෽������ø��෽��(������Ե��ø����˽�еķ���)
		showA();  //�ȼ���super.showA();
		//����ͬ��������ʱ����ʡ��super
		super.showB();  //���ø���showB����
	}
}