/*
 *  ��̬�ڲ���
 */

package video.note.staticInnerClass;

public class StaticInnerClass {
	public static void main(String[] args) {
		//��̬��ͨ������.������
		//����һ����̬�ڲ������
		Outer.Inner inner = new Outer.Inner();
		inner.innerShow();  //�����ڲ��෽��
		
		//�����ⲿ�����Ȳ����ⲿ�����
		Outer outer = new Outer();
		outer.outerShow();
	}
}

//�ⲿ��
class Outer{
	private String name = "����";
	private int num1 = 10;
	private static int num3 = 10000;
	
	//�ⲿ�෽��
	public void outerShow(){
		System.out.println(name);
		System.out.println(num1);
		Inner inner = new Inner();  //���ʾ�̬�ڲ���Ǿ�̬��Ա���Ȳ�������
		System.out.println(inner.name);  //�����ڲ���Ǿ�̬��Ա
	}
	
	//һ����̬�ڲ���
	public static class Inner{
		private String name = "����";
		private int num2 = 50;
		
		//�ڲ��෽��
		public void innerShow(){
			System.out.println(name);
			//System.out.println(Outer.this.num1);
			//��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա
			System.out.println(num2);
			System.out.println(num3);  //���Է����ⲿ��̬�ĳ�Ա
			//��̬�����࣬��̬������this��ֻ��������.
			//��ͬ��Outer.num3
			
			//��̬�ڲ�������ⲿ�Ǿ�̬��Ա��
			//�����ⲿ�����Ȳ����ⲿ�����
			Outer outer = new Outer();
			System.out.println(outer.num1);
		}
	}
}
