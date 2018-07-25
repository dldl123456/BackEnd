package video.note.YangHuiTriangle;

public class YangHuiTriangle {
	public static void main(String[] ages){
		int row = 8;	//行数
		int [][]p = new int[row][row];
		
		//赋值
		for(int i=0; i<row; i++){
			for(int j=0; j<=i; j++){
				//第一列和对角线列的元素值为1
				if(j==0||j==i){
					p[i][j] = 1;
				} else {
					//其他元素的值是其正上方和其左上方元素的和
					p[i][j] = p[i-1][j] + p[i-1][j-1];
				}
			}
		}
		
		//打印输出
		for(int i=0; i<row; i++){
			for(int j=0; j<=i; j++){
				System.out.print(p[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
