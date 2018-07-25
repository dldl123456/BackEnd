package student;

public class Student {
	
	private String user;//学生帐户
	private int pwd;//学生密码
	private String name;//名字
	private int age;//年龄
	private String sex;//性别
	private String address;//班级
	private int math;//数学分数
	private int English;//英语分数
	private int sum;//总分
	
	public Student() {
		super();
	}
	public Student(String user,int pwd) {
		this.user=user;
		this.pwd=pwd;
	}
	//初始化参数
	public Student(String name,int age,String sex,String address,int math,int English,int sum) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.address=address;
		this.math=math;
		this.English=English;
		this.sum=sum;
	}
	//重写String方法
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
	//返回Student对象数组
	public static Student[] getStudent() {
	    Student []arr=new Student[3];
		Student student1=new Student("张山", 18, "男", "上海", 60, 90, (60+90));
		Student student2=new Student("露娜", 20, "女", "杭州", 80, 40, (80+40));
		Student student3=new Student("关羽", 45, "男", "宁波", 50, 80, (50+80));
		arr[0]=student1;
		arr[1]=student2;
		arr[2]=student3;
		return arr;	
	}
	//学生账号
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
