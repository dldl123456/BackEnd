package eg.arr.objectArray_2;

public class ObjectArray {
	private String name;
	private int age;
	
	public ObjectArray(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		//����1��Demo1��������student,������3��3�ռ�
		ObjectArray[]student=new ObjectArray[3];
		//ʵ������������
		student[0]=new ObjectArray("�ŷ�",20);
		student[1]=new ObjectArray("���",10);
		student[2]=new ObjectArray("����",50);
		//ѭ������ȡ��
		//student[i]�õ����¶�������
		for (int i = 0; i < student.length; i++) {
			System.out.println("����:"+student[i].getName()+"����:"+student[i].getAge());
		}
	}
}
