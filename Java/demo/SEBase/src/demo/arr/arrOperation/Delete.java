/*
 *  数组删除
 */

package demo.arr.arrOperation;

import java.util.Scanner;

public class Delete {
	public static void main(String[] args) {
		int[] arr = {1,5,4,6,2};
		int num = 0;// 用户给定
		int index = -1;// 记录下标
		
		System.out.print("初始数组为：");
		for(int i : arr){
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要删除的数字：");
		num = input.nextInt();
		input.close();
		
		// 1.查有没有
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				index = i;// 记录存在的下标
				arr[index] = 0;
				break;
			}
		}
		if (index == -1) {
			System.out.println("没有这个数据，无序删除！");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}
			System.out.print(arr[i] + " ");
		}
	}
}
