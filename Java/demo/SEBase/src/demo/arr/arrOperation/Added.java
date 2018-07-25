/*
 *  数组新增
 */

package demo.arr.arrOperation;

import java.util.Scanner;

public class Added {
	public static void main(String[] args) {
		int[] arr = {1,5,4,6,2};
		int num;
		
		//遍历初始数组
		System.out.print("初始数组为：");
		for(int i : arr){
			System.out.print(i + " ");
		}
		
		//换行
		System.out.println();
		
		//输入新增的数
		System.out.print("请输入您要新增的数：");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		// 扩容
		int[] newArr = new int[arr.length + 1];  // 1.新建一个老数组长度+1的新数组
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];  // 把每个元素赋值给新数组中
		}
		newArr[arr.length] = num;  // 把没有的数字赋值给新数组中的末尾
		arr = newArr;  // 把新数组的引用地址赋值给老数组
		
		// 遍历输出新数组
		for (int arr_num : arr) {
			System.out.print(arr_num + " ");
		}
	}
}
