/*
 *  ���캯���ķ�����Ҫ�Բ�������ʼ��
 *  �����ͷ�����һ�¾��ǹ��췽��
 */

package video.note.constructorDemo;

public class ConstructorDemo {
	//������
	public static void main(String[] args) {
		/*//�޲εĹ��췽��
		Person p = new Person();  //ʵ��������p(��Person��˽�б�������ʼֵ)
		
		//��ֵ���вεĹ��캯���޷�������ֵ��
		p.setName("����");
		p.setCity("����");
		p.setAge(3);*/
		
		//�вεĹ��췽��
		/*
		 *  1.�ڶ��п��ٿռ䣬�����Է���Ĭ�ϵĳ�ʼֵ
		 *  2.��������һ��ʼ�͸�ֵ�ˣ��ͽ��и�ֵ����
		 *  3.���ù��췽�������Խ��г�ʼ��
		 */
		Person p = new Person("����", "����", 3);
		
		//����toString�������
		System.out.println(p.toString());
	}
}

//��һ����û����ʽ����һ�����췽����ʱ��ϵͳ����һ��Ĭ�ϵ��޲ι��췽��
class Person{
	//�������
	private String name;
	private String city;
	private int age;
	
	//���췽��(Ĭ�����޲Σ��Զ�����)
	/*public Person(){
		System.out.println("�����޲ι��췽��");
	}*/
	
	//���췽�����������Ĺ��췽����
	public Person(int num){
		System.out.println("���Ǵ������Ĺ��췽��" + num);
	}
	
	//�Զ��幹�췽��(�������Ĺ��췽��)
	public Person(String name, String city, int age){
		// this();  //���õ�ǰ�����е��޲ι��췽��
		this(1);  //���õ�ǰ�����д������Ĺ��췽��
		this.name = name;
		this.city = city;
		this.age = age;
		
		//�����ڳ�ʼ������֮����õ�ǰ����Ĺ��췽�����������������䣩
	}
	
	//alt+shift+s
	//name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//city
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	
	//age
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//���� alt+shift+s ==> toString
	//������this.name-->���this����ָʵ������p�����ñ���
	public String toString() {
		//�����е��÷���(�������ö�����õ�)����p.getAge,��this.getAge,���ﲻ����p.getAge
		System.out.println(getAge());
		return "Person [name=" + name + ", city=" + city + ", age=" + age + "]";
	}	
}
