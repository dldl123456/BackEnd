package sqltemplate;

public class Test {
	public static void main(String[] args) {
		/*SudentJdbc jdbc = new SudentJdbc();
		
		Student stu = new Student();
		stu.setName("уехЩ");
		stu.setAddress("1231");
		stu.setGender("1");
		stu.setAge(12);
		
		jdbc.save(stu);*/
		JDBCTemplate jdp = new JDBCTemplate();
		String sql = "select * from user";
		jdp.query(sql);
	}
}
