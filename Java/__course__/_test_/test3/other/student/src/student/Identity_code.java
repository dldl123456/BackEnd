package student;


	import java.util.Random;
	import java.util.Scanner;

	public class Identity_code {
	    
		//验证码功能
		public static void IdentityCode() {
			 String a="1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
		        Random i=new Random();
		        int[] array=new int[4];
		        for(int j=0;j<4;j++)
		        {
		            array[j]=i.nextInt(62);
		            System.out.print(a.charAt(array[j])+" ");
		        }
		        System.out.println("请输入上图验证码，注意大小写：");
		        Scanner c=new Scanner(System.in);
		        String d=c.next();
		        char[] e={a.charAt(array[0]),a.charAt(array[1]),a.charAt(array[2]),a.charAt(array[3])};
		        String f=new String(e);//强制转换相同类型，方便比较
		        boolean g=d.equals(f);
		        if(g==true)
		        {
		            System.out.println("输入正确");
		           
		         }else {
					System.out.println("输入错误");
				}
		       
		        
		}
		public static void main(String[] args) {
			Identity_code.IdentityCode();
	       
	    }
	}

	
