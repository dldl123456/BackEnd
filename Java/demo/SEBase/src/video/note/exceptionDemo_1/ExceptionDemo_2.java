/*
 *  throw,throws
 *  通过throw可以在方法里的任意位置抛出异常
 *  受查异常（必须捕获，否则不能编译），非受查异常（可以编译）
 */

package video.note.exceptionDemo_1;

public class ExceptionDemo_2 {
	public static void main(String[] args) {
		//静态调用非静态，首先产生一个对象
		Bar bar = new Bar();
		/*bar.enter(15);  //如果抛出异常，程序在此中断
		System.out.println("end");*/
		
		//让程序不中断
		try{
			bar.enter(15);
		}catch(Exception e){
			System.out.println("错误信息：" + e.getMessage());
		}
		
		/*catch(IllegalArgumentException e){
			//e.getMessage()表示错误信息的字符串描述
			System.out.println("错误信息：" + e.getMessage());
		}*/
		System.out.println("end");
	}
}

class Bar{
	public void enter(int age) throws /*IllegalArgumentException*/ Exception {  //告诉使用者，我可能会抛出这个异常，告诉他应该要捕获一下这个异常
		//当手动抛出的是受查异常（比如Exception）的时候必须加throws
		//或者自己捕获（无意义）
		if(age<18){
			//这个异常可以是Exception里的子异常对象
			//抛出一个子异常(new)
			//非受查异常，可以不做处理，直接交给系统，让系统自动检测，并将他们交给缺省的异常处理程序来进行处理
			//throw new IllegalArgumentException("年龄不合格");  //非法参数异常
			throw new Exception("年龄不合格");  //Exception是受查异常，必须捕获
		}else{
			System.out.println("欢迎光临");
		}
	}
}