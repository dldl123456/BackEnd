package com.iotek.dbHelp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.sql.PreparedStatement;


public class DbHelp {
		private final static String DRIVER="com.mysql.jdbc.Driver";
		private final static String URL="jdbc:mysql://localhost:3306/mydatebase";
		private final static String USER="root";
		private final static String PSW="dada";
		static {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//配置文件的方式
//	private static String DRIVER;
//	private static String URL;
//	private static String USER;
//	private static String PSW;
//	static{
//		Properties pr=new Properties();
//		InputStream is=DbHelp.class.getResourceAsStream("mysqlinfo.properties");
//		try {
//			pr.load(is);
//			DRIVER=pr.getProperty("DRIVER");
//			URL=pr.getProperty("URL");
//			USER=pr.getProperty("USER");
//			PSW=pr.getProperty("PASSWORD");
//			Class.forName(DRIVER);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		/**
		 * 获取数据库连接Connection
		 * @return
		 */
		public Connection getConnection(){
			Connection conn=null;
			try {
				conn=DriverManager.getConnection(URL, USER, PSW);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 关闭打开的Connection 和Statement（包括子类PreparedStatement） ResultSet这三个对象
		 * @param conn
		 * @param st
		 * @param rs
		 */
		public void closeAll(Connection conn,Statement st,ResultSet rs){
			if(conn!=null){
				try {
					conn.close();//关闭conn
					conn=null;//释放conn为null
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();//关闭st
					st=null;//释放st
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();//关闭rs
					rs=null;//释放rs
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		public static void main(String []args){
//			DbHelp db=new DbHelp();
//			Connection conn=db.getConnection();
//			//Statement st=null;
//			PreparedStatement ps=null;
//			ResultSet rs=null;
//			try {
//				
//				String sql="update movies set opentime=? where id=4";
//	//	st=conn.createStatement();
//				Timestamp time1=new Timestamp(new Date().getTime()); 
//			ps =conn.prepareStatement(sql);
//			ps.setTimestamp(1, time1);
//				int i=ps.executeUpdate();
//				System.out.println("ok"+i+time1.toString());
//				rs=ps.executeQuery("select opentime from movies where id=4");
//				while(rs.next()){
//					Timestamp time2=rs.getTimestamp(1);
//					System.out.println(time2.toString());
//				}
//			} catch (SQLException e) {
//				try {
//					conn.rollback();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				e.printStackTrace();
//			}finally{
//				db.closeAll(conn,ps,rs);
//			}
//			
//		}
}
