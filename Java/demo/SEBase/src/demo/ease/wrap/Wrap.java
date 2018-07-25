/*
 *  例如下面程序100有16个被三整除的数字，怎么去实现这16个数字每隔三个换行
 */

package demo.ease.wrap;

public class Wrap {
	public static void main(String[] args){
       int i,j=0;
       for(i=1;i<=100;i++){
           if(i%6==0){
        	   System.out.print(i+"\t");
        	   j++;
        	   if(j%3==0){   //如果能被三整除就换行
					System.out.println();
			   }
           }
       }
       System.out.println();  
       System.out.println("有"+j+"个数字");
	}
}
