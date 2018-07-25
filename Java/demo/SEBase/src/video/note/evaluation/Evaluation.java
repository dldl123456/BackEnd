/*
 *  计算从1开始的连续n个数之和，当其和值刚好超过100时结束，求这个n的值
 */

package video.note.evaluation;

public class Evaluation {
	public static void main(String[] args) {
		int n = 0;  //要求被加的数
		int sum = 0;  //累加求和
		
		do{
			n++;
			sum += n;
		} while (sum<=100);
		
		System.out.println("从1开始的连续" + n + "个数之和，当其和值刚好超过100时结束，此时的累加和为：" + sum);
	}
}
