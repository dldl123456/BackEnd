/*  ���ַ���
 *  ����ָ�������������г��ֵ�λ�ã��ҵ������±꣬�Ҳ�������-1
 */

package video.eg.arrBinarySearch;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,7,12,17,19,21};  ////�����ʼ����(����)
		int index = -1;  //�����ҵ������������е��±꣬�Ҳ�������-1
		int number = 0;  //�û�Ҫ�������
		
		int start = 0;  //��ʼ�±�
		int end = array.length - 1;  //��ֹ�±�
		int middle;
		
		//����
		System.out.print("��������Ҫ���ҵ�����");
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
		
		//��ʼ����
		while(start<=end){
			//�ҵ��м��±�����Ӧ��Ԫ��ֵ
			middle = (start + end)/2;
			if(number == array[middle]){
				index = middle + 1;
				break;
			}
			//����Ҫ���ҵ��Ǹ��������м�Ƚϵ��Ǹ�����
			//ȥ����ߵ���
			if(number>array[middle]){
				start = middle + 1;
			}
			//������ߵ�����ȥ���ұߵ���
			if(number<array[middle]){
				end = middle - 1;
			}
		}
		
		//���
		if(index == -1){
			System.out.println("not find");
		} else {
			System.out.println("find at��" + index);
		}
	}
}
