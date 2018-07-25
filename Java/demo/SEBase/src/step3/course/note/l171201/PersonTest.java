package step3.course.note.l171201;

public class PersonTest {

	public static void main(String[] args) {
		
		Person p = Person.getInstance();//不写系统默认提供一个无参构造方法
		System.out.println(p);
		Person p2 = Person.getInstance();//不写系统默认提供一个无参构造方法
		System.out.println(p2);
		Person p3 = Person.getInstance();//不写系统默认提供一个无参构造方法
		System.out.println(p3);
		Person p4 = Person.getInstance();//不写系统默认提供一个无参构造方法
		System.out.println(p4);
		p.setName("zhangsan");
		p.setAge(-18);
		p.setSex('男');
		System.out.println(p.getName()+","+p.getAge()+","+p.getSex());
		
		
		PersonTest pt = new PersonTest();
		System.out.println(pt);
		PersonTest pt2 = new PersonTest();
		System.out.println(pt2);
		
		//Calendar
		//Math
		
	}

}
