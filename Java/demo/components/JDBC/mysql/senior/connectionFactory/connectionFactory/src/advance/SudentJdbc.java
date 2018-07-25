package advance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import common.ConnectionFactory;
import common.DBUtils;
import pojo.Student;

public class SudentJdbc {
	//����ѧ��
	@SuppressWarnings("resource")
	public void save(Student stu){
		//׼��һ�����Ӷ���
		Connection conn = null;
		//׼��һ���������ݿ�Ķ���
		PreparedStatement pstmt = null;
		//׼��һ�����������Ķ���
		ResultSet rs = null;
		
		
		try{
			//��ú����ݿ������
			conn = ConnectionFactory.getConnection();
			
			//sql
			String selectSQL = "SELECT id,name FROM student";
			
			//ִ��sql�����ؽ����
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			
			Long id = 0L;
			
			//���������
			if(rs.next()){
				id = rs.getLong(1);
			}
			
			//����
			String insertSQL = 
					"INSERT INTO student VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setLong(1, id);
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getAddress());
			pstmt.setString(4, stu.getGender());
			pstmt.setInt(5, stu.getAge());
			
			//ִ��(����Ӱ��ļ�¼��)
			int rows = pstmt.executeUpdate();
			
			System.out.println("�ɹ������¼" + rows + "��");
		}catch(Exception e){
			e.printStackTrace();
			
			try {
				//�ع�
				conn.rollback();
			} catch (SQLException e1) {}
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
	}
}
