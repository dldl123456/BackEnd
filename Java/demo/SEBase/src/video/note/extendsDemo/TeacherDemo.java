package video.note.extendsDemo;

public class TeacherDemo {
	public static void main(String[] args) {
		//调用子类1
		JavaTeacher JT = new JavaTeacher("张三", "xx公司");
		JT.teaching();
		
		//调用子类2
		DBTeacher DT = new DBTeacher("李四", "oo公司");
		DT.teaching();
	}
}

//父类
class Teacher {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String school;
	
	//构造函数初始化变量
	public Teacher(String name, String school){
		this.name = name;
		this.school = school;
	}
	
	//教书
	public void teaching(){
		System.out.println("授课前准备");
	}
}

//子类1
class JavaTeacher extends Teacher {
	//访问父类私有变量
	//构建子类对象的时候需要传两个参数过去，
	//所以应该要有子类的构造函数
	public JavaTeacher(String name, String school){
		super(name, school);  //调用父类的构造方法，对父类的两个属性进行初始化
		//如果是super();或者不写，就是调用父类无参的构造方法
	}
	
	public void teaching(){
		//当重名的时候用super，不重名可以不写
		super.teaching();  //调用父类方法
		System.out.println("打开eclipse");
		System.out.println("…………………………");
	}
}

//子类2
class DBTeacher extends Teacher {
	public DBTeacher(String name, String school){
		super(name, school);
	}
	
	public void teaching(){
		super.teaching();  //调用父类方法
		System.out.println("打开Oracle");
		System.out.println("…………………………");
	}
}
