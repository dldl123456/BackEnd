package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC2 {
	/**
	 * �淶д��
	 * @param args
	 */
	public static void main(String[] args) {
		//insert();
		
		//update();
		update2();
		
		//delete();
		
		//query();
	}
	
	/**
	 * ���
	 */
	public static void insert(){
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//�������ݿ����Ӷ���
		Connection conn = null;
		
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			//sql
			String sql = "INSERT INTO teacher VALUES (119,\"Tom\",5000,\"��\",28)";
			//����ִ��sql������
			Statement statement = conn.createStatement();
			//ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н��" + code);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * �޸�
	 */
	public static void update(){
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//�������ݿ����Ӷ���
		Connection conn = null;
		
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			//sql
			String sql = "update teacher set teaName=\"С��\" where teaId=119";
			//����ִ��sql������
			Statement statement = conn.createStatement();
			//ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н��" + code);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * �޸�
	 * ��PreparedStatement����
	 */
	public static void update2(){
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//�������ݿ����Ӷ���
		Connection conn = null;
		
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			//sql
			String sql = "update teacher set teaName=?, teaSalary=?, teaGender=?, teaAge=? where teaId=?";
			//String sql = "update teacher set teaName=?, teaSalary=?, teaGender=?, teaAge=? where teaId=111";
			//����ִ��sql������
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "С��");
			ps.setInt(2, 1000000);
			ps.setString(3, "Ů");
			ps.setInt(4, 99);
			ps.setInt(5, 104);
			/*ps.setString(1, "С��");
			ps.setInt(2, 1000000);
			ps.setString(3, "Ů");
			ps.setInt(4, 99);*/
			
			//ִ��
			int code = ps.executeUpdate();
			System.out.println("����ִ�н��" + code);
			
			ps.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ɾ��
	 */
	public static void delete(){
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//�������ݿ����Ӷ���
		Connection conn = null;
		
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			//sql
			String sql = "delete from teacher where teaId=120";
			//����ִ��sql������
			Statement statement = conn.createStatement();
			//ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н��" + code);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	/**
	 * ��ѯ
	 */
	public static void query(){
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//�������ݿ����Ӷ���
		Connection conn = null;
		
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//sql
			String sql = "select * from teacher";
			//����ִ��sql������
			Statement statement = conn.createStatement();
			//ִ��
			/*int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н��" + code);*/
			//�������������
			ResultSet rs = statement.executeQuery(sql);
			//���������
			while(rs.next()){  //�ж���û�м�¼������ָ��ָ����һ��
					//һ��ѭ��һ����¼
				//��ȡ������е�����
				//sql�Ĳ�ͬ�����صĽ��Ҳ��ͬ
				//��ȡ�������е�����
				//����д1/2/3Ҳ�У�����һ��д����
				int teaId = rs.getInt("teaId");
				String teaName = rs.getString("teaName");
				int teaSalary = rs.getInt("teaSalary");
				char teaGender = rs.getString("teaGender").charAt(0);
				int teaAge = rs.getInt("teaAge");
				
				//��װteacher����
				Teacher tea = new Teacher();
				tea.setTeaId(teaId);
				tea.setTeaName(teaName);
				tea.setTeaSalary(teaSalary);
				tea.setTeaGender(teaGender);
				tea.setTeaAge(teaAge);
				
				//��ӡ���
				System.out.println(tea);
			}
			
			rs.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
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
