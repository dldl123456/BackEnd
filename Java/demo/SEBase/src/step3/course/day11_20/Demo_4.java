/*
 *  定义一个数组，根据用户的需求查看数组中有无数字，
 *  如有返回下标，如果没有，
 *  把这个数字加到数组的尾部
 */

package step3.course.day11_20;

import java.util.Scanner;

public class Demo_4 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };// 4，下标3
		int num = 0;// 输入数字
		int index = -1;// 下标记录
		Scanner input = new Scanner(System.in);
		System.out.println("请输入数字：");
		num = input.nextInt();
		input.close();
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			System.out.println("找到了！是在数组中第" + (index + 1) + "位。");
			return;
		}
		// 扩容
		// 1.新建一个老数组长度+1的新数组
		int[] newArr = new int[arr.length + 1];
		// 2.把老数组中的内容复制给新的数组
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];// 把每个元素赋值给新数组中
		}
		// 把没有的数字赋值给新数组中的末尾
		newArr[arr.length] = num;// 新数组中下标的最大值是老数组的长度正好是新数组长度-1；5，下标4
		// 把新数组的引用地址赋值给老数组
		arr = newArr;
		// 遍历老数组内容 for-each循环只能用于容器遍历，不能对容器的内容进行改变
		for (int arr_num : arr) {// 冒号左边写数组的数据类型和变量名，冒号右边写你要遍历的数组（大容器，例如：数组、集合）
			System.out.print(arr_num + " ");
		}
		// 上面的等价下面的
		// for (int i = 0; i < arr.length; i++) {
		// int arr_num=arr[i];
		// System.out.println(arr_num);
		// }
	}
}
