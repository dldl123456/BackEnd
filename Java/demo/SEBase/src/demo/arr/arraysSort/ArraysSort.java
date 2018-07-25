package demo.arr.arraysSort;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args){
	       int[] scores = {78,93,97,84,63};
	       
	       System. out.println( "遍历数组中的值" );
	       
	       for( int i=0 ; i< scores. length ; i++){
	    	   System. out.print( scores[ i]+ " ");
	       }
	       Arrays. sort(scores);
	       
	       System. out.println( "\n\r排序后数组元素中的值" );
	       
	       for( int i=0 ; i< scores. length ; i++){
	    	   System. out.println( scores[ i]);
	       }
	       
	       System. out.println( "\n改成字符串输出：" );
	       
	       System. out.println(Arrays. toString(scores));
		}
}
