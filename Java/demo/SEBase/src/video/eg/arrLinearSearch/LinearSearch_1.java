/*
 *  线性查找法：
 *  查找指定的数在数组中出现的位置，找到返回下标，找不到返回-1
 */

package video.eg.arrLinearSearch;

import java.util.Scanner;

public class LinearSearch_1 {
	public static void main(String[] args) {
		int[] array = {10, 100, 80, 50, 70, 60, 90};  //定义初始数组
		int index = -1;  //保存找到数所在数组中的下标，找不到等于-1
		int number = 0;  //用户要输入的数
		
		//输入
		System.out.print("请输入您要查找的数：");
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
		
		for(int i=0; i<array.length; i++){
			if(array[i] == number){
				index = i + 1;
				break;
			}
		}
		
		if(index != -1){
			System.out.println("您查找的数字在数组中的第 " + index + " 个位置");
		} else {
			System.out.println("您要查找的数不存在！");
		}
	}
}
