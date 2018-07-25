/*
 *  输入一字符串，统计出现最多的字符，以及出现次数。 
 */

package demo.ease.charCount;

public class CharCount {
	public static void main(String[] args) {
		//定义的字符串
		String str="aaabbb";
		//分割成数组
		char[] c=str.toCharArray();
		//定义一个记住最大次数的变量
		int max=0;
		//定义一个保存出现最多次数的字符
		char cc = 0;
		//循环比较
		for(int i=0;i<c.length;i++){
			//定义一个中间值
			int is=0;
			
			for(int j=0;j<c.length-1;j++){
				//比较字符
				if(c[i]==c[j+1]){
					is++;
				}
				//比较出现次数大的输出
				if(is>max){
					max=is;
					cc=c[i];
				}
			}
			
		}
		//打印
		System.out.println("出现次数最多的是"+cc+",出现"+max+"次");
	}
}
