package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC2 {
	/**
	 * 规范写法
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
	 * 添加
	 */
	public static void insert(){
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
			//sql
			String sql = "INSERT INTO teacher VALUES (119,\"Tom\",5000,\"男\",28)";
			//创建执行sql语句对象
			Statement statement = conn.createStatement();
			//执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果" + code);
			
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
	 * 修改
	 */
	public static void update(){
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
			//sql
			String sql = "update teacher set teaName=\"小明\" where teaId=119";
			//创建执行sql语句对象
			Statement statement = conn.createStatement();
			//执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果" + code);
			
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
	 * 修改
	 * 用PreparedStatement对象
	 */
	public static void update2(){
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
			//sql
			String sql = "update teacher set teaName=?, teaSalary=?, teaGender=?, teaAge=? where teaId=?";
			//String sql = "update teacher set teaName=?, teaSalary=?, teaGender=?, teaAge=? where teaId=111";
			//创建执行sql语句对象
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "小明");
			ps.setInt(2, 1000000);
			ps.setString(3, "女");
			ps.setInt(4, 99);
			ps.setInt(5, 104);
			/*ps.setString(1, "小明");
			ps.setInt(2, 1000000);
			ps.setString(3, "女");
			ps.setInt(4, 99);*/
			
			//执行
			int code = ps.executeUpdate();
			System.out.println("更新执行结果" + code);
			
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
	 * 删除
	 */
	public static void delete(){
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
			//sql
			String sql = "delete from teacher where teaId=120";
			//创建执行sql语句对象
			Statement statement = conn.createStatement();
			//执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果" + code);
			
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
	 */
	public static void query(){
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
			String sql = "select * from teacher";
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
