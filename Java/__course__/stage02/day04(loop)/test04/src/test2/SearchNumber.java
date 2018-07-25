/*
 * 有一个数组{2,4,5,6,1,10,12,7,1}，
 * 要求用户键盘上输入一个数，如果存在，打印出该数字出现的位置，
 * 如果不存在，打印-1，
 * 算法要求封装为方法
 */

package test2;

import java.util.Scanner;

public class SearchNumber {
	public static void main(String[] args) {
		int[] arr = {2,4,5,6,1,10,12,7,1};  //初始数组
		int num = 0;  //用来保存用户将要输入的数
		int index = 0;  //用来保存用户将要输入的数位于数组的下标
		
		System.out.print("请输入您要查询的数字：");
		
		//获取输入
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//根据子函数求出的结果给index赋值
		index = lineSearch(arr, num);
		
		//输出结果
	    if(index != -1){
			System.out.println("您查询的数字位于该数组的第" + index + "个位置");
		} else {
			System.out.println("该数组中没有您输入的数字，请重新输入！");
		}
	}
	
	//用线性查找法定位需要查找的数字
	public static int lineSearch(int[] arr, int num){
		int length = arr.length;  //用来保存数组的长度
		
		//从头遍历数组的各个值，如果找到目标值就返回其索引
		for(int i=0; i<length; i++){
			if(arr[i] == num){
				return i + 1;
			}
		}
		
		//如果查询不到结果，即目标值不存在于数组中，则返回-1
		return -1;
	}
	
}
