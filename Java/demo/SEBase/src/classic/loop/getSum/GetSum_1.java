/*
 *  ��1+4+7+����+100֮�͡�
 */

package classic.loop.getSum;

public class GetSum_1 {
	public static void main(String[] args) {
		System.out.println("����1��1+4+7+����+100֮��Ϊ��" + sum1());
		System.out.println("����1��1+4+7+����+100֮��Ϊ��" + sum2());
		System.out.println("����1��1+4+7+����+100֮��Ϊ��" + sum3(100));
	}
	
	//����һ  forѭ��
	public static int sum1(){
		int sum = 0;  //������͵Ľ��
		for(int i=0; i<=100; i++){
			sum += i;
		}
		return sum;
	}
	
	//������  whileѭ��
	public static int sum2(){
		int sum = 0;  //������͵Ľ��
		int i = 0;
		while(i<=100){
			sum += i;
			i++;
		}
		return sum;
	}
	
	//������  �ݹ�
	public static int sum3(int num){
		if(num == 1){
			return 1;
		} else {
			return num + sum3(num-1);
		}
	}
}
