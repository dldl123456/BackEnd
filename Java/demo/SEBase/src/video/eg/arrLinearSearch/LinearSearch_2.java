/*
 * 求数组中的最大值和最小值 
 */

package video.eg.arrLinearSearch;

public class LinearSearch_2 {
	public static void main(String[] args) {
		int[] array = {10, 100, 80, 50, 70, 60, 90};  //定义初始数组
		int max = array[0];  //最大
		int min = array[0];  //最小
		
		//比较
		for(int i=1; i<array.length; i++){
			//查找最大值
			if(array[i] > max){
				max = array[i];
			}
			//查找最小值
			if(array[i] < min){
				min = array[i];
			}
		}
		
		//输出
		System.out.println("最大值为：" + max);
		System.out.println("最小值为：" + min);
	}
}
