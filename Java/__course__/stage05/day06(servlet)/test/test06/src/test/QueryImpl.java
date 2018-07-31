package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryImpl {
	private DbHelp db;
	private Connection conn;
	
	//构造方法初始化
	public QueryImpl() {
		db = new DbHelp();
	}

	//查询
	public void query() {
		conn = db.getConnection();
		String sql = "SELECT e.name, e.age, d.name AS dname "
				+ "From employees e INNER JOIN dept d On e.dept_id = d.id";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//一条一条的记录信息
			System.out.println("姓名    年龄    所在部门");
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
	
	//测试数据库是否链接成功并获取到数据
	public static void main(String[] args) {
		QueryImpl qim = new QueryImpl();
		qim.query();
	}
}
