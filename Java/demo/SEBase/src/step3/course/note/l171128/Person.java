package step3.course.note.l171128;

public class Person {
	
	/*
	 * ���ԣ����ʣ�
	 */
	String name;
	int age;
	char sex;
	
	/*
	 * ���췽��  *****
	 * ������������һ��
	 * ������������ֵ����(�з���ֵ������ֵ�ǵ�ǰ�����)
	 * 1.��������
	 * 2.��ʼ��
	 */
	public Person(){
		name = "С��";
		age = 20;
		sex = '��';
		System.out.println("��û�е����ҡ���������");
	}
	
	
	/*
	 * ���������ʣ�
	 */
	public void eat(){
		System.out.println("eat................");
	}

	public void play(){
		System.out.println("play...............");
	}

	
	/*
	 * public:�������η���������
	 * static:�����࣬�������ڸ���һ�¡�����. ֱ�ӵ���
	 * void:����ֵ���� (û�з���ֵ)
	 */
	public static void main(String[] args) {
		
		//���ǳ����
		//�����Ǿ����
		
		Person p = new Person();//ʵ����
		p.name="zhangsan";
		p.age=18;
		p.sex='Ů';
		p.eat();
		
		Person p2 = new Person();
		p2.name="lisi";
		p2.age=22;
		p2.sex='��';
		System.out.println(p2.name+","+p2.age+","+p2.sex);
		
		Person p3 = new Person();
		System.out.println(p3.name+","+p3.age+","+p3.sex);
	}
	
}
