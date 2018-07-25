package step3.course.note.l171219;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ExceptionDemo {

	public static void main(String[] args) {
		
		//错误
//		main(args);
		
		//空指针
		/*String str = null;
		System.out.println(str.length());*/
		
		//输入类型错误
		/*Scanner scanner = new Scanner(System.in);
		scanner.nextInt();*/
		
		//数组下标越界 ArrayIndexOutOfBoundsException
		/*int[] nums = {1,2};
		System.out.println(nums[3]);*/
		
		//数学异常
		/*System.out.println(5/0);*/
		
		//类型转换异常
		/*Object anObject = new String("123");
		System.out.println((Integer)anObject);*/
		
		
		//数字格式化
		try{
			System.out.println(Integer.parseInt("sdf"));
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("出错啦。。。。。。");
		}catch(NumberFormatException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("出错啦。。。。。。");
			System.exit(0);//终止程序
			//return;
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("出错啦。。。。。。");
		}finally{
			System.out.println("finally..........");
		}
		
		System.out.println("test...........");
		
	}
}
