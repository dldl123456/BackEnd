package step3.course.note.l171128;

public class Method {

	/*
	 * public:�������η���������
	 * static:�����࣬�������ڸ���һ�¡�����. ֱ�ӵ���
	 * void:����ֵ���� (û�з���ֵ)
	 */
	public static void main(String[] args) {
		/*int num = 15;
		show(num);
		System.out.println(num);
		System.out.println(show(num));*/
		
		String name = "zhangsan";
		main(name);
		System.out.println(name);
		
		/*String[] names = {"zhangsan"};
		test(names);
		System.out.println(names[0]);*/
	}
	
	/*public static void show(int num){
		num = 20;
		System.out.println("show....");
	}*/
	
	//ֵ����(���ݸ�����ֵ����)
	//�����������ͣ�������ֵ
	public static int show(int num){
		num = 20;
		System.out.println("show....");
		return num;
	}
	
	//String ���⣺final���Σ����ܸı�
	public static void main(String name) {
		name = "lisi";
		System.out.println("��main������������");
	}
	
	//�����������ͣ������ĵ�ַ
	public static void test(String[] name) {
		name[0] = "lisi";
		System.out.println("test������������");
	}
	
}
