/*
 *  给定一个字符串数组，按照每个字符串的长度进行从小到大的排序
 *  { "abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye" }
 *  要求：使用匿名内部类创建比较器
 *  提示：使用Comparator接口和Arrays工具类
 */

package test1;

import java.util.Arrays;

public class ComparatorDemo {
	//程序入口，测试类
	public static void main (String[] args) {
        String[] strs = {"abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye"};  //一个初始字符串数组
        
        Arrays.sort(strs, new MyComparator());
        
        for (int i=0; i<strs.length; i++) {
        	if(i < strs.length-1){
        		System.out.print(strs[i] + ", ");
        	}else{
        		System.out.print(strs[i]);
        	}
        }
    }
}
