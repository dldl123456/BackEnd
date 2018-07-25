package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC3 {
	/**
	 * sqlע��ͽ��
	 * @param args
	 */
	public static void main(String[] args) {
		//Statement --> ����sqlע��©����һ�㲻��
		
		String sql = "select * from teacher where teaId = 101";
		query(sql + " or 1=1");  //sqlע��(1=1��ʾtrue or true)
		
		System.out.println("-------");
		
		/*
		 	��ν��sqlע�룿
		 	ʹ��Ԥ����sql���Ķ���PreparedStatement��ʹ��ռλ������̬����ֵ
		 	����д��
		 */
		query2();
		
		System.out.println("-------");
		
		//���ռλ��
		query3();
	}
	
	/**
	 * ��ѯ
	 */
	public static void query(String sql){
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
			//String sql = "select * from teacher";
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
	 * ��ʹ��Statement���󣬽��sqlע������
	 */
	public static void query2(){
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
			String sql = "select * from teacher where teaId = ?";  //ռλ��
			//����ִ��sql������ʵ����Statement��������󣩱�ʾԤ����� SQL ���Ķ���,ʹ��ռλ��
			//Statement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			//��ռλ����ֵ����ָ����������Ϊ���� Java int ֵ��������һ��ռλ��������101��
			//��һ��������ʾ�ڣ�1�����ʺţ��ڶ���������ʾ�ڣ�1�����ʺŵ�ֵ��101
			ps.setInt(1, 101);  //��̬����ֵ
			//ps.setInt(1, 101 + " or 101=101");  //����ƴ����ʾ�﷨����
			
			//ִ�в�ѯ�����ؽ����
			//�������������   ---  ��ס����Ҫ�ٴδ���sql
			ResultSet rs = ps.executeQuery();
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
	 * ���ռλ��
	 */
	public static void query3(){
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
			String sql = "select * from teacher where teaName=? and teaAge=?";  //ռλ��
			//����ִ��sql������ʵ����Statement��������󣩱�ʾԤ����� SQL ���Ķ���,ʹ��ռλ��
			//Statement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Tom");
			ps.setString(2, "29");
			
			//ִ�в�ѯ�����ؽ����
			//�������������   ---  ��ס����Ҫ�ٴδ���sql
			ResultSet rs = ps.executeQuery();
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
}
