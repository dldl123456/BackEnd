/*
 * ��ASCII�任��Сд 
 */

package video.note.ascii;

import java.util.Scanner;

public class Ascii_2 {
	public static void main(String[] args){
		System.out.print("������һ��Сд��ĸ��");
		
		Scanner in = new Scanner(System.in);
		char ch = in.next().charAt(0);
		in.close();
	    
	    ch -= 32;	
	    
	    System.out.println("��Сд��ĸ�Ĵ�д�ǣ�" + ch);
	}
}