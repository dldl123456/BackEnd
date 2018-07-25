package dbTest;
import java.sql.Connection;  //数据库连接类 （Connection）
import java.sql.DriverManager;  //驱动程序管理类（DriverManager）
import java.sql.ResultSet;  //结果集合类 （ResultSet）
import java.sql.SQLException;
import com.mysql.jdbc.Statement;  //声明类（Statement）

public class DbTest {
	public static void main(String[] args){
		Connection conn = null;  //准备一个连接对象
		
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//2.获得数据库链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3303/demo","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "select * from user";
		
		try{
			//3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//4.处理数据库的返回结果(使用ResultSet类)
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println("id="+id+","+"name="+name);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			//关闭资源
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