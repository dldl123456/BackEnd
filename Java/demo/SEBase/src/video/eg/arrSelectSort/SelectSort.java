/*  ѡ������
 *  ��������д�С��������
 */

package video.eg.arrSelectSort;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		int min = 0;  //������Ԫ�ص�С��
		//������С���������е��±�
		for(int i=0; i<array.length; i++){
			min = i;
			for(int j=i+1; j<array.length; j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			// �����i����С����λ�ò���i�ϣ�����н���
			if(i!=min){
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
