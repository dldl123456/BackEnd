/*** 
 * @author Ҷ���� 
 * @��������һ���˻�������ȭС��Ϸ 
 */  

package project.MorraGame_2;

import java.util.InputMismatchException;  
import java.util.Scanner; 

public class PlayGame {
	public static void main(String[] args){  
        int juese;  
        int i;//i��ʾ��ҳ�ȭ������  
        Game g=new Game();  
        g.init();  
        System.out.print("************************************\n");  
        System.out.print("**         ��ӭ�����ȭ��Ϸ                 ***\n");  
        System.out.print("************************************\n");  
        System.out.println("��ȭ����1.����  2.ʯͷ  3.��\n");  
        System.out.println("��ѡ���ɫ��1.����  2.��Ȩ  3.�ܲ�");  
        Scanner input=new Scanner(System.in);  
        try{  
        juese=input.nextInt();  
        while(juese!=1&&juese!=2&&juese!=3){//�������ݱ�����һ��1~3��������������������  
            System.out.println("���������Ӧ����һ��1~3�����������������룡");  
            juese=input.nextInt();  
        }  
        g.computerPlayer(juese);  
        System.out.println("����������������");  
        g.user(input.next());  
        System.out.println("��ȭ��������0�˳���");  
        i=input.nextInt();  
        while(i!=0){//���û�������0��ִ��ѭ���壬һֱ����Ϸ  
            g.chuquan(i);  
            g.jisuan();  
            System.out.println("\n��ȭ��������0�˳���");  
            i=input.nextInt();  
        }  
        System.out.println("��Ϸ������");  
        g.result();  
        }catch(InputMismatchException e){  
            System.out.println("�������г�������Ƿ��ַ���");  
        }finally{  
            System.out.println("\nллʹ�ã�");  
        }  
        input.close();  
    }  
}
