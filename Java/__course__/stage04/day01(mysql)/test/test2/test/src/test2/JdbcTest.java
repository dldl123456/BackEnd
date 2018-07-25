/**
 * ͨ��Java����JDBC����ɵ�һ���ж����ݿ���ĸ�����
 */

package test2;

import java.sql.Connection;  //���ݿ������� ��Connection��
import java.sql.DriverManager;  //������������ࣨDriverManager��
import java.sql.PreparedStatement;  //�����ࣨStatement��
import java.sql.ResultSet;  //��������� ��ResultSet��
import java.sql.SQLException;  //sql�쳣

public class JdbcTest {
	//������
	public static void main(String[] args) {
		fetchData();
	}

	//��ȡ���ݿⷵ�صĽ����
	private static void fetchData() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3303/test1";
		String user = "root";
		String pwd = "root";
		
		Connection conn = null;  //׼��һ�����Ӷ���
		
		try {
			//1.������������
			Class.forName(driver);
			
			//2.������ݿ�����
			conn = DriverManager.getConnection(url, user, pwd);
			
			//�����Ƿ����ӳɹ�
			System.out.println(conn + "\n");
			
			//3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
			String sql = "SELECT NickName AS '�ǳ�',Sex AS '�Ա�',StarName AS '����',BloodType AS 'Ѫ��'"
					+ " FROM Users, Star, Blood"
					+ " WHERE Users.BloodTypeId=Blood.id AND Users.StarId=Star.id";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			//4.ִ��sql���,�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
			System.out.println("�ǳ�\t�Ա�\t����\tѪ��\n");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					//�ر���Դ
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
