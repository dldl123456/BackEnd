/*
 *  ��̬�Ĵ�������˳������չ�Ժͺ��ڿ�ά���ԣ�����ϣ�
 */

package video.note.duotaiDemo;

public class AnimalDemo {
	public static void main(String[] args) {
		//��������ñ�����������������ĵĶ���
		Animal anim1 = new Dog("����");  //����ת��
		anim1.eat();
		//����ת�������ǰ�ȫ�ģ������ܻᵼ�����෽���Ķ�ʧ
		//anim1.sleep();������ʧ
		//��������ñ���ֻ�ܵ��ø������еķ�������������д����ķ���
		
		Animal anim2 = new Cat("�в�è");
		anim2.eat();
		
		//����ת���ǲ���ȫ��
		//�Ѹ����ͣ����ǿ������ת���������ͣ�è��
		// Cat cat = (Cat)anim1;  //����ת���쳣
		//�ж�anim1�ǲ���ָ��è���жϹ���������ǲ���è������ʵ����
		/*if(anim1 instanceof Cat){
			Cat cat = (Cat)anim1;
		}*/
		
		//�жϹ���������ǲ���è������ʵ��
		if(anim2 instanceof Cat){
			Cat cat = (Cat)anim2;
			cat.sleep();
		}
	}
}

//����
class Animal{
	@SuppressWarnings("unused")
	private String name;
	public Animal(String name){
		this.name = name;
	}
	
	//����һ��ͨ�õķ�����ͨ�õķ���ʵ��û��̫������壬
	//ֻ�Ǹ���������ȥʵ����
	public void eat(){
		
	}
}

//����
class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
	//�Ը���ķ���������д
	public void eat(){
		System.out.println("�й�ͷ");
	}
	
	//�����Լ��ķ���
	public void sleep(){
		System.out.println("˯��");
	}
}

//����
class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
	//�Ը���ķ���������д
	public void eat(){
		System.out.println("������");
	}
	
	//�����Լ��ķ���
	public void sleep(){
		System.out.println("˯��");
	}
}