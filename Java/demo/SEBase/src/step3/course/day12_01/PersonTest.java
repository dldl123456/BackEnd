package step3.course.day12_01;

public class PersonTest {
	public static void main(String[] args) {
		/*Person p = new Person();  //��дϵͳĬ���ṩһ���޲ι��췽��
		p.eat();
		p.eat("aa");
		p.stuname = "aa";
		System.out.println(p.stuname);
		
		p.stuname = "123";  //��������ȫ
		//Ϊ�˱������ֲ�������˽�б���
		
		//˽��
		//p.pname = "aa";	//�����������治�ܷ���private����
		
		//��get��set������ȡ���
		p.setPname("123132");
		p.setPage(5);
		System.out.println(p.getPage());
		System.out.println(p.getPname());*/
		
		//����˽�й��췽��
		Person p = Person.getInstance();
		p.setPname("456789");
		System.out.println(p.getPname());
	}
}