package help;

import java.util.Random;
import java.util.Scanner;

/**
 * ��֤���࣬�������ɺͲ�����֤�뷽��
 * @author Administrator
 *
 */
public class ProvingNum {
	static Scanner input = new Scanner(System.in);
	/**
	 * ��֤�뷽��
	 */
	public static String provingNum() {
		String prov ="";//����һ���ַ������������ɵ���֤��
		Random ran = new Random();//���������������һ�����������
		for(int i=0;i<4;i++) {
			String charOrInt = ran.nextInt(2) %2 == 0 ? "ch" : "in";//����һ��0��1֮����������ȡģ����Ŀ������жϺ󸳸�String
			//�ж����ַ��������κ���в���
			if("ch".equalsIgnoreCase(charOrInt)) {//������ַ�����������һ����д��Сд��ĸ
				int en = ran.nextInt(2) %2 ==0 ? 65 : 97;//����һ��0��1֮����������ȡģ
				prov += (char)(ran.nextInt(26)+en);//����һ��0-25�������������65��97���϶�����ĸ
			}else if("in".equalsIgnoreCase(charOrInt)) {//��������֣���������һ������
				prov += String.valueOf(ran.nextInt(10));//String.valueOf(int i) ��ʾ����һ��int�������ַ���������ʽ
			}
		}		
		return prov;
	}
	//��֤��ľ����������
	public static void operateProv() {
		System.out.println("��������֤�룺");
		a:while(true) {
			String prov =provingNum();
			System.out.println(prov);
			String pro1 = input.next();
			if(!pro1.equalsIgnoreCase(prov)) {
				System.out.println("��֤�����������������������֤�룺");
				continue a;
			}else {
				System.out.println("���������룺");
				break;
			}
		}		
	}
}
