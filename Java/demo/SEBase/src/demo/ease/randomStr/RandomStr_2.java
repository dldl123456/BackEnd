/*
 *  ���������ַ�����������������һ��
 */

package demo.ease.randomStr;

public class RandomStr_2 {
	public static void main(String[] args) {
		String[] str = { "�ٺ�", "����", "����", "�¸�", "����" };
		int random = (int) ( Math.random () * 5 );
		System.out.println (str[random]);
	}
}
