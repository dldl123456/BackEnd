/*  二分法：
 *  查找指定的数在数组中出现的位置，找到返回下标，找不到返回-1
 */

package video.eg.arrBinarySearch;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,7,12,17,19,21};  ////定义初始数组(有序)
		int index = -1;  //保存找到数所在数组中的下标，找不到等于-1
		int number = 0;  //用户要输入的数
		
		int start = 0;  //起始下标
		int end = array.length - 1;  //终止下标
		int middle;
		
		//输入
		System.out.print("请输入您要查找的数：");
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
		
		//开始查找
		while(start<=end){
			//找到中间下标所对应的元素值
			middle = (start + end)/2;
			if(number == array[middle]){
				index = middle + 1;
				break;
			}
			//假如要查找的那个数大于中间比较的那个数，
			//去掉左边的数
			if(number>array[middle]){
				start = middle + 1;
			}
			//保留左边的数，去掉右边的数
			if(number<array[middle]){
				end = middle - 1;
			}
		}
		
		//输出
		if(index == -1){
			System.out.println("not find");
		} else {
			System.out.println("find at：" + index);
		}
	}
}
