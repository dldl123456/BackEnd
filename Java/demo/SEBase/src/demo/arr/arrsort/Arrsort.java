/*
 *  Ϊָ���ɼ��ӷ֣�ֱ���������ڵ��� 60 Ϊֹ������ӷ�ǰ�ͼӷֺ�ĳɼ�����ͳ�ƼӷֵĴ���
 */

package demo.arr.arrsort;

import java.util.Scanner;

public class Arrsort {
	public static void main(String[] args){
        System. out.print( "�����뿼�Գɼ���" );
        Scanner input = new Scanner(System. in);
        int score = input.nextInt();
        System. out.println( "�ӷ�ǰ�Ŀ��Գɼ�Ϊ��" +score );
        input.close();
        int count = 0;
        while( score < 60 ){
           count++;
           score++;
        }
        System. out.println( "һ������"+count +"��" );
        System. out.println( "�ӷֺ�ĳɼ�Ϊ" +score );
	}
}
