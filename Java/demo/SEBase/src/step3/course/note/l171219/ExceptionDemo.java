package step3.course.note.l171219;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ExceptionDemo {

	public static void main(String[] args) {
		
		//����
//		main(args);
		
		//��ָ��
		/*String str = null;
		System.out.println(str.length());*/
		
		//�������ʹ���
		/*Scanner scanner = new Scanner(System.in);
		scanner.nextInt();*/
		
		//�����±�Խ�� ArrayIndexOutOfBoundsException
		/*int[] nums = {1,2};
		System.out.println(nums[3]);*/
		
		//��ѧ�쳣
		/*System.out.println(5/0);*/
		
		//����ת���쳣
		/*Object anObject = new String("123");
		System.out.println((Integer)anObject);*/
		
		
		//���ָ�ʽ��
		try{
			System.out.println(Integer.parseInt("sdf"));
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("������������������");
		}catch(NumberFormatException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("������������������");
			System.exit(0);//��ֹ����
			//return;
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("������������������");
		}finally{
			System.out.println("finally..........");
		}
		
		System.out.println("test...........");
		
	}
}
