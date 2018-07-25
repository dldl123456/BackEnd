package step3.course.course.day11_13;

import java.util.Scanner;

public class Demo_3 {
	public static void main(String[] args) {
		int day = 0;
		Scanner in = new Scanner(System.in);
		day = in.nextInt();
		in.close();
		
		String does;
		switch(day){
			case 1:
				does = "上课";
				break;
			case 2:
				does = "上课";
				break;
			case 3:
				does = "上课";
				break;
			case 4:
				does = "上课";
				break;
			case 5:
				does = "上课";
				break;
			case 6:
				does = "上课";
				break;
			case 7:
				does = "上课";
				break;
			default:
				does = "上课";
		}
		
		System.out.println(does);
	}
}
