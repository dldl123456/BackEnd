/**
 * 通过Java程序（JDBC）完成第一题中对数据库的四个操作
 */

package test2;

import java.sql.Connection;  //数据库连接类 （Connection）
import java.sql.DriverManager;  //驱动程序管理类（DriverManager）
import java.sql.PreparedStatement;  //声明类（Statement）
import java.sql.ResultSet;  //结果集合类 （ResultSet）
import java.sql.SQLException;  //sql异常

public class JdbcTest {
	//测试类
	public static void main(String[] args) {
		fetchData();
	}

	//获取数据库返回的结果集
	private static void fetchData() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3303/test1";
		String user = "root";
		String pwd = "root";
		
		Connection conn = null;  //准备一个连接对象
		
		try {
			//1.加载驱动程序
			Class.forName(driver);
			
			//2.获得数据库链接
			conn = DriverManager.getConnection(url, user, pwd);
			
			//测试是否连接成功
			System.out.println(conn + "\n");
			
			//3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String sql = "SELECT NickName AS '昵称',Sex AS '性别',StarName AS '星座',BloodType AS '血型'"
					+ " FROM Users, Star, Blood"
					+ " WHERE Users.BloodTypeId=Blood.id AND Users.StarId=Star.id";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			//4.执行sql语句,处理数据库的返回结果(使用ResultSet类)
			System.out.println("昵称\t性别\t星座\t血型\n");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
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
					//关闭资源
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
