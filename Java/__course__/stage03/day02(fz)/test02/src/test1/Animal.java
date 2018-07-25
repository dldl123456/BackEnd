/*
 *  ����һ�������࣬��������name,age,colour����Ϊ�г� ��ӡ�Զ���
 *  ����һ�����࣬�̳��ڶ���������Լ�����Ϊ��ˣ�������
 *  ����һ��С���࣬�̳��ڹ��࣬�Զ�������Ϊ�гԵ���ţ��
 *  ����һ�����࣬�̳��ڹ��࣬�ԵĶ��������ͷ
 *  Ҫ���ӡ��С���ʹ󹷵��������ԣ����Ը�ʽΪ������xxx���ҵ���ɫ��xxx���ҵ�������xxx
 *  ������Ϊ����ӡ��Ч�� xxx������̣�xxx�ڳ�xxx
 */

package test1;

public class Animal {
	//����Animal��˽�б���
	private String name;  //����
	private String colour;  //��ɫ
	private int age;  //����
	
	//��get,set������Animal��˽�����Կ��Žӿ�
	//name����
	public String getName() {  //��ȡname
		return name;
	}
	public void setName(String name) {  //����name
		this.name = name;
	}
	//colour����
	public String getColour() {  //��ȡcolour
		return colour;
	}
	public void setColour(String colour) {  //����colour
		this.colour = colour;
	}
	//age����
	public int getAge() {  //��ȡage
		return age;
	}
	public void setAge(int age) {  //����age
		if(age>0){
			this.age = age;
		}
	}
	
	//���캯������ʼ��������
	public Animal(String name, String colour, int age) {
		this.name = name;
		this.colour = colour;
		this.age = age;
	}
	
	//��������Ϊ������ʳ��
	public void eat(String food) {
		System.out.println("��" + food);
	}
	
	//�������
	public String toString() {
		return "����" + name + "���ҵ���ɫ��" + colour + "���ҵ�������" + age;
	}
	
	//��������������ڣ�
	public static void main(String[] args) {
		//��ӡ����Զ���
		Animal anim = new Animal("С��", "��ɫ", 18);  //ʵ����Animal�ഴ��anim����
		System.out.print(anim.name);  //������anim���������
		anim.eat("����");  //����anim�����ʳ��ķ���
		System.out.println("============");  //��ʽ����
		
		//С��
		SmallDog smd = new SmallDog("С��", "��ɫ", 2);  //ʵ����SmallDog�ഴ��smd����
		System.out.println(smd.toString());  //���������ø�������toString����
		smd.play();  //������������play����
		smd.eat();  //������������eat����
		System.out.println("============");  //��ʽ����
		
		//��
		BigDog bid = new BigDog("��", "��ɫ", 15);  //ʵ����BigDog�ഴ��bid����
		System.out.println(bid.toString());  //���������ø�������toString����
		bid.play();  //������������play����
		bid.eat();  //������������eat����
	}
}
