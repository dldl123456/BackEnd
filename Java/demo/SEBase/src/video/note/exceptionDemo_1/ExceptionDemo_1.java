/*
 *  异常
 *  都继承了RuntimeException(运行时异常)
 *  Exception(父类) -->  RuntimeException(子类)  -->  ArithmeticException(lang),InputMismatchException(util)....
 *  在lang包中不用导包
 */

package video.note.exceptionDemo_1;

import java.util.Scanner;
import java.util.InputMismatchException;

//主方法，测试类
public class ExceptionDemo_1 {
	public static void main(String[] args) {
		//静态方法直接调用静态方法
		testTryFinally(null);  //空指针异常，表示没有产生对象，但你去调用对象的相关方法和属性了的时候
		
		int res = 0;
		int num = 0;
		
		System.out.print("请输入一个数字：");
		
		Scanner in = new Scanner(System.in);
		
		//因为这段程序可能出现异常，所以用try来监测这块代码
		try{
			//return;  //finally还是输出
			//System.exit(0);  //程序立即结束，finally不会输出
			
			num = in.nextInt();  //可能异常（如果不是输入整型）InputMismatchException
			res = 10/num;  //数学异常(ArithmeticException)，分母不能为0
		}catch(InputMismatchException e){  //一般把已知的异常放上面，最后跟上异常父类，以防止有其他异常
			System.out.println(e.getMessage());  //打印错误信息
			// e.printStackTrace();  //跟踪打印堆栈里面的错误信息
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}catch(Exception e){  //不能放最上面，否则其他抛出异常子类无法执行
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{  //可以不加，不管是否有异常，都会执行
			//主要用来释放资源，比如关闭打开的文件，删除一些临时文件……
			in.close();
			System.out.println("aa");
		}
		
		
		/*catch(Exception e){  //捕获不具体的异常类型,因为Exception是RuntimeException的父类（父类的引用变量可以引用子类的对象）
			//所以父类的引用变量都可以接收所有子类抛出的对象
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
		
		
		//这是具体的异常类型
		/*catch(InputMismatchException e){  //一旦这个程序出现了异常，交给catch这个异常类进行处理,参数是异常类的类型
			System.out.println(e.getMessage());  //打印错误信息
			e.printStackTrace();  //跟踪打印堆栈里面的错误信息
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
		
		System.out.println("10/" + num + "=" + res);
	}
	
	//如果不是静态的要创建对象才能调用方法（静态[主方法]调用非静态方法）
	//如果是静态的可以直接调用，静态方法调用静态方法
	//try可以直接和finally使用
	//功能执行，但抛出的异常不想捕获，交给调用这个方法的人去捕获，结构实现职责分离
	//实现了异常处理与异常清理的解耦，让不同的方法专注于自己应该做的事情
	public static void testTryFinally(String name){
		try{
			System.out.println(name.length());
		}finally{
			System.out.println("end");
		}
	}
}
