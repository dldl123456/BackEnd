/*
 *  ������ϰ
 */

package video.note.methodDemo;

public class MethodDemo {
	int num = 30;
	
	public void method1(){
		System.out.println("��������Ϊ�����޲����ķ���");
	}
	
	public String method2(){
		return "���о��巵���������޲����ķ���";
	}
	
	public void method3(String name){
		System.out.println("��������Ϊ���Ҵ��в����ķ�����������ֵΪ" + name);
	}
	
	public String method4(String name, int age){
		return "���о��巵�����ͣ��Ҵ��ж�������ķ�����������ֵΪ" + name + "," + age;
	}
	
	//���ݻ����������͵ķ���
	public void operatorData(int age){
		age++;
		System.out.println(age);
	}
	
	//����������������
	public void operatorArr(int[] array){
		array[2] = 100;
		System.out.println(array[2]);
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		//��������
		MethodDemo demo = new MethodDemo();
		
		//���÷���
		demo.method1();  //����1
		
		String str2 = demo.method2();  //����2
		System.out.println(str2);  //�����������ã�û���գ�
		
		demo.method3("cmcc");  //����3
		
		String str4 = demo.method2();  //����4
		System.out.println(str4);  //�����������ã�û���գ�
		
		int age = 10;
		demo.operatorData(age);
		System.out.println(age);  //operatorData
		
		int[] array = {1,2,3,4};
		demo.operatorArr(array);
		System.out.println(array[2]);  //operatorArr
	}
}
