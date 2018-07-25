package help;
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
				break;
			} catch (InputMismatchException e) {
				System.out.println("给你脸了是不，让你输数字，咋就那么不听话呢，重新输，输数字:");
				 input = new Scanner(System.in);
			}
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
				System.out.println("给你脸了是不，让你输小数，咋就那么不听话呢，重新输，输小数:");
				 input = new Scanner(System.in);
			}
			break;
		}
		return num;
	}
}
