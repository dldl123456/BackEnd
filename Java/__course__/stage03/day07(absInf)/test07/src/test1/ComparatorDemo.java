/*
 *  ����һ���ַ������飬����ÿ���ַ����ĳ��Ƚ��д�С���������
 *  { "abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye" }
 *  Ҫ��ʹ�������ڲ��ഴ���Ƚ���
 *  ��ʾ��ʹ��Comparator�ӿں�Arrays������
 */

package test1;

import java.util.Arrays;

public class ComparatorDemo {
	//������ڣ�������
	public static void main (String[] args) {
        String[] strs = {"abc", "yb", "xiaoqianga", "laifu", "wangcai", "oye"};  //һ����ʼ�ַ�������
        
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
