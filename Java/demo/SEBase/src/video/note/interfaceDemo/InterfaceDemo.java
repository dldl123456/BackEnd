package video.note.interfaceDemo;

public class InterfaceDemo {
	public static void main(String[] args) {
		System.out.println(IAbility.number);
		System.out.println(IAbility.number1);
		
		Person p = new Person();
		Child chd = new Child();
		Dog dg = new Dog();
		p.feed(chd);
		p.feed(dg);
	}
}

class Person{
	//�ӿڵ����ñ�������������ʵ����Ķ���
	//�ӿ�ʵ���˶�̬
	public void feed(IAbility abilty){
		abilty.eat();  //��̬��ʵ���˶�̬
	}
}

//����һ���ӿ�
//�ӿ���ֻ�ܷŹ��еľ�̬�����ͳ��󷽷�
interface IAbility{
	//���о�̬����
	public static final int number = 1;
	int number1 = 2;  //Ĭ�Ϲ��о�̬�������������ͬ��
	
	//���󷽷�
	/*public abstract*/ void show();  //Ĭ��public abstract
	
	void eat();
}

//��Clild�� �߱� IAbility ������
class Child implements IAbility/*����ӿڿ����ö��Ÿ���*/{
	//��ʾ��д�˽ӿ���Ķ���
	public void eat(){
		System.out.println("�Է�");
	}
	
	public void show() {
		
	}
}

//
class Dog implements IAbility{
	public void eat(){
		System.out.println("�й�ͷ");
	}

	public void show() {
		
	}
}

/*class Person{
//��������
	//ιС��
	public void feed(Child chd){
		chd.eat();
	}
	
	//ι��
	public void feed(Dog dg){
		dg.eat();
	}
}*/

/*class Child{
	public void eat(){
		System.out.println("�Է�");
	}
}

class Dog{
	public void eat(){
		System.out.println("�й�ͷ");
	}
}*/