/*
 *  求1+4+7+……+100之和。
 */

package classic.loop.getSum;

public class GetSum_1 {
	public static void main(String[] args) {
		System.out.println("方法1：1+4+7+……+100之和为：" + sum1());
		System.out.println("方法1：1+4+7+……+100之和为：" + sum2());
		System.out.println("方法1：1+4+7+……+100之和为：" + sum3(100));
	}
	
	//方法一  for循环
	public static int sum1(){
		int sum = 0;  //用来求和的结果
		for(int i=0; i<=100; i++){
			sum += i;
		}
		return sum;
	}
	
	//方法二  while循环
	public static int sum2(){
		int sum = 0;  //用来求和的结果
		int i = 0;
		while(i<=100){
			sum += i;
			i++;
		}
		return sum;
	}
	
	//方法三  递归
	public static int sum3(int num){
		if(num == 1){
			return 1;
		} else {
			return num + sum3(num-1);
		}
	}
}
