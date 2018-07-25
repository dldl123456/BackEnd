package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
	private DbHelp db;
	private Connection conn;
	private List<Student> list; 
	
	//构造方法初始化
	public StudentDaoImpl() {
		db = new DbHelp();
		list =  new ArrayList<>();
	}

	//添加学生实现类
	@Override
	public int addStudent(Student student) {
		conn = db.getConnection();
		String sql = "insert into student(stu_name, stu_age, stu_score) values(?,?,?)";
		
		PreparedStatement ps  = null;
		try {
			ps = conn.prepareStatement(sql);
			//把学生对象里面的name 给第一个占位符
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setDouble(3, student.getScore());
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		return 0;
	}

	//删除学生实现类
	@Override
	public int deleteStudent(int id) {
		conn = db.getConnection();
		String sql = "delete from student where stu_id = ?";
		PreparedStatement ps  = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//修改学生实现类
	@Override
	public int updateStudent(Student student) {
		conn = db.getConnection();
		String sql = "update student set stu_name=?, stu_age=?, stu_score=? where stu_id=?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setDouble(3, student.getScore());
			ps.setInt(4, student.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//查询学生实现类
	@Override
	public List<Student> selectAll() {
		conn = db.getConnection();
		String sql = "select * from student";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//一条一条的记录信息
			Student student ;
			while(rs.next()){
				 int id = rs.getInt("stu_id");
				 String name = rs.getString("stu_name");
				 int age = rs.getInt("stu_age");
				 double score  = rs.getDouble("stu_score");
				 student = new Student(id, name, age, score);
				 list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, rs);
		}
		return list;
	}
	
	//测试数据库是否链接成功并获取到数据
	public static void main(String[] args) {
		StudentDaoImpl stuDao = new StudentDaoImpl();
		
		List<Student> stuList = stuDao.selectAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
	}
}
