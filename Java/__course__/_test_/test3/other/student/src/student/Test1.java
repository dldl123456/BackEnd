package student;

import java.util.Arrays;

public class Test1 {
	  /** ����䳤�㷨! 
	   * ������󳤶Ȳ��ɸı�
	   * ���Ǻܶ�ʵ��Ӧ����Ҫ���ȿɱ������
	   * ���Բ��ø���Ϊ���������������, �滻ԭ����, ʵ�ֱ䳤����
	  * */
	 public static void main(String[] args) {
		         //����䳤(����)�㷨! 
		          int[] ary={1,2,3};
		          ary=Arrays.copyOf(ary, ary.length+1);
		          ary[ary.length-1]=4;
		          System.out.println(Arrays.toString(ary));//[1, 2, 3, 4]
		          //�ַ�������ԭ��
		          char[] chs = { '��', '��' };
		          chs = Arrays.copyOf(chs, chs.length + 1);
		          chs[chs.length - 1] = '��';
		          chs = Arrays.copyOf(chs, chs.length + 1);
		          chs[chs.length - 1] = '��';
		          //�ַ����鰴���ַ�����ӡ
		          System.out.println(chs);//�й�����
		          //�������鰴�ն����ӡ
		          System.out.println(ary);//[I@4f1d0d
		      }
}
