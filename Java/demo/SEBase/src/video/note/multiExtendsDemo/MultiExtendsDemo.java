package video.note.multiExtendsDemo;

public class MultiExtendsDemo {
	//������
	public static void main(String[] args) {
		C c = new C();  //�Ȳ����ⲿ�����
		c.showA();
		c.showB();
	}
}

class A{
	public void showA(){
		System.out.println("A");
	}
}

class B{
	public void showB(){
		System.out.println("B");
	}
}

//���ڲ���ʵ�ֶ�̳�
class C {
	//�ڲ���A1�̳�A
	private class A1 extends A{
		public void showA(){
			super.showA();  //���ø��������showA����
		}
	}
	
//ͨ�����ڲ���������ֱ�����������ڲ���������show����
//ͨ���ڲ�������ӵ�ʵ�ֶ�̳�
	
	//�ڲ���B1�̳�B
	private class B1 extends B{
		public void showB(){
			super.showB();  //���ø��������showB����
		}
	}
	
	//����A1����
	public void showA(){
		new A1().showA();
	}

	//����B1����
	public void showB(){
		new B1().showB();
	}
}