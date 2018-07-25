package video.note.ClassDemo;

public class ClassDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Employee emp = new Employee("zhangs", 20);
		
		//返回此object的运行时类
		//获得对象所对象的类型的class对象
		//?表示这个类型可以接收任意类型的class对象
		//对象名.getclass
		//Class<?> classType = emp.getClass();
		
		//类名.class
		//Class<?> classType = Employee.class;
		
		//class.forName()
		//返回与带有给定字符串名的类或接口相关联的class对象
		/*try {
			Class<?> classType = Class.forName("video.note.ClassDemo.Employee");
			System.out.println(classType.getCanonicalName());
			System.out.println(classType.getSuperclass().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//获取基本数据类型的class对象(基本数据类型没有父类)
		//Class<?> classType = int.class;
		
		//通过基本数据类型的包装类来获取的基本数据类型所对应的class对象
		//Class<?> classType = Double.TYPE;
		
		//包装类有父类
		Class<?> classType = Double.class;
		
		//名字
		System.out.println(classType.getCanonicalName());
		
		//返回class对象的父类(基本数据类型没有父类)
		System.out.println(classType.getSuperclass().getName());
		
		
	}
}

class Employee{
	private String name;
	private int age;
	
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
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}