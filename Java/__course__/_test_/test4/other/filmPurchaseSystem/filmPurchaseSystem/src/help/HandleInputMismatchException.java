package help;
/**
 * ���������쳣
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleInputMismatchException {
	public static Scanner input = new Scanner(System.in);
	/**
	 * int�������������쳣����
	 * @param choose
	 * @return
	 */
	public static int handleInputMismatchException(int choose) {
		while(true) {
			try {
				choose = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("���������ǲ������������֣�զ����ô�������أ������䣬������:");
				 input = new Scanner(System.in);
			}
		}
		return choose;
	}
	//��������
	/**
	 * double�������������쳣����
	 * @param choose
	 * @return
	 */
	public static double handleInputMismatchException(double num) {
		while(true) {
			try {
				num = input.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("���������ǲ���������С����զ����ô�������أ������䣬��С��:");
				 input = new Scanner(System.in);
			}
			break;
		}
		return num;
	}
}
