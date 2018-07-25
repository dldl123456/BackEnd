package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC3 {
	/**
	 * sql注入和解决
	 * @param args
	 */
	public static void main(String[] args) {
		//Statement --> 存在sql注入漏洞，一般不用
		
		String sql = "select * from teacher where teaId = 101";
		query(sql + " or 1=1");  //sql注入(1=1表示true or true)
		
		System.out.println("-------");
		
		/*
		 	如何解决sql注入？
		 	使用预编译sql语句的对象PreparedStatement，使用占位符，动态设置值
		 	主流写法
		 */
		query2();
		
		System.out.println("-------");
		
		//多个占位符
		query3();
	}
	
	/**
	 * 查询
	 */
	public static void query(String sql){
		//定义连接数据库的配置信息
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//声明数据库连接对象
		Connection conn = null;
		
		try {
			//加载驱动包
			Class.forName(driver);
			//创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//sql
			//String sql = "select * from teacher";
			//创建执行sql语句对象
			Statement statement = conn.createStatement();
			//执行
			/*int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果" + code);*/
			//创建结果集对象
			ResultSet rs = statement.executeQuery(sql);
			//遍历结果集
			while(rs.next()){  //判断有没有记录，并把指针指向下一条
					//一次循环一条记录
				//获取结果集中的数据
				//sql的不同，返回的结果也不同
				//获取具体列中的数据
				//索引写1/2/3也行，不过一般写列名
				int teaId = rs.getInt("teaId");
				String teaName = rs.getString("teaName");
				int teaSalary = rs.getInt("teaSalary");
				char teaGender = rs.getString("teaGender").charAt(0);
				int teaAge = rs.getInt("teaAge");
				
				//封装teacher对象
				Teacher tea = new Teacher();
				tea.setTeaId(teaId);
				tea.setTeaName(teaName);
				tea.setTeaSalary(teaSalary);
				tea.setTeaGender(teaGender);
				tea.setTeaAge(teaAge);
				
				//打印结果
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
	 * 查询
	 * 不使用Statement对象，解决sql注入问题
	 */
	public static void query2(){
		//定义连接数据库的配置信息
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//声明数据库连接对象
		Connection conn = null;
		
		try {
			//加载驱动包
			Class.forName(driver);
			//创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//sql
			String sql = "select * from teacher where teaId = ?";  //占位符
			//创建执行sql语句对象（实例化Statement的子类对象）表示预编译的 SQL 语句的对象,使用占位符
			//Statement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			//给占位符赋值（将指定参数设置为给定 Java int 值。）（第一个占位符，传入101）
			//第一个参数表示第（1）个问号，第二个参数表示第（1）个问号的值是101
			ps.setInt(1, 101);  //动态设置值
			//ps.setInt(1, 101 + " or 101=101");  //（再拼接显示语法错误）
			
			//执行查询，返回结果集
			//创建结果集对象   ---  记住，不要再次传入sql
			ResultSet rs = ps.executeQuery();
			//遍历结果集
			while(rs.next()){  //判断有没有记录，并把指针指向下一条
					//一次循环一条记录
				//获取结果集中的数据
				//sql的不同，返回的结果也不同
				//获取具体列中的数据
				//索引写1/2/3也行，不过一般写列名
				int teaId = rs.getInt("teaId");
				String teaName = rs.getString("teaName");
				int teaSalary = rs.getInt("teaSalary");
				char teaGender = rs.getString("teaGender").charAt(0);
				int teaAge = rs.getInt("teaAge");
				
				//封装teacher对象
				Teacher tea = new Teacher();
				tea.setTeaId(teaId);
				tea.setTeaName(teaName);
				tea.setTeaSalary(teaSalary);
				tea.setTeaGender(teaGender);
				tea.setTeaAge(teaAge);
				
				//打印结果
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
	 * 查询
	 * 多个占位符
	 */
	public static void query3(){
		//定义连接数据库的配置信息
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//声明数据库连接对象
		Connection conn = null;
		
		try {
			//加载驱动包
			Class.forName(driver);
			//创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//sql
			String sql = "select * from teacher where teaName=? and teaAge=?";  //占位符
			//创建执行sql语句对象（实例化Statement的子类对象）表示预编译的 SQL 语句的对象,使用占位符
			//Statement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Tom");
			ps.setString(2, "29");
			
			//执行查询，返回结果集
			//创建结果集对象   ---  记住，不要再次传入sql
			ResultSet rs = ps.executeQuery();
			//遍历结果集
			while(rs.next()){  //判断有没有记录，并把指针指向下一条
					//一次循环一条记录
				//获取结果集中的数据
				//sql的不同，返回的结果也不同
				//获取具体列中的数据
				//索引写1/2/3也行，不过一般写列名
				int teaId = rs.getInt("teaId");
				String teaName = rs.getString("teaName");
				int teaSalary = rs.getInt("teaSalary");
				char teaGender = rs.getString("teaGender").charAt(0);
				int teaAge = rs.getInt("teaAge");
				
				//封装teacher对象
				Teacher tea = new Teacher();
				tea.setTeaId(teaId);
				tea.setTeaName(teaName);
				tea.setTeaSalary(teaSalary);
				tea.setTeaGender(teaGender);
				tea.setTeaAge(teaAge);
				
				//打印结果
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
