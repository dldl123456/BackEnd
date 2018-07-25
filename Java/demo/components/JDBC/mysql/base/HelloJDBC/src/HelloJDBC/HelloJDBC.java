package HelloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HelloJDBC {
	/**
	 * 数据库的配置信息
	 * 1.账号  --> root
	 * 2.密码  --> root
	 * 3.数据库驱动（不同的数据库，驱动类是不同的）
	 *  mysql --> com.mysql.jdbc.Driver
	 * 	  数据库的驱动并不在jdk里面，是数据库提供的，
	 * 	  所以我们需要去下载并添加到工程里面，以jar的方式
	 * 4.访问的数据库地址(url)
	 *  jdbc:mysql://127.0.0.1:3306/test2/test2+参数
	 *  协议/地址/端口/数据库名称
	 *  （http,dns,dhcp,stmp,ftp,https,pop3...）
	 *  【两个终端的数据通讯的规范】
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//定义连接数据库的配置信息
		String username = "root",
			   password = "root",
			   driver = "com.mysql.jdbc.Driver",
			   url = "jdbc:mysql://127.0.0.1:3306/test2";
		
		//步骤
		//1.加载驱动(在业务里)（加载driver类）
		Class.forName(driver);
		//2.创建数据库链接
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//3.sql(执行sql字符串)
		String sql = "INSERT INTO teacher VALUES (109,\"Tom\",5000,\"男\",28)";
		//4.创建执行sql语句对象
		Statement statement = conn.createStatement();
		//5.执行
		int code = statement.executeUpdate(sql);
		System.out.println("更新执行结果" + code);
		//6.关闭连接
		conn.close();
	}
}
