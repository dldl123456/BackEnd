package eg.degin.factorial;

import java.util.Scanner;

public class Factorial {
	@SuppressWarnings("resource")
	public static void main(String[] arg) {  
        Scanner scanner = new Scanner(System.in);  
        int n = scanner.nextInt();  
        System.out.println(factorial(n));  
    }  
    /** 
     * ʹ�õݹ鷽������n�Ľ׳� 
     *  
     * @param n 
     * @return 
     */  
    private static long factorial(int n) {  
        if (n == 0) {  
            System.out.println(n + "! = " + 1);  
            return 1;  
        } else {  
            long num = n * factorial(n - 1);  
            System.out.println(n + "! = " + num);  
            return num;  
        }  
    }  
  
    /** 
     * ʹ��ѭ����ʽ����n�Ľ׳� 
     *  
     * @param n 
     * @return 
     */  
    @SuppressWarnings("unused")
	private long test(int n) {  
        long num = 1;  
        for (int i = 1; i <= n; i++) {  
            num *= i;  
        }  
        return num;  
    }  
}
