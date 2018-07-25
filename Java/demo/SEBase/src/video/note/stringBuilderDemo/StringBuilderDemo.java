package video.note.stringBuilderDemo;

public class StringBuilderDemo {
	public static void main(String[] args) {
		//StringBuilder sb = "abc";  //�޴���������ʽ
		StringBuilder sb = new StringBuilder();  //��һ���޲εĹ��췽����Ĭ�Ͽ���16���ַ���С������������
		//StringBuilder sb = new StringBuilder(100);  //��ʼ��������С
		//StringBuilder sb = new StringBuilder("abc");  //ǰ����abc
		
		sb.append("aa");  //���ַ���������׷��
		sb.append(1.5);  //�ܶ෽�������أ����Կ��Է��������ͣ����Ҷ�ת�����ַ���
		System.out.println(sb.length());  //����
		System.out.println(sb.capacity());  //����
		sb.insert(1, "www");  //��ĳ���ط�����
		System.out.println(sb.toString());  //���
		sb.replace(1, 3, "1008686");  //�滻
		System.out.println(sb.toString());
		System.out.println(sb.indexOf("w"));  //w�״γ��ֵ��±�
		System.out.println(sb.reverse());  //��ת�����������
	}
}