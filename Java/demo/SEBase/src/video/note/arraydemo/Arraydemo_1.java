package video.note.arraydemo;

import java.util.Scanner;

public class Arraydemo_1 {
	public static void main(String[] args) {
		//先声明后创建
		/*int[] array; 
		array = new int[3];*/
		
		//直接创建（[]也可以放array后面，但一般不建议）
		/*int[] array = new int[3];*/
		
		//对数组中的原生进行赋值(下标)
		/*array[0] = 1;
		array[2] = 3;*/
		
		//对数组中的原生进行赋值(循环)
		/*for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}*/
		
		//静态初始化
		// int[] array = {10,20,30};	//在堆内存里存入3个整型
		// int[] array = new int[]{10,20,30};
		
		//动态初始化
		int[] array = new int[3];
		Scanner in = new Scanner(System.in);
		in.close();
		for(int i=0; i<array.length; i++){
			array[i] = in.nextInt();
			System.out.print(array[i] + " ");
		}
		
		/*System.out.println(array.length);
		System.out.println(array[0]);*/
	}
}
