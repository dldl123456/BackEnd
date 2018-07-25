package common;
/**
 * 处理输入异常
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleInputMismatchException {
	public static Scanner input = new Scanner(System.in);
	/**
	 * int数据类型输入异常处理
	 * @param choose
	 * @return
	 */
	public static int handleInputMismatchException(int choose) {
		while(true) {
			try {
				choose = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("您输入的格式不正确，请重新输入:");
				 input = new Scanner(System.in);
			}
			break;
		}
		return choose;
	}
	//方法重载
	/**
	 * double数据类型输入异常处理
	 * @param choose
	 * @return
	 */
	public static double handleInputMismatchException(double num) {
		while(true) {
			try {
				num = input.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("您输入的格式不正确，请重新输入:");
				 input = new Scanner(System.in);
			}
			break;
		}
		return num;
	}
}
