/*
 * ���1-1000���е�����
 */

package test3;

public class OutputPrimeNumber {
	public static void main(String[] args) {
		//ѭ������1000���ڵ�������
		for(int n=2; n<1000; n++){
			boolean isPrime = true;  //�����ж��Ƿ�Ϊ����
			//�ж��Ƿ�Ϊ����
			for(int i=2; i<n; i++){
				if(n%i == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime == true){
				System. out.print(n + ",");
			}
		}
	}
}