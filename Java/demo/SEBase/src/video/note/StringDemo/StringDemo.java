/*
 *  �ַ�����ϰ(����)
 */

package video.note.StringDemo;

public class StringDemo {
	public static void main(String[] args) {
		String content = "hello , my frIend !";
		//��������ѡ��
		System.out.println(content.charAt(4));
		//�Ƚ�
		System.out.println(content.compareTo("Hello"));
		//ƴ�� ��ͬcontent += "10086";
		content = content.concat("10086");
		System.out.println(content);
		//��ʲô����
		System.out.println(content.endsWith("10086"));
		//��ʲô��ʼ
		System.out.println(content.startsWith("hello"));
		//�Ƿ����ĳ���ַ���
		System.out.println(content.contains("my"));
		//�Ƚ�
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		//�Ƚ�2
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		//��ѯ(��һ�γ��ֵ��±�)
		System.out.println(content.indexOf("o"));
		//��ѯ(���һ�γ��ֵ��±�)
		System.out.println(content.lastIndexOf("o"));
		//��ѯ(���±�Ϊ5�ĵط�ȥ�ҵ�һ�γ���o���±�)
		System.out.println(content.indexOf("o", 5));
		//����
		System.out.println(content.length());
		//�滻�ַ���
		System.out.println(content.replace('h', 's'));
		//����ַ���(�Կո�����)
		String[] arr = content.split(" ");
		System.out.println(arr.length);
		for(String i : arr){
			System.out.println(i);
		}
		//��ȡ�ַ���
		System.out.println(content.substring(4));
		System.out.println(content.substring(4, 15));
		//��Сд
		System.out.println(content.toLowerCase());
		System.out.println(content.toUpperCase());
	}
}
