package step3.course.day12_10;

public class BlackPrinter extends Printer {
	//��д����
	public void print(){
		System.out.println("�ڰ״�ӡ��");
	}
	
	//��չ�ķ���
	public void test(){
		System.out.println("test");
	}
	
	//���췽�����������ã���һ�ǳ�ʼ���������ڶ��Ǵ�������
	//���췽�������ִ�еģ����췽��ִ���ˣ�����ʹ�������
	//���췽�� 3
	public BlackPrinter(){
		System.out.println("BlackPrinter...");
	}
	
	//����� 2
	{
		System.out.println("test...");
	}
	
	//��̬�� 1
	static {
		System.out.println("static...");
	}
	
	public static void main(String[] args) {
		new BlackPrinter();  //�����������
//		new BlackPrinter();  //��������staticִֻ��1��
		
		//������������ʱ����ȴ����������
		
		//�ڸ������棬��ִ��������̬�ࣨ�����ӣ����ٸ���Ĵ���飬����Ĺ��췽����
		//������Ĵ���飬����Ĺ��췽��
	}
}
