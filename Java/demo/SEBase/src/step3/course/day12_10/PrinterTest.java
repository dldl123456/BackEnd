package step3.course.day12_10;

public class PrinterTest {
	public static void main(String[] args) {
		//��ʽ�滻ԭ��
		//������ֵĵط����������������滻
		
		//��̬��Ҫ�أ�
		//�̳У���д�����������������
		
		//���������������
		//���常�����͵����ñ���ָ����������󣬴����ñ�������������д����ķ���
		//�����ʱ���Ǹ������ͣ����е�ʱ������������
		//����ʱ��ָ����������ַ
		//���������ת���˸��࣬����ת��
		/*BlackPrinter*/ Printer black = new BlackPrinter();  //��̬������ת�ͣ�
		black.print();
		//black.test();����ֱ�ӵ�����չ����,�����ʱ���Ǹ������ͣ�test���ڸ�������
		//����ת�Ϳ������Լ��ķ���
		//�ж�black�����Ƿ�ΪBlackPrinter���ʵ��
		//�ж�black�Ƿ�ΪBlackPrinter����
		if(black instanceof BlackPrinter){
			//����ǽ���ǿת,���������õ��������ǿ��ת�����������
			BlackPrinter blk = (BlackPrinter)black;
			blk.test();  //��������������չ����
		}
		
		
		/*ColorPrinter*/ Printer color = new ColorPrinter();  //��̬
		color.print();
		
		
		//����ת�ַ���������ֱ��ת����
		Object obj = new Integer(123);  //����ת��
		//�ж�obj�Ƿ�ΪString����
		if(obj instanceof String){
			String str = (String)obj;  //ǿת������ת��
			System.out.println(str);
		}
		System.out.println(obj);
		
		//�ַ���תint(�����������͵İ�װ��)
		String str1 = "123";
		int num = Integer.parseInt(str1) + 100;
		System.out.println(num);
		
		/* ��װ��,����������ĸ��д ==>  ��װ�����Ϊ�˸������ṩ����
		 * char  --  Character
		 * byte
		 * short
		 * int  --  Integer
		 * long
		 * float
		 * double
		 * 
		 * boolean
		 */
	}
}
