package video.note.abstractDemo;

public class EmployeeDemo {
	public static void main(String[] args) {
		// JavaTeacher jta = new JavaTeacher(1, "С��", 200);
		Employee jta = new JavaTeacher(1, "С��", 200);  //Ҳ�����ó�����������jta�������
		//��������ñ���Ҳ���������������ʵ�ֶ�̬
		jta.work();  //���ó��󷽷�
		
		Leader led = new Leader(2, "С��", 250, 1000000);
		led.work();  //���ó��󷽷�
		
		//�����಻�ܽ���ʵ����
		//Employee emp = new Employee();
	}
}

//�����࣬Ҳ�Ǹ���
abstract class Employee{
	//����
	@SuppressWarnings("unused")
	private int number;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private double salary;
	
	//���췽��
	public Employee(int number, String name, double salary){
		this.number = number;
		this.name = name;
		this.salary = salary;
	}
	
	//���󷽷��������������ࣩ
	public abstract void work();
	
	//��������������з�����ʵ�ֺͿշ���
	public void aa(){
		System.out.println("aa");
	}
}

//�̳�
//һ��һ����ȥ�̳��˳����࣬��ô������Ҫôȥʵ�ֳ������еĳ��󷽷�
//Ҫô����������ȥ
class JavaTeacher extends Employee{
	public JavaTeacher(int number, String name, double salary){
		super(number, name, salary);
	}

	//public abstract void work();
	
	//���󷽷���ʵ��
	public void work(){
		System.out.println("JavaTeacher��java��");
	}
}

//����2(�ܼ�)
class Leader extends Employee{
	@SuppressWarnings("unused")
	private double allowance;  //����
	
	public Leader(int number, String name, double salary, double allowance){
		super(number, name, salary);
		this.allowance = allowance;
	}
	
	//���󷽷���ʵ��
	public void work(){
		System.out.println("Leader��ѵ��Ա��");
		System.out.println("Leader��ƽ�ѧ��ϵ");
	}
}
