package test1;

public class Dog extends Animal {
	//���๹�캯����ȡ���๹�캯���ķ���
	public Dog(String name, String colour, int age) {
		super(name, colour, age);  //super�Ǹ������
	}
	
	//��������Ϊ��:�涫��(����)
	public void play(){
		System.out.println("�����");
	}
}
