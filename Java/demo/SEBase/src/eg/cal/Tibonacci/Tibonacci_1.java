/*
 *  ��д�����ڿ���̨���쳲���������ǰ20�ÿ���5��������
 */

package eg.cal.Tibonacci;

public class Tibonacci_1 {
	// ����������������  
    public static void main(String[] args) {  
        int a = 1, b = 1, c = 0;  
        System.out.println("쳲���������ǰ20��Ϊ��");  
        System.out.print(a + "\t" + b + "\t");  
        //��Ϊǰ�滹������1��1 ����i<=18  
        for (int i = 1; i <= 18; i++) {  
            c = a + b;  
            a = b;  
            b = c;  
            System.out.print(c + "\t");  
            if ((i + 2) % 5 == 0)  
                System.out.println();  
        }  
    }  
}
