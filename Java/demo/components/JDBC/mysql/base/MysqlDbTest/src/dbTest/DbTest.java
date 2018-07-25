package dbTest;
import java.sql.Connection;  //���ݿ������� ��Connection��
import java.sql.DriverManager;  //������������ࣨDriverManager��
import java.sql.ResultSet;  //��������� ��ResultSet��
import java.sql.SQLException;
import com.mysql.jdbc.Statement;  //�����ࣨStatement��

public class DbTest {
	public static void main(String[] args){
		Connection conn = null;  //׼��һ�����Ӷ���
		
		try {
			//1.������������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//2.������ݿ�����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3303/demo","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "select * from user";
		
		try{
			//3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println("id="+id+","+"name="+name);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			//�ر���Դ
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}