/*
 *  产生10个斐波那契数列并将其存入数组并打印出来：1,1,2,3,5,8...，要求存入和输出单独写方法
 */

package eg.cal.Tibonacci;

public class Tibonacci_4 {
	public static void main(String[] args) {
		int[] res = new int[10];  //用来将求出的结果存入此数组
		
		res[0] = res[1] = 1;  //斐波那契数列前两项值
		
		//求出第三到10项的斐波那契数列值
		for (int i = 2; i < res.length; i++) {  
			res[i] = res[i - 1] + res[i - 2];  
        }
		
		//遍历数组并输出，用逗号隔开
        System.out.print("斐波那契数列的前10项如下所示：");  
        for (int i = 0; i < res.length; i++) {
        	if(i == res.length-1){
        		System.out.print(res[i]);
        	}else{
        		System.out.print(res[i] + ","); 
        	}
        }
	}
}
