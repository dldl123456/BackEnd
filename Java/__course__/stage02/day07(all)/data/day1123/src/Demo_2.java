
public class Demo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����������͵ıȽ�
		int a=3,b=1;
		System.out.println(a==b);
		//�������͵ıȽ�
		String arr1= new String("abc");
		String arr2= new String("abc");
		System.out.println(arr1==arr2);//�����������͵ıȽϲ�����ô�Ƚϵ�
		System.out.println(arr1.equals(arr2));
		String str1="abc";//ָ���String
		String str2="abc";
		System.out.println(str1==str2);
	}

}
