/*
 *  arrays util demo
 */

package video.note.arraydemo;

import java.util.Arrays;

public class Arraydemo_2 {
	public static void main(String[] args) {
		// ��������
		int[] arraySrc1 = {1,5,4,6,2};
		int[] arrayDes1= Arrays.copyOf(arraySrc1, 10);
		for(int i=0; i<arrayDes1.length; i++){
			System.out.print(arrayDes1[i] + " ");
		}
		
		System.out.println("\n");
		
		//����
		Arrays.sort(arraySrc1);
		for(int i=0; i<arraySrc1.length; i++){
			System.out.print(arraySrc1[i] + " ");
		}
		
		System.out.println("\n");
		
		//���ַ�����
		int index = Arrays.binarySearch(arraySrc1, 5);
		System.out.println(index);
	}
}
