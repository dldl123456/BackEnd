/*
 * ��װһ����������һ��һά�����ƽ��ֵ
 */

package test3;

public class AverageOfArr {
	public static void main(String[] args) {
		int[] arr = {1,2,6,8,9,56};
		
		float res = (float)average(arr);
		
		System.out.println("�������ƽ��ֵΪ��" + res);
		
	}
	
	//��ƽ��ֵ
	public static double average(int[] arr){
		int length = arr.length;  //������������ĳ���
		int sum = 0;  //�������������е��ۼӺ�
		float res = (float)0.0;  //�����������Ľ��
		
		//���������е�ֵ���������ۼӣ�����ƽ����
		for(int i=0; i<length; i++){
			sum += arr[i];  //���
		}
		
		res = (float)(Math.round(sum/length*100)*0.01);  //��ƽ����
		
		return res;
	}
}