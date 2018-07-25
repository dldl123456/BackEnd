package day1113;

public class Demo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=1;
//		int sum=num++;//先把num中值赋值给sum，然后做自增
//		System.out.println(num++);//num=1
//		System.out.println("sum:"+sum+"----num:"+num);//num=2
		int sum=++num;//先做自增，然后把结果赋值给sum
		System.out.println("sum:"+sum+"----num:"+num);
		num--;
		num--;
		num--;
		System.out.println(num);
	}

}
