/*
 *  ����10��쳲��������в�����������鲢��ӡ������1,1,2,3,5,8...��Ҫ�������������д����
 */

package eg.cal.Tibonacci;

public class Tibonacci_4 {
	public static void main(String[] args) {
		int[] res = new int[10];  //����������Ľ�����������
		
		res[0] = res[1] = 1;  //쳲���������ǰ����ֵ
		
		//���������10���쳲���������ֵ
		for (int i = 2; i < res.length; i++) {  
			res[i] = res[i - 1] + res[i - 2];  
        }
		
		//�������鲢������ö��Ÿ���
        System.out.print("쳲��������е�ǰ10��������ʾ��");  
        for (int i = 0; i < res.length; i++) {
        	if(i == res.length-1){
        		System.out.print(res[i]);
        	}else{
        		System.out.print(res[i] + ","); 
        	}
        }
	}
}
