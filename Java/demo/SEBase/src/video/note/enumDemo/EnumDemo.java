/*
 *  ö�����;���Ԥ�ȴ������ö�����͵Ķ��󣬹��ⲿ��ʹ��
 */

package video.note.enumDemo;

public class EnumDemo {
	//������
	public static void main(String[] args) {
		//����ö�ٵ�ֵ
		System.out.println(Color.BLUE);  //Color.BLUE.toString
		Color[] colors = Color.values();  //��һ������
		for(Color c:colors){
			System.out.println(c);
		}
		
		//ö����Person
		System.out.println(Person.P1.toString() + "\n----");  //toString����ʡ��
		//����ö�٣����飩
		Person[] prs = Person.values();  //��ö���е����ݴ�������
		for(Person p:prs){
			System.out.println(p);
		}
		System.out.println("------");
		
		Person p = Person.P3;
		switch(p){
			case P1:
				System.out.println(Person.P1);
				break;
			case P2:
				System.out.println(Person.P2);
				break;
			case P3:
				System.out.println(Person.P3);
				break;
		}
	}
}

//�������˾�̬����
//����������jvm-java�������ȥ����ʹ��ö�����ʱ�򣬻�Ԥ�ȴ������ö�����͵Ķ����ⲿ��(����)��ʹ��
//public static final Color RED = new Color();
//public static final Color BLUE = new Color();
//public static final Color YELLO = new Color();
enum Color{  //ö�٣����ǳ���
	//�Ƕ��󣬾��й��췽������
	//ö�����͵�ֵ������Ϊ��һ��������
	RED,BLUE,YELLOW;  //�൱��RED(),BLUE(),YELLOW();
	
	//���췽������������췽��������,����������new�����Բ�����public���Σ�
	//�������޲ι��췽��
	private Color(){
		System.out.println("���췽��");
	}
	
	//��дtoString����
	/*public String toString(){
		return "aa";
	}*/
}

//public static final Person P1 = new Person("����", 30);
//public static final Person P1 = new Person("����", 30);
//public static final Person P1 = new Person("����", 30);
enum Person{
	//���ù��췽��
	P1("����", 30), P2("����", 30), P3("����", 30);
	private String name;
	private int age;
	private Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//��дtoString����
	public String toString(){
		return name + "--" + age;
	}
}
