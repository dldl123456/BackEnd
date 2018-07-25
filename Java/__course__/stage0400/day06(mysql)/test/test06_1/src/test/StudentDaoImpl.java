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
	
	//���췽����ʼ��
	public StudentDaoImpl() {
		db = new DbHelp();
		list =  new ArrayList<>();
	}

	//���ѧ��ʵ����
	@Override
	public int addStudent(Student student) {
		conn = db.getConnection();
		String sql = "insert into student(stu_name, stu_age, stu_score) values(?,?,?)";
		
		PreparedStatement ps  = null;
		try {
			ps = conn.prepareStatement(sql);
			//��ѧ�����������name ����һ��ռλ��
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setDouble(3, student.getScore());
			return ps.executeUpdate();//ִ�в��������ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		return 0;
	}

	//ɾ��ѧ��ʵ����
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

	//�޸�ѧ��ʵ����
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

	//��ѯѧ��ʵ����
	@Override
	public List<Student> selectAll() {
		conn = db.getConnection();
		String sql = "select * from student";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//һ��һ���ļ�¼��Ϣ
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
	
	//�������ݿ��Ƿ����ӳɹ�����ȡ������
	public static void main(String[] args) {
		StudentDaoImpl stuDao = new StudentDaoImpl();
		
		List<Student> stuList = stuDao.selectAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
	}
}
