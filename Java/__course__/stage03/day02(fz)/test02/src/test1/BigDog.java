package test1;

public class BigDog extends Dog {
	//���๹�캯����ȡ���๹�캯���ķ���
	public BigDog(String name, String colour, int age) {
		super(name, colour, age);  //super�Ǹ������
	}

	//��������Ϊ��:��ʳ��(���ͷ)
	public void eat() {
		System.out.println("�����ͷ");
	}
}
