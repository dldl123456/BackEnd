/*
 *  递归求阶乘
 */

package video.note.FactorialDemo;

public class FactorialDemo {
	public static void main(String[] args) {
		System.out.println(FacUtil.getFac(5));
	}
}

//工具类
class FacUtil{
	//提供一个公开的静态方法供外部调用
	public static int getFac(int number){
		if(number==1){
			return 1;
		}else{
			//n*(n-1)!
			return number*getFac(number-1);
		}
	}
}