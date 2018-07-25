/*  选择排序：
 *  对数组进行从小到大排序
 */

package video.eg.arrSelectSort;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		int min = 0;  //保存最元素的小标
		//查找最小数在数组中的下标
		for(int i=0; i<array.length; i++){
			min = i;
			for(int j=i+1; j<array.length; j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			// 如果第i个最小的数位置不在i上，则进行交换
			if(i!=min){
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
