package note.oop.obj;

public class Student {
	public String name;
	public String sex;
	public int age;
	
	//��Ϊ��������������������ܸ���
	public void eat(String food){
		System.out.println("ȥ��:" + food);
	}

	//toString ���Ǹ�ʽ������ -- ��ӡ�úÿ�һ��
	//alt + shift + s --> toString
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
}
