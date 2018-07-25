package student;

public class Student {
	
	private String user;//ѧ���ʻ�
	private int pwd;//ѧ������
	private String name;//����
	private int age;//����
	private String sex;//�Ա�
	private String address;//�༶
	private int math;//��ѧ����
	private int English;//Ӣ�����
	private int sum;//�ܷ�
	
	public Student() {
		super();
	}
	public Student(String user,int pwd) {
		this.user=user;
		this.pwd=pwd;
	}
	//��ʼ������
	public Student(String name,int age,String sex,String address,int math,int English,int sum) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.address=address;
		this.math=math;
		this.English=English;
		this.sum=sum;
	}
	//��дString����
	public String toString() {
		return   name + "\t" + sex + "\t" + age + "\t" + math + "\t"
		+English+"\t"+sum+"\t"+address;
		}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int math,int English) {
		this.sum = math+English;
	}
	//����Student��������
	public static Student[] getStudent() {
	    Student []arr=new Student[3];
		Student student1=new Student("��ɽ", 18, "��", "�Ϻ�", 60, 90, (60+90));
		Student student2=new Student("¶��", 20, "Ů", "����", 80, 40, (80+40));
		Student student3=new Student("����", 45, "��", "����", 50, 80, (50+80));
		arr[0]=student1;
		arr[1]=student2;
		arr[2]=student3;
		return arr;	
	}
	//ѧ���˺�
	public static  Student[]str(){
		Student[]students=new Student[1];
		Student s1=new Student("faker",123);
		students[0]=s1;
		return students;
	}
	/*public static void main(String[] args) {
		Student[] st=Student.getStudent();
		for (int i = 0; i < st.length-1; i++) {
			for (int j = 0; j < st.length-1-i; j++) {
				if (st[j].getMath()<st[j+1].getMath()) {
					Student student=st[j+1];
					st[j+1]=st[j];
					st[j]=student;
				}
			}
		}
		
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].toString());
		}
	}*/
}
