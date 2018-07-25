/*
 *  用Arrays类sort()对数组元素进行升序降序排列
 */

package demo.arr.ArraysClassDemo;

import java.util.Arrays;

public class ArraysClassDemo {
	public static void main(String[] args) {
		 int[] vec={0,15,-14,45,20,70};  
		 Arrays.sort(vec);
		 
		 System.out.println("升序排列：");
		 for (int i=0;i<vec.length ;i++){   
			 System.out.print(vec[i]+" ");   
		 }
		 System.out.println("\n");
		 
		 System.out.println("降序排列：");
		 for (int i=vec.length-1;i>=0 ;i--){   
			 System.out.print(vec[i]+" ");   
		 }
	}
}
