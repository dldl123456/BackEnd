package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryImpl {
	private DbHelp db;
	private Connection conn;
	
	//���췽����ʼ��
	public QueryImpl() {
		db = new DbHelp();
	}

	//��ѯ
	public void query() {
		conn = db.getConnection();
		String sql = "SELECT e.name, e.age, d.name AS dname "
				+ "From employees e INNER JOIN dept d On e.dept_id = d.id";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//һ��һ���ļ�¼��Ϣ
			System.out.println("����    ����    ���ڲ���");
	        System.out.println("====================================");
	        while (rs.next()) {
	            String name = rs.getString("name");
	            String dname = rs.getString("dname");
	            int age = rs.getInt("age");
	            System.out.println(name + "  " + age + "   " + dname);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, rs);
		}
	}
	
	//�������ݿ��Ƿ����ӳɹ�����ȡ������
	public static void main(String[] args) {
		QueryImpl qim = new QueryImpl();
		qim.query();
	}
}
