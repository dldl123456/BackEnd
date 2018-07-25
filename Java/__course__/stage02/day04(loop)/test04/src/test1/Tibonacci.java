/*
 *  ����10��쳲��������в�����������鲢��ӡ������1,1,2,3,5,8...��Ҫ�������������д����
 */

package test1;

public class Tibonacci {
	public static void main(String[] args) {
		//����10��쳲���������
		getFib(10);
	}
	
	//��װ쳲��������з���
	public static int getFib(int n){
		if(n < 0){
			return -1;
		}else if(n == 0){
			return 0;
		}else if(n==1 || n==2){
			return 1;
		}else{
			int[] fibAry = new int[n+1];  //����������Ľ�����������
			fibAry[0] = 0;
			fibAry[1] = fibAry[2] = 1;  //쳲���������ǰ����Ϊ1
			
			//�������쳲���������(��ʽ��F(n)=F(n-1)+F(n-2))
			for(int i=3; i<=n; i++){
				fibAry[i] = fibAry[i-1] + fibAry[i-2];
			}
			
			//�������飬��������쳲��������У����ö��Ÿ���
			System.out.print("쳲��������е�ǰ" + n + "��������ʾ��");
			for(int i=1; i<fibAry.length; i++){
				//ȥ������ĩβ���ַ�(����)
				if(i == fibAry.length-1){
					System.out.print(fibAry[i]);  //������������һλ��ֱ��������
				}else{
					System.out.print(fibAry[i] + ",");  //��������һλ�ö��Ÿ���
				}
			}
			
			//����n��ֵ
			return n;
		}
	}
}
