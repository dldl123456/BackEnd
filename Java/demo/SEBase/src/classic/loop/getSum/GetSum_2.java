/*
 *  求1到100之间的奇数之和与偶数之和。
 */

package classic.loop.getSum;

public class GetSum_2 {
	public static void main(String[] args){
		int sumOdd = 0;  //用来保存奇数和的结果
		int sumEven = 0;  //用来保存偶数和的结果
		
		//遍历1-100中的正整数并求和
		for(int i=0; i<=100; i++){
			if(i%2 != 0){
				sumOdd += i;  //求奇数和
            } else {
            	sumEven += i;  //求偶数和
            }
		}
		
		//输出奇数和与偶数和
		System.out.println("1到100之间的奇数之和为：" + sumOdd);
		System.out.println("1到100之间的偶数之和为：" + sumEven);
	}
}
