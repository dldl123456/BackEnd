/*
 *  �����������100��16���������������֣���ôȥʵ����16������ÿ����������
 */

package demo.ease.wrap;

public class Wrap {
	public static void main(String[] args){
       int i,j=0;
       for(i=1;i<=100;i++){
           if(i%6==0){
        	   System.out.print(i+"\t");
        	   j++;
        	   if(j%3==0){   //����ܱ��������ͻ���
					System.out.println();
			   }
           }
       }
       System.out.println();  
       System.out.println("��"+j+"������");
	}
}
