/*
 *  �����ڲ���
 */

package video.note.anomymousInnerClass;

public class AnomymousInnerClass {
	public static void main(String[] args) {
		Person p = new Person();
		Person1 p1 = new Person1();
		
		p.feed(new Animal(){  //new��������һ�����࣬һ����ȥ�̳�Animal
			//ʵ��(��д)����������ĳ��󷽷�
			//�����ڲ��๹�����һ������
			public void eat(){
				System.out.println("�з�");
			}
		});
		
		p.feed(new Animal(){
			public void eat(){
				System.out.println("����");
			}
		});
		
		//�������ڲ��๹�����Ķ���ֵ��dog
		//dogָ��������������ڲ������ڴ�����������Ķ���
		//�������ñ��������������ֻ�ܵ��ø��������еķ���
		Animal dog = new Animal(){
			public void eat(){
				System.out.println("�Թ���");
			}
		};
		p.feed(dog);  //����dog������
		p.feed(dog);
		
		//���������ڲ����е�˽�����Ժͷ���
		new Animal(){
			private String name = "С��";
			
			/*static {
				
			}*/  //�����ڲ��಻���þ�̬��
			
			//����飬�ȹ��췽����ִ�У����������Ժͷ������г�ʼ��
			{
				name = "jj";
			}
			
			public void eat(){
				System.out.println("�Թ���");
			}
			
			public void show(){
				System.out.println("�Լ��ķ���" + name);
			}
		}.show();
		
		//interface
		p1.feed1(new IAnimal(){
			public void eat1(){
				System.out.println("I����");
			}
		});
		
		//new�������ǽӿ������ʵ�������
		//���������ڲ����е�˽�����Ժͷ���
		new IAnimal(){
			private String name = "С��";
			
			/*static {
				
			}*/  //�����ڲ��಻���þ�̬��
			
			//����飬�ȹ��췽����ִ�У����������Ժͷ������г�ʼ��
			{
				name = "jj";
			}
			
			public void eat1(){
				System.out.println("I�Թ���");
			}
			
			public void show(){
				System.out.println("I�Լ��ķ���" + name);
			}
		}.show();
	}
}

//������
abstract class Animal{
	//�������󷽷�
	public abstract void eat();
}

//�ӿ�
interface IAnimal{
	//�������󷽷�
	public abstract void eat1();
}

//ιʳ
class Person{
	public void feed(Animal animal){  //��һ��ʵ�����Ķ���
		//animalָ�����㹹�������������ڲ���Ķ���
		animal.eat();
	}
}

//ιʳ
class Person1{
	public void feed1(IAnimal animal){
		animal.eat1();
	}
}

