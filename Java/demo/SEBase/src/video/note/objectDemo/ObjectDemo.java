package video.note.objectDemo;

public class ObjectDemo {
	public static void main(String[] args) {
		Student stu = new Student("aa", 20);
		System.out.println(stu);  //���ڴ��еĵ�ַ(��ϣ��),Ĭ��.toString()����
		Student stu1 = new Student("aa", 20);
		System.out.println(stu.equals(stu1));  //Ĭ�ϵ��ҽ�������ָ��ָ��ͬһ�������ʱ����true
	}
}

class Student{  //��ͬ��extends Object
	private String name;
	private int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//��дtoString����
	public String toString(){
		return "����" + name + "������" + age;
	}
	
	//��дequals����
	public boolean equals(Object obj){
		//�Լ����Լ��ȣ��������Ķ���͵�ǰ�Ķ���Ƚϣ�
		if(this == obj){
			return true;
		}
		
		if(obj == null){
			return false;
		}
		
		//getClass���ص��ǵ��Ҷ��������(student)
		//ѧ�����������
		if(this.getClass() != obj.getClass()){
			return false;
		}
		
		//ǿ������ת��
		//��������һ������������ѧ����ǿ��ת���ɶ�Ӧ��ѧ��
		Student stu = (Student)obj;
		//��ǰ������㴫�����Ķ���
		if(this.age != stu.age){
			return false;
		}
		
		if(this.name == null){
			if(stu.name != null){
				return false;
			}
		}else if(!this.name.equals(stu.name)){
			return false;
		}
		
		return true;
	}
}