
public class Demo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//基本数据类型的比较
		int a=3,b=1;
		System.out.println(a==b);
		//引用类型的比较
		String arr1= new String("abc");
		String arr2= new String("abc");
		System.out.println(arr1==arr2);//引用数据类型的比较不是这么比较滴
		System.out.println(arr1.equals(arr2));
		String str1="abc";//指针对String
		String str2="abc";
		System.out.println(str1==str2);
	}

}
