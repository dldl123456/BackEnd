package video.note.teacherDemo_fz;

public class TeacherDemo {
	//测试类
	public static void main(String[] args) {		
		Teacher t = new Teacher();  //实例化Teacher对象
		
		//name
		t.setName("张三");  //通过set方法给name赋值
		System.out.println(t.getName());  //输出用get方法
		
		//age
		t.setAge(55);  //通过set方法给age赋值
		System.out.println(t.getAge());  //输出用age方法
	}
}

class Teacher{
	//定义私有属性
	private String name;
	private int age;
	
	//给name声明get、set方法
	public void setName(String tname){
		name = tname;
	}
	public String getName(){
		return name;
	}
	
	//给age声明get、set方法
	public void setAge(int tage){
		if(tage<25){
			System.out.println("年龄太小");
			age = 25;
		}else{
			age = tage;
		}
	}
	public int getAge(){
		return age;
	}
}
