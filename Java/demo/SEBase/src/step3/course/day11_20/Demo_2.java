package step3.course.day11_20;

public class Demo_2 {
	public static void main(String[] args) {
		int[] arr1 = new int[4];  //new�����[]�����ֲ�д
		int[] arr2 = {1,2,4,8};  //�������鲢��ÿ��Ԫ�ظ���ʼֵ
		
		System.out.println(arr1 + "" + arr2);
		
		int[] arr3 = new int[]{1,2,4,8};  //(������)���ں����������Ѿ�����ϸ��Ԫ�ظ��������Բ���д����
		int[] arr4 = null;  //�������飬û�п��ٿռ�
		
		arr4 = arr3;
		
		for(int i=0; i<arr4.length; i++){
			System.out.print(arr4[i]);
		}
		
		
	}
}
