package com.iotek.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接帮助类
 * @author Administrator
 *
 */
public class DbHelp {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///mydatabase";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	// 利用静态代码块来加载驱动,确保只加载一次
	// 加载驱动一般只加载一次
	static {
		try {
			// 把driver注册到DriverManage 上面
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 改方法用于返回一个一个连接,这个连接就是用来打开与数据库质检关联
	 * 
	 * 1:先加载驱动
	 * 2:获取链接
	 */
	public Connection getConnection() {

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("驱动注册失败..");
		}
		return null;

	}
	/**
	 * 用于关闭所有的链接
	 * 关闭数据的链接,有顺序???
	 * --- 先开的后关
	 * @param conn
	 * @param ps
	 * @param conn
	 */ 
	
	public void closeAll( Connection conn,PreparedStatement ps,ResultSet rs) {
		if ( rs!= null) {
			try {
				rs.close();//流关闭
				rs = null; //目的是为了让垃圾回收机制回收
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( ps!= null) {
			try {
				ps.close();//流关闭
				ps = null; //目的是为了让垃圾回收机制回收
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( conn!= null) {
			try {
				conn.close();//流关闭
				conn = null; //目的是为了让垃圾回收机制回收
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
