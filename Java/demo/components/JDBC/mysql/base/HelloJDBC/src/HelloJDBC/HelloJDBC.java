package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HelloJDBC {
	/**
	 * ���ݿ��������Ϣ
	 * 1.�˺�  --> root
	 * 2.����  --> root
	 * 3.���ݿ���������ͬ�����ݿ⣬�������ǲ�ͬ�ģ�
	 *  mysql --> com.mysql.jdbc.Driver
	 * 	  ���ݿ������������jdk���棬�����ݿ��ṩ�ģ�
	 * 	  ����������Ҫȥ���ز���ӵ��������棬��jar�ķ�ʽ
	 * 4.���ʵ����ݿ��ַ(url)
	 *  jdbc:mysql://127.0.0.1:3306/test2/test2+����
	 *  Э��/��ַ/�˿�/���ݿ�����
	 *  ��http,dns,dhcp,stmp,ftp,https,pop3...��
	 *  �������ն˵�����ͨѶ�Ĺ淶��
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//�����������ݿ��������Ϣ
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//����
		//1.��������(��ҵ����)������driver�ࣩ
		Class.forName(driver);
		//2.�������ݿ�����
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//3.sql(ִ��sql�ַ���)
		String sql = "INSERT INTO teacher VALUES (109,\"Tom\",5000,\"��\",28)";
		//4.����ִ��sql������
		Statement statement = conn.createStatement();
		//5.ִ��
		int code = statement.executeUpdate(sql);
		System.out.println("����ִ�н��" + code);
		//6.�ر�����
		conn.close();
	}
}
