package com.zhizuobiao.demo;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[4];// new后面的[]里数字不写
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };// 声明数组并给每个元素赋初始值
		System.out.println("arr2的长度：" + arr2.length);
		int[] arr3 = new int[] { 1, 2, 3, 4, 5, 6 };//由于后面括号里已经有详细的元素个数所以不用写长度
		int[] arr4=null;//声明数组，没有开辟空间
		arr4=arr2;//赋值是赋的什么？赋给arr4是引用地址，并不是实际的数据
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
	}

}
