/*  ��������
 *  ��������д�С��������
 */

package video.eg.arrInsertSort;

public class InsertSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		
		for(int i=1; i<array.length; i++){
			int temp = array[i];
			//��С�걣������
			int j = i;
			while(j>0&&temp<array[j-1]){
				//��������������������
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;  //��������
		}
		
		//���
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
