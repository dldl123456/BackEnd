/*
 * �������е����ֵ����Сֵ 
 */

package video.eg.arrLinearSearch;

public class LinearSearch_2 {
	public static void main(String[] args) {
		int[] array = {10, 100, 80, 50, 70, 60, 90};  //�����ʼ����
		int max = array[0];  //���
		int min = array[0];  //��С
		
		//�Ƚ�
		for(int i=1; i<array.length; i++){
			//�������ֵ
			if(array[i] > max){
				max = array[i];
			}
			//������Сֵ
			if(array[i] < min){
				min = array[i];
			}
		}
		
		//���
		System.out.println("���ֵΪ��" + max);
		System.out.println("��СֵΪ��" + min);
	}
}
