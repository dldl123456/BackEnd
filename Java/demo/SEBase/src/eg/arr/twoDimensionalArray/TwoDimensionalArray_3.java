/*
 *  ถþฮฌสýื้
 */

package eg.arr.twoDimensionalArray;

public class TwoDimensionalArray_3 {
	public static void main(String[] args) {
		int arr[][] = { { 4, 3, 7 }, { 1, 5, 5 } };
		String total="";
		for (int i = 0; i <2; i++) {
			for (int j = 0; j < 3; j++) {
				total+=arr[i][j]+",";
			}
		}
		System.out.println(total.substring(0,total.length()-1));
	}
}
