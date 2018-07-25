package step3.course.day12_01;

public class PersonTest {
	public static void main(String[] args) {
		/*Person p = new Person();  //不写系统默认提供一个无参构造方法
		p.eat();
		p.eat("aa");
		p.stuname = "aa";
		System.out.println(p.stuname);
		
		p.stuname = "123";  //这样不安全
		//为了避免这种操作，用私有变量
		
		//私有
		//p.pname = "aa";	//在其他类里面不能访问private变量
		
		//用get，set方法获取输出
		p.setPname("123132");
		p.setPage(5);
		System.out.println(p.getPage());
		System.out.println(p.getPname());*/
		
		//调用私有构造方法
		Person p = Person.getInstance();
		p.setPname("456789");
		System.out.println(p.getPname());
	}
}