package day1113;

public class Demo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=1;
//		int sum=num++;//�Ȱ�num��ֵ��ֵ��sum��Ȼ��������
//		System.out.println(num++);//num=1
//		System.out.println("sum:"+sum+"----num:"+num);//num=2
		int sum=++num;//����������Ȼ��ѽ����ֵ��sum
		System.out.println("sum:"+sum+"----num:"+num);
		num--;
		num--;
		num--;
		System.out.println(num);
	}

}
