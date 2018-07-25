package student;

import java.util.Scanner;

public class Test {
	/*
	 * 数组扩容
	 */
	 int[] a={2,9,13,28,30,45,58,60};  
	   
	    public  void insert(int m){  
	        int[] b=new int[a.length +1];  
	        for(int i=0;i<a.length;i++){  
	            b[i]=a[i];  
	        }  
	        for(int i=0;i<b.length-1;i++){  
	            if(m>b[a.length-1]){  
	                b[b.length-1]=m;  
	            }  
	            if((b[i]<m) && (b[i+1]>=m)){  
	                  
	                for(int j=i;j<b.length-1;j++){  
	                    b[j+1]=a[j];  
	                }  
	                b[i+1]=m;  
	                break;  
	            }  
	        }  
	          for(int i=0;i<b.length;i++){  
	               System.out.print(b[i]+"  ");  
	            }  
	    }  
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        Test p=new Test();  
	        Scanner sc=new Scanner(System.in);  
	        System.out.print("请输入要插入的数：");  
	        int c=sc.nextInt();  
	        p.insert(c);  
	        sc.close();  
	    }  
}
