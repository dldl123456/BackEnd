/*
 *  定义三个字符串，并随机输出其中一个,
 *  随机n次，存入数组，并判断输出其中出现次数最多的字符串
 */

package demo.ease.randomStr;

import java.util.Scanner;

public class RandomStr_1 {
	//判断字符串数组中出现次数最多的元素
	public static String majorityElement(String[] arr){
		int i; //循环的参数
    	int count = 0;  //统计次数
    	String temp = null;  //用来保存返回的结果
        
    	for(i=0; i<arr.length; i++){
        		if(count == 0){
            		temp = arr[i];
            			count++;
        		}else{
            		if(temp == arr[i]){
            			count++;
            		}else{
            			count--;
            		} 
        		}
    	}
		return temp;
	}
	
	public static void main(String[] args) {
		//定义变量
		int num,i;  //用来保存随机数和循环参数
		String str = null;  //用来保存三个字符串
		int n = 0;  //用来保存你所需要循环的次数
		//提示
		System.out.print("请输入您所需要产生随机名字的个数：");
		
		//获取输入
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		//换行
		System.out.println();
		
		//定义数组，并给他指定容量
		String[] arr = new String[n];
		
		//开始循环并获取n次随机字符串
		for(i=0; i<n; i++){
			num = (int)(Math.random()*3+1);  //取随机数1-3
			
			switch(num){
				case 1:
					str = "巧巧";
					break;
				case 2:
					str = "小哇";
					break;
				case 3:
					str = "巧林";
					break;
			}
			
			if(i == n-1){
				System.out.print(str + "\n\n");
			}else{
				System.out.print(str + ",");
			}
			
			//将得到的字符串分别存入数组
			arr[i] = str;
		}
		
		//输出字符串数组中出现最多的字符串
		System.out.println("\"" + majorityElement(arr) + "\"这个名字出现次数最多\n以后你的名字就叫\"" + majorityElement(arr) + "\"啦，哈哈哈 !^_^");
	}
}
