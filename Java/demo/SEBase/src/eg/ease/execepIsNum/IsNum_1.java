package eg.ease.execepIsNum;

import java.util.Scanner;

public class IsNum_1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入x：");
        String x;
        do {
            try {
 
                x = sc.nextLine();
                if (Integer.valueOf(x) instanceof Integer) {
                    System.out.println("输入为整数,程序结束.");
                    sc.close();
                    break;
                } else {
                    x = sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println("请输入整数.");
            }
        } while (true);
    }
	
}
