package test1;

public class SmallDog extends Dog {
	//���๹�캯����ȡ���๹�캯���ķ���
	public SmallDog(String name, String colour, int age) {
		super(name, colour, age);  //super�Ǹ������
	}
	
	//��������Ϊ��:��ʳ��(ţ��)
	public void eat() {
		System.out.println("��ţ��");
	}
}
