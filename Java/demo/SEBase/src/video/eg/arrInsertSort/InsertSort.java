/*  插入排序：
 *  对数组进行从小到大排序
 */

package video.eg.arrInsertSort;

public class InsertSort {
	public static void main(String[] args) {
		int[] array = {1,5,3,6,2,9,13,54,20};
		
		for(int i=1; i<array.length; i++){
			int temp = array[i];
			//把小标保存起来
			int j = i;
			while(j>0&&temp<array[j-1]){
				//上面的数覆盖其下面的数
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;  //插入数据
		}
		
		//输出
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
