/*
 *  ��1��100֮�������֮����ż��֮�͡�
 */

package classic.loop.getSum;

public class GetSum_2 {
	public static void main(String[] args){
		int sumOdd = 0;  //�������������͵Ľ��
		int sumEven = 0;  //��������ż���͵Ľ��
		
		//����1-100�е������������
		for(int i=0; i<=100; i++){
			if(i%2 != 0){
				sumOdd += i;  //��������
            } else {
            	sumEven += i;  //��ż����
            }
		}
		
		//�����������ż����
		System.out.println("1��100֮�������֮��Ϊ��" + sumOdd);
		System.out.println("1��100֮���ż��֮��Ϊ��" + sumEven);
	}
}
