package advance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import common.ConnectionFactory;
import common.DBUtils;
import pojo.Student;

public class SudentJdbc {
	//保存学生
	@SuppressWarnings("resource")
	public void save(Student stu){
		//准备一个连接对象
		Connection conn = null;
		//准备一个操作数据库的对象
		PreparedStatement pstmt = null;
		//准备一个保存结果集的对象
		ResultSet rs = null;
		
		
		try{
			//获得和数据库的连接
			conn = ConnectionFactory.getConnection();
			
			//sql
			String selectSQL = "SELECT id,name FROM student";
			
			//执行sql并返回结果集
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			
			Long id = 0L;
			
			//遍历结果集
			if(rs.next()){
				id = rs.getLong(1);
			}
			
			//新增
			String insertSQL = 
					"INSERT INTO student VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getAddress());
			pstmt.setString(4, stu.getGender());
			pstmt.setInt(5, stu.getAge());
			
			//执行(返回影响的记录数)
			int rows = pstmt.executeUpdate();
			
			System.out.println("成功插入记录" + rows + "条");
		}catch(Exception e){
			e.printStackTrace();
			
			try {
				//回滚
				conn.rollback();
			} catch (SQLException e1) {}
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
	}
}
