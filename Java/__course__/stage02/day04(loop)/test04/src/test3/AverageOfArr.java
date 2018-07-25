/*
 * 封装一个方法，求一个一维数组的平均值
 */

package test3;

public class AverageOfArr {
	public static void main(String[] args) {
		int[] arr = {1,2,6,8,9,56};
		
		float res = (float)average(arr);
		
		System.out.println("该数组的平均值为：" + res);
		
	}
	
	//求平均值
	public static double average(int[] arr){
		int length = arr.length;  //用来保存数组的长度
		int sum = 0;  //用来保存数组中的累加和
		float res = (float)0.0;  //用来保存计算的结果
		
		//遍历数组中的值，并进行累加，求其平均数
		for(int i=0; i<length; i++){
			sum += arr[i];  //求和
		}
		
		res = (float)(Math.round(sum/length*100)*0.01);  //求平均数
		
		return res;
	}
}