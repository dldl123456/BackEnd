package video.note.YangHuiTriangle;

public class YangHuiTriangle {
	public static void main(String[] ages){
		int row = 8;	//����
		int [][]p = new int[row][row];
		
		//��ֵ
		for(int i=0; i<row; i++){
			for(int j=0; j<=i; j++){
				//��һ�кͶԽ����е�Ԫ��ֵΪ1
				if(j==0||j==i){
					p[i][j] = 1;
				} else {
					//����Ԫ�ص�ֵ�������Ϸ��������Ϸ�Ԫ�صĺ�
					p[i][j] = p[i-1][j] + p[i-1][j-1];
				}
			}
		}
		
		//��ӡ���
		for(int i=0; i<row; i++){
			for(int j=0; j<=i; j++){
				System.out.print(p[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
