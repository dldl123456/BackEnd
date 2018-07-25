package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ����Ӱ�����
 */
public class DbHelp {
	//�������ݿ�����
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	//ע������
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//�������ݿ�
	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ע��ʧ��..");
		}
		return null;
	}
	
	//�ر����ݿ�
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs!= null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (ps!= null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn!= null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//�������ݿ��Ƿ����ӳɹ�
	public static void main(String[] args) {
		DbHelp d = new DbHelp();
		
		System.out.println(d.getConnection());
	}
}
