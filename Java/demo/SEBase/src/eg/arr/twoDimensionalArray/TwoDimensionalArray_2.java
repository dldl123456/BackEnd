/*
 *  ��ά����
 */

package eg.arr.twoDimensionalArray;

public class TwoDimensionalArray_2 {
	public static void main(String[] args) {
		int[][] array = new int[3][];
		//ÿ����ά�����飨һά���飩ָ��һ����ά��int����
		array[0] = new int[2];
		array[1] = new int[3];
		array[2] = new int[4];
		
		//����ά��������и�ֵ
		array[0][0] = 1;
		array[0][1] = 2;
		
		array[1][0] = 3;
		array[1][1] = 4;
		array[1][2] = 5;
		
		array[2][0] = 6;
		array[2][1] = 7;
		array[2][2] = 8;
		array[2][3] = 9;
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if((i==array.length-1)&&(j==array[i].length-1)){
					System.out.print(array[i][j]);
				}else{
					System.out.print(array[i][j] + ",");
				}
			}
		}
	}
}
