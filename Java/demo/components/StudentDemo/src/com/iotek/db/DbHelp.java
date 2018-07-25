package com.iotek.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ����Ӱ�����
 * @author Administrator
 *
 */
public class DbHelp {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///mydatabase";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	// ���þ�̬���������������,ȷ��ֻ����һ��
	// ��������һ��ֻ����һ��
	static {
		try {
			// ��driverע�ᵽDriverManage ����
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ķ������ڷ���һ��һ������,������Ӿ��������������ݿ��ʼ����
	 * 
	 * 1:�ȼ�������
	 * 2:��ȡ����
	 */
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
	/**
	 * ���ڹر����е�����
	 * �ر����ݵ�����,��˳��???
	 * --- �ȿ��ĺ��
	 * @param conn
	 * @param ps
	 * @param conn
	 */ 
	
	public void closeAll( Connection conn,PreparedStatement ps,ResultSet rs) {
		if ( rs!= null) {
			try {
				rs.close();//���ر�
				rs = null; //Ŀ����Ϊ�����������ջ��ƻ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( ps!= null) {
			try {
				ps.close();//���ر�
				ps = null; //Ŀ����Ϊ�����������ջ��ƻ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( conn!= null) {
			try {
				conn.close();//���ر�
				conn = null; //Ŀ����Ϊ�����������ջ��ƻ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
