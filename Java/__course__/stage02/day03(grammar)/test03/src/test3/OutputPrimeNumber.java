/*
 * 求出1-1000所有的素数
 */

package test3;

public class OutputPrimeNumber {
	public static void main(String[] args) {
		//循环遍历1000以内的正整数
		for(int n=2; n<1000; n++){
			boolean isPrime = true;  //用来判断是否为素数
			//判断是否为素数
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