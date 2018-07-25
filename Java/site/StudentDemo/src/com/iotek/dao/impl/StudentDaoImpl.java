package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.StudentDao;
import com.iotek.db.DbHelp;
import com.iotek.entity.Student;

/**
 * Dao 实现类
 * 与数据库进行交互，只写数据库交互代码，不能写业务逻辑处理代码，业务逻辑处理放到service层
 * @author Administrator
 *
 */
public class StudentDaoImpl implements StudentDao {
	
	private DbHelp db;
	private Connection conn;
	private List<Student> list ; 
	
	public StudentDaoImpl() {
		db = new DbHelp(); //创建一个db实例,初始化
		list =  new ArrayList<>();
		//conn = db .getConnection();
	}

	@Override
	public int addStudent(Student student) {
		/**
		 * conn -- dbhelp
		 * 每次方法调用都要打开链接,并且关闭
		 * 因为每一个方法都相当于操作一次数据库
		 * ?代表占位符, 可以把想要填充的数据添加进去
		 */
		conn = db .getConnection( );
		String sql = "insert into student(name,psw,score) values(?,?,?)";
		
		PreparedStatement ps  = null;
		try {
			//与处理这个sql 语句,并没有执行
			ps = conn.prepareStatement(sql);
			//把学生对象里面的name 给第一个占位符
			ps.setString(1, student.getName());
			ps.setString(2, student.getPsw());
			ps.setDouble(3, student.getScore());
			//返回的是受影响的行数
			//增删改 都是调用的executeUpdate();
			//查 executeQuery();
			return ps.executeUpdate();//执行并更新数据库内容
			//不能提示,要把这个值返回出去,给逻辑层进行判断
			/*if (ps.executeUpdate() !=0 ) {
				System.out.println(" ok   ");
			}
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		return 0;
 
		
	}

	@Override
	public int deleteStudent(int id) {
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		return 0;
	}

	@Override
	public List<Student> selectAll() {
		conn = db.getConnection();
		String sql = "select * from student";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql );
			rs = ps.executeQuery();
			//一条一条的记录信息
			Student student ;
			while(rs.next()){
				 int id = rs.getInt("id");//得到的是那一列的值
				 String name = rs.getString("name");
				 String psw = rs.getString("psw");
				 double score  = rs.getDouble("score");
				 // 确保===>>每次的循环得到的都是一个新的学生对象  
				 student = new Student(id, name, psw, score);
				 list.add(student);//把学生对象添加到容器当中
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, rs);
		}
		return list;
	}


}
