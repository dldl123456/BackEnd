package step3.course.note.l171201;

public class PersonTest {

	public static void main(String[] args) {
		
		Person p = Person.getInstance();//��дϵͳĬ���ṩһ���޲ι��췽��
		System.out.println(p);
		Person p2 = Person.getInstance();//��дϵͳĬ���ṩһ���޲ι��췽��
		System.out.println(p2);
		Person p3 = Person.getInstance();//��дϵͳĬ���ṩһ���޲ι��췽��
		System.out.println(p3);
		Person p4 = Person.getInstance();//��дϵͳĬ���ṩһ���޲ι��췽��
		System.out.println(p4);
		p.setName("zhangsan");
		p.setAge(-18);
		p.setSex('��');
		System.out.println(p.getName()+","+p.getAge()+","+p.getSex());
		
		
		PersonTest pt = new PersonTest();
		System.out.println(pt);
		PersonTest pt2 = new PersonTest();
		System.out.println(pt2);
		
		//Calendar
		//Math
		
	}

}
