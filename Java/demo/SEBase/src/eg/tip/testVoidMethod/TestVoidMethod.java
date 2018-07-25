/*
 *  本节说明如何声明和调用一个 void 方法。
 *  下面的例子声明了一个名为 printGrade 的方法，并且调用它来打印给定的分数。
 */

package eg.tip.testVoidMethod;

public class TestVoidMethod {
	public static void main(String[] args) {
		//调用printGrade方法
		printGrade(78.5);
	}
	
	public static void printGrade(double score){
		//判断
		//这里printGrade方法是一个void类型方法，它不返回值。
		//一个void方法的调用一定是一个语句。 所以，它被在main方法第三行以语句形式调用。就像任何以分号结束的语句一样。
		if(score >= 90){
			System.out.println("A");
		}else if(score >= 80.0){
			System.out.println("B");
		}else if(score >= 70.0){
			System.out.println("C");
		}else if(score >= 60.0){
			System.out.println("D");
		}else{
			System.out.println("F");
		}
	}
}
