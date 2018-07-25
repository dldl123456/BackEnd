/*
 *  对数组中的元素删除（要删除的元素赋值该数据类型的默认值），
 *  然后再遍历输出非默认值的元素
 */

package step3.course.day11_20;

import java.util.Scanner;

public class Demo_3 {
	public static void main(String[] args) {
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int num = 0;// 用户给定
		int index = -1;// 记录下标
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要删除的数字：");
		num = input.nextInt();
		input.close();
		
		// 1.查有没有
		for (int i = 0; i < arr2.length; i++) {
			if (num == arr2[i]) {
				index = i;// 记录存在的下标
				arr2[index] = 0;
				break;
			}
		}
		if (index == -1) {
			System.out.println("没有这个数据，无序删除！");
			return;
		}
		
		// arr2[index] = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 0) {
				continue;
			}
			System.out.print(arr2[i]);
		}
	}
}
