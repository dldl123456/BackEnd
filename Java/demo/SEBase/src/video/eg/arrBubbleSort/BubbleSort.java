/*  ð������
 *  ��������д�С��������
 *  ������Ƚϣ�С��ǰ����ѭ���Ƚ�n-1�Σ���ѭ���Ƚ�n-1-i��
 */

package video.eg.arrBubbleSort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		//N�����Ƚϵ�����ΪN-1
		for(int i=0; i<array.length; i++){
			//ÿһ�ֱȽϵĴ���ΪN-1-i��
			for(int j=0; j<array.length-1-i; j++){
				//�Ƚ����ڵ���������С��ǰ
				if(array[j]>array[j+1]){
					//������������ͨ����ʱ����
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		//���ź�����������
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
