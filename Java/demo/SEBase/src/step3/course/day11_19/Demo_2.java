/*
 *  根据用户需求修改数组中某一个元素（哪个元素，修改成什么）
 *  用户输入哪个元素去查下标，然后修改
 */

package step3.course.day11_19;

import java.util.Scanner;

public class Demo_2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int[] arr = {10,20,30};  //初始数组
		int index = -1;  //用来保存数组的下标
		int num = 0;  //用来保存用户输入的数
		
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
		
		System.out.print("请输入您要修改的数：");
		
		//修改数组
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		
		//用户输入的数是否在数组里存在，如果不存在那就要告诉用户，如果存在那就要记录这个元素的下标
		for(int i=0; i<arr.length; i++){
			if(num == arr[i]){
				index = i;
				System.out.println("该数在数组中第" + (index+1) + "个位置\n");
				break;
			}
		}
		
		//根据index中的值判断是否存在
		if(index == -1){
			System.out.println("没有该数！");
			return;
		}
		
		//数字
		System.out.print("请输入修改后的数字：");
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
