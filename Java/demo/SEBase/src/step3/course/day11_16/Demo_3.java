/*
 *  Êä³ö   
 *    *
 *   * *
 *  * * *
 *  
 */

package step3.course.day11_16;

public class Demo_3 {
	public static void main(String[] args) {
		for(int i=1; i<4; i++){
			//¿Õ¸ñ
			for(int j=3-i; j>0; j--){
				System.out.print(" ");
			}
			//*ºÅ
			for(int j=0; j<i; j++){
				System.out.print("* ");
			}
			//»»ÐÐ
			System.out.println();
		}
	}
}
