package common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static  String DRIVER;
	private static  String URL;
	private static  String USER;
	private static  String PASSWORD;
	
	//��̬����飬����ص�ʱ��ͱ�ִ��һ��
	static{
		//������Ŵ������ļ��ж�ȡ����Ϣ
		Properties props = new Properties();
		//��ȡ�����ļ���ת����
		InputStream is = 
				ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties");
		
		try {
			//��ȡ���е���Ϣ
			props.load(is);
			//��ȡ���е���Ϣ�洢����̬������
			DRIVER = props.getProperty("mysql.driver");
			URL = props.getProperty("mysql.url");
			USER = props.getProperty("mysql.user");
			PASSWORD = props.getProperty("mysql.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			//��������(����ʵ����)
			Class.forName(DRIVER);
			//������ݿ�����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
	}
}