/*
 *  �ֲ��ڲ���
 */

package video.note.localInnerClass;

public class LocalInnerClass {
	//������
	public static void main(String[] args) {
		//��Ҫִ�оֲ��ڲ���ķ�������Ҫ����һ���ⲿ��Ķ���
		Outer outer = new Outer();
		outer.showOuter();  //�ȵ����ⲿ��ķ���
	}
}

class Outer{
	private String name = "zzz";
	private int num1 = 10;
	private static int num2 = 20;
	
	public void showOuter(){
		/*final*/ int num3 = 501;
		//�ֲ��ڲ��಻�ܼӷ������η�
		class Inner{
			private int num4 = 30;
			private int num1 = 20;
			
			public void showInner(){
				System.out.println(num4);  //�ڲ�������ĳ�Ա
				//Ҫ�������ȴ����ڲ������
				System.out.println(num1);  //�Լ���num1
				//�ⲿ���num1
				System.out.println(Outer.this.num1);
				//�ⲿ��̬��num2
				System.out.println(Outer.num2);
				//���������棬�ڲ������棬�ľֲ�������num4
				System.out.println(num3);
				//�ֲ��ڲ���ֻ�ܷ��������䷽���еĳ���
				System.out.println(name);
			}
		}
		Inner inner = new Inner();  //ʵ��������
		inner.showInner();
	}
}