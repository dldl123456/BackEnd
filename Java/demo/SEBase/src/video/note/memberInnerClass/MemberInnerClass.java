/*
 *  ��Ա�ڲ���
 */

package video.note.memberInnerClass;

//������
public class MemberInnerClass {
	public static void main(String[] args) {
		//�����ⲿ�����
		Ouer1 outer = new Ouer1();
		//�����ڲ������(�ⲿ����.�ڲ�����  ʵ����  = �ⲿ��ʵ����.new �ڲ��๹�췽��(����))
		//�ڲ��๹�췽��-->Ĭ���޲εĹ��췽��
		Ouer1.Inner1 inner = outer.new Inner1();
		inner.innerShow();  //�����ڲ���ķ���
		
		//�ⲿ�����outerShow����
		outer.outerShow();
	}
}

//�ⲿ��
class Ouer1{
	private String name = "����";
	private int num1 = 10;
	
	public void outerShow(){
		System.out.println(name);
		System.out.println(num1);
		//System.out.println(num2);  //�ⲿ�಻��ֱ�ӷ����ڲ���ĳ�Ա
		
		//�ⲿ����ʳ�Ա�ڲ��࣬�����Ȳ���һ���ڲ������
		Inner1 inner1 = new Inner1();
		inner1.innerShow();
	}
	
	//��Ա�ڲ��ࣨ����������������η���
	public class Inner1{
		private String name = "����";
		private int num2 = 20;
		private static final int num3 = 50;  //��̬�������ڲ����п���
		//private static int num3 = 30;  //�ڳ�Ա�ڲ����в���������̬�ĳ�Ա���������Ժͷ���
		
		//��Ա�ڲ��������private����ֻΪ���ⲿ����񣬲��������޷�����
		public void innerShow(){  //���ܼ�static
			System.out.println(name);
			System.out.println(Ouer1.this.name);  //�����ⲿ���name����
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num1);  //����ֱ�ӷ����ⲿ��˽������
			// outerShow();  //��Ա�ڲ����п���ֱ�ӷ����ⲿ������Ժͷ���������˽�е�
			//��ͬ��Outer.this.outerShow(); ��Ϊ�ڲ���û��ͬ�����������Կ���ʡ��
		}
	}
}
