/*
 *  ѧ��ʹ�ö���
 */

package video.note.dogUseObj;

public class Dog {
	public String brand;  //Ʒ��
	public int age;
	
	//�������� ������
	public String toString(){
		return "����һ��" + age + "���" + brand;
	}
	
	//����������Ƕ���������Ҫһ�����
	public static void main(String[] args) {
		Dog dog = new Dog();  //������һ��Dog���͵Ķ���
		dog.brand = "�л���԰Ȯ";
		dog.age = 3;
		System.out.println(dog.toString());
	}
}
