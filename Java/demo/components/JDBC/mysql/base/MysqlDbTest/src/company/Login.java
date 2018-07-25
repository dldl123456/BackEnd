package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Login {
	public static void main(String[] args) {
		List<Employee> list = fetchData();
		for(Employee e:list){
			System.out.println(e);
		}
		
		//登录
		Employee employee = login("zmx", "44332");
		
		if(employee!=null){
			System.out.println("登录成功，欢迎" + employee.getName());
		}else{
			System.out.println("登录失败，请重新登录");
		}
	}
	
	private static Employee login(String name, String pwd){
		Employee employee = null;  //准备一个员工
		Connection conn = null;  //准备一个连接对象
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			
			String sql = "select * from employee where EmpName=? and Pwd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				employee = new Employee(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return employee;
	}

	private static List<Employee> fetchData() {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		Connection conn = null;
		
		//ctrl+alt+z
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			
			Statement sm = conn.createStatement();
			String sql = "select * from employee";
			ResultSet rs = sm.executeQuery(sql);
			
			while(rs.next()){  //查看是否有记录并执行下一条
				employee = new Employee(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(employee);
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
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
