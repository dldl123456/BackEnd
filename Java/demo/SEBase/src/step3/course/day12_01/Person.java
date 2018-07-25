package step3.course.day12_01;

public class Person {
	/*
	 * ����
	 * �����������ı�������������Ա��������Ա�������������������棩
	 */
	String stuname;
	int age;
	char sex;
	
	//˽������
	private String pname;
	private int page;
	private char psex;
	
	//��������
	private static Person p = null;  //��̬�Ĳ��ܵ��÷Ǿ�̬��
	
	//Ϊ�����ⲿ�����˽�б�������get,set����
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page>0){
			this.page = page;
		}
	}

	public char getPsex() {
		return psex;
	}

	public void setPsex(char psex) {
		this.psex = psex;
	}
	
//��������ͬ�������б�ͬ����������
	
	//���췽��(ϵͳĬ��)
	/*public Person(){
		
	}*/
	
	//˽�й��췽��
	private Person(){
		
	}

	//���Σ������һ�����εĹ��캯����ϵͳ�������ṩĬ�ϵ��޲ι��췽����
	public Person(String name){
		//����������ó�Ա����Ҫ��this,thisָ��ǰ����
		this.stuname = name;  //������û��ϵ
	}
	
	//����д����̫�ã����췽������̫���ʱ�򣩣����Ҵ���������Բ��ã�
	public Person(String name, int age){
		//Ϊ�˱����������⣬�����·������ڹ��췽��֮����÷���Ҳ��this��
		//���ù��캯������
		this(name);  //this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, char sex){
		this(name, age);
		this.sex = sex;
	}
	
	/*
	 * ����
	 */
	public void eat(){
		String name = "";  //�ֲ�����
		System.out.println("eat" + name);
	}
	
	public void eat(String food){  //�ֲ�����
		System.out.println("eat" + food);
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.pname = "aa";
		System.out.println(p.pname);  //�ڱ���������Է���
	}
	
	//����˽�й��췽��
	public static Person getInstance(){
		//��һֱ�������������Բ�����
		/*Person p = new Person();
		return p;*/
		if(p == null){
			p = new Person();
		}
		return p; //��̬�Ĳ��ܵ��÷Ǿ�̬��
	}
}
