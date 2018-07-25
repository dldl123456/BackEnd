package test1_fix;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		String[] strs = {"abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye"};  //一个初始字符串数组
		
		Arrays.sort(strs, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for(String str : strs){
			System.out.println(str);
		}
	}
}
