/*
 *  产生10个斐波那契数列并将其存入数组并打印出来：1,1,2,3,5,8...，要求存入和输出单独写方法
 */

package test1;

public class Tibonacci {
	public static void main(String[] args) {
		//产生10个斐波那契数列
		getFib(10);
	}
	
	//封装斐波那契数列方法
	public static int getFib(int n){
		if(n < 0){
			return -1;
		}else if(n == 0){
			return 0;
		}else if(n==1 || n==2){
			return 1;
		}else{
			int[] fibAry = new int[n+1];  //用来将求出的结果存入此数组
			fibAry[0] = 0;
			fibAry[1] = fibAry[2] = 1;  //斐波那契数列前两项为1
			
			//计算求出斐波那契数列(公式：F(n)=F(n-1)+F(n-2))
			for(int i=3; i<=n; i++){
				fibAry[i] = fibAry[i-1] + fibAry[i-2];
			}
			
			//遍历数组，输出求出的斐波那契数列，并用逗号隔开
			System.out.print("斐波那契数列的前" + n + "项如下所示：");
			for(int i=1; i<fibAry.length; i++){
				//去除数组末尾的字符(逗号)
				if(i == fibAry.length-1){
					System.out.print(fibAry[i]);  //如果是数组最后一位，直接输出结果
				}else{
					System.out.print(fibAry[i] + ",");  //数组非最后一位用逗号隔开
				}
			}
			
			//返回n的值
			return n;
		}
	}
}
