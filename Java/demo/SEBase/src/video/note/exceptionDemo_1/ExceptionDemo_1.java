/*
 *  �쳣
 *  ���̳���RuntimeException(����ʱ�쳣)
 *  Exception(����) -->  RuntimeException(����)  -->  ArithmeticException(lang),InputMismatchException(util)....
 *  ��lang���в��õ���
 */

package video.note.exceptionDemo_1;

import java.util.Scanner;
import java.util.InputMismatchException;

//��������������
public class ExceptionDemo_1 {
	public static void main(String[] args) {
		//��̬����ֱ�ӵ��þ�̬����
		testTryFinally(null);  //��ָ���쳣����ʾû�в������󣬵���ȥ���ö������ط����������˵�ʱ��
		
		int res = 0;
		int num = 0;
		
		System.out.print("������һ�����֣�");
		
		Scanner in = new Scanner(System.in);
		
		//��Ϊ��γ�����ܳ����쳣��������try�����������
		try{
			//return;  //finally�������
			//System.exit(0);  //��������������finally�������
			
			num = in.nextInt();  //�����쳣����������������ͣ�InputMismatchException
			res = 10/num;  //��ѧ�쳣(ArithmeticException)����ĸ����Ϊ0
		}catch(InputMismatchException e){  //һ�����֪���쳣�����棬�������쳣���࣬�Է�ֹ�������쳣
			System.out.println(e.getMessage());  //��ӡ������Ϣ
			// e.printStackTrace();  //���ٴ�ӡ��ջ����Ĵ�����Ϣ
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}catch(Exception e){  //���ܷ������棬���������׳��쳣�����޷�ִ��
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{  //���Բ��ӣ������Ƿ����쳣������ִ��
			//��Ҫ�����ͷ���Դ������رմ򿪵��ļ���ɾ��һЩ��ʱ�ļ�����
			in.close();
			System.out.println("aa");
		}
		
		
		/*catch(Exception e){  //���񲻾�����쳣����,��ΪException��RuntimeException�ĸ��ࣨ��������ñ���������������Ķ���
			//���Ը�������ñ��������Խ������������׳��Ķ���
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
		
		
		//���Ǿ�����쳣����
		/*catch(InputMismatchException e){  //һ���������������쳣������catch����쳣����д���,�������쳣�������
			System.out.println(e.getMessage());  //��ӡ������Ϣ
			e.printStackTrace();  //���ٴ�ӡ��ջ����Ĵ�����Ϣ
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
		
		System.out.println("10/" + num + "=" + res);
	}
	
	//������Ǿ�̬��Ҫ����������ܵ��÷�������̬[������]���÷Ǿ�̬������
	//����Ǿ�̬�Ŀ���ֱ�ӵ��ã���̬�������þ�̬����
	//try����ֱ�Ӻ�finallyʹ��
	//����ִ�У����׳����쳣���벶�񣬽������������������ȥ���񣬽ṹʵ��ְ�����
	//ʵ�����쳣�������쳣����Ľ���ò�ͬ�ķ���רע���Լ�Ӧ����������
	public static void testTryFinally(String name){
		try{
			System.out.println(name.length());
		}finally{
			System.out.println("end");
		}
	}
}
