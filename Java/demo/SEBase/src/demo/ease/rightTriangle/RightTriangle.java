package demo.ease.rightTriangle;

import java.util.Scanner;

public class RightTriangle {
	public static void main(String args[]){
		System.out.println("����������");
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		in.close();
		
        System. out.println( "���"+ a +"���Ǻ�" ); 
        
        // ���ѭ����������
		for(int i=1; i<=a; i++){
			// �ڲ�ѭ������ÿ�е�*����
            // �ڲ�ѭ�����������ֵ�����ѭ��������ֵ���
			for ( int j = 1; j <= i ; j ++ ){
				System. out.print( "*" );
			}
			// ÿ��ӡ��һ�к���л���
            System. out.println();
		}
	}
}
