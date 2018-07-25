package step3.course.day11_23;

public class Demo_2 {
	public static void main(String[] args) {
		String a=" hello world ";  
		  
        String b="hello world";  
  
        System.out.println(b.equals(a));  
  
        a=a.trim();//去掉字符串首尾的空格  
  
        System.out.println(a.equals(b)); 
	}
}
