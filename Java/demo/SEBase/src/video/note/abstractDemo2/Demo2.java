package video.note.abstractDemo2;

public class Demo2 {
	//������
	public static void main(String[] args) {
		Son son = new Son();
		son.show();
		son.show2();
	}
}

//������
abstract class Parent{
	public abstract void show();  //���󷽷�
}

//�ӿ�
interface IShow{
	public abstract void show();  //���󷽷�
}

/*class Son extends Parent implements IShow{
	//��д
	public void show() {
		
	}
}*/

//ͨ���ڲ���ʵ����д�ӿں��ڲ�����ĳ��󷽷�
class Son extends Parent{
	public void show(){
		System.out.println("�������е�show����");
	}
	
	//�����ڲ��࣬���ڲ�����ʵ�ֽӿ�
	private class Inner2 implements IShow{
		public void show() {
			System.out.println("�ӿ��е�show����");
		}
	}
	
	public void show2(){
		//����һ���ڲ���Ķ���
		new Inner2().show();
	}
}
