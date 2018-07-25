/*
 *  根据用户需求修改数组中某一个元素（哪个元素，修改成什么）
 *  2、用户输入下标修改
 */

package step3.course.day11_19;

import java.util.Scanner;

public class Demo_1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};  //初始数组
		int index = 0;  //用来保存数组的下标
		
		//输出初始数组
		System.out.print("初始数组为：");
		for(int i=0; i<arr.length; i++){
			if(i != arr.length-1){
				System.out.print(arr[i] + ",");
			}else{
				System.out.print(arr[i]);
			}
		}
		
		System.out.println("\n");
		
		//修改数组
		Scanner in = new Scanner(System.in);
		
		//下标
		System.out.print("请输入要修改的数组的下标：");
		index = in.nextInt();
		
		//数字
		System.out.print("请输入要修改的数：");
		arr[index] = in.nextInt();
		
		in.close();
		
		//遍历,输出修改后的数组
		System.out.print("修改后的数组为：");
		for(int i=0; i<arr.length; i++){
			if(i != arr.length-1){
				System.out.print(arr[i] + ",");
			}else{
				System.out.print(arr[i]);
			}
		}
	}
}
