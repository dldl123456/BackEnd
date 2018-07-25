/*
 *  对数组中的元素删除（要删除的元素赋值该数据类型的默认值），
 *  然后再遍历输出非默认值的元素
 */

package step3.course.day11_20;

import java.util.Scanner;

public class Demo_1 {
	public static void main(String[] args) {
		int arr[] = {1,4,6,9,13,16,19,28,40,100};
		int number, i, j,
			index = -1;
		
		System.out.println("原始数组为:");
		for(i=0;i<10;i++){  
			System.out.print(arr[i] + "\t");  
		}
		System.out.println("\n");
		
		Scanner in = new Scanner(System.in);  
		System.out.print("输入要删除的数:");  
		number = in.nextInt();
		in.close();
		
		for (i=0;i<10;i++){  
			if (arr[i]==number){
		    	index=i;
		    	break;  
		    }  
		}
		
		if (index==-1) {
			System.out.println("没有该数,index:"+index);
			return;
		}
		
		arr[index]=0;
		
		for (j = 0; j< arr.length; j++) {
			if (arr[j]!=0) {
				 System.out.print(arr[j]+"\t");
			} 
		}
	}
}
