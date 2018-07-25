package common;
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
			} catch (InputMismatchException e) {
				System.out.println("������ĸ�ʽ����ȷ������������:");
				 input = new Scanner(System.in);
			}
			break;
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
				System.out.println("������ĸ�ʽ����ȷ������������:");
				 input = new Scanner(System.in);
			}
			break;
		}
		return num;
	}
}
