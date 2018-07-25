/*  冒泡排序：
 *  对数组进行从小到大排序
 *  两两相比较，小靠前，外循环比较n-1次，内循环比较n-1-i次
 */

package video.eg.arrBubbleSort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		//N个数比较的轮数为N-1
		for(int i=0; i<array.length; i++){
			//每一轮比较的次数为N-1-i次
			for(int j=0; j<array.length-1-i; j++){
				//比较相邻的两个数，小靠前
				if(array[j]>array[j+1]){
					//两个数交换，通过临时变量
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		//把排好序的数组输出
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
