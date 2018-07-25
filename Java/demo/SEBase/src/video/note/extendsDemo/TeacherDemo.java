package video.note.extendsDemo;

public class TeacherDemo {
	public static void main(String[] args) {
		//��������1
		JavaTeacher JT = new JavaTeacher("����", "xx��˾");
		JT.teaching();
		
		//��������2
		DBTeacher DT = new DBTeacher("����", "oo��˾");
		DT.teaching();
	}
}

//����
class Teacher {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String school;
	
	//���캯����ʼ������
	public Teacher(String name, String school){
		this.name = name;
		this.school = school;
	}
	
	//����
	public void teaching(){
		System.out.println("�ڿ�ǰ׼��");
	}
}

//����1
class JavaTeacher extends Teacher {
	//���ʸ���˽�б���
	//������������ʱ����Ҫ������������ȥ��
	//����Ӧ��Ҫ������Ĺ��캯��
	public JavaTeacher(String name, String school){
		super(name, school);  //���ø���Ĺ��췽�����Ը�����������Խ��г�ʼ��
		//�����super();���߲�д�����ǵ��ø����޲εĹ��췽��
	}
	
	public void teaching(){
		//��������ʱ����super�����������Բ�д
		super.teaching();  //���ø��෽��
		System.out.println("��eclipse");
		System.out.println("��������������������");
	}
}

//����2
class DBTeacher extends Teacher {
	public DBTeacher(String name, String school){
		super(name, school);
	}
	
	public void teaching(){
		super.teaching();  //���ø��෽��
		System.out.println("��Oracle");
		System.out.println("��������������������");
	}
}
