package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.UserDao;
import db.DButil;
import entity.User;

public class UserDaoImpl implements UserDao {
	private DButil db;  //数据库方法
	private Connection conn;  //连接
	private PreparedStatement pstmt;  //预编译
	
	//构造方法初始化
	public UserDaoImpl(){
		db = new DButil();
	}
	
	//实现添加用户
	@Override
	public int addUser(User user) {
		conn = db.getConnection();  //连接数据库
		String sql = "insert into tb_user (userName,psw,sex,loves) values(?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setString(4, user.getLoves());
            
            return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, pstmt, null);
		}
		
		return 0;
	}

	//test
	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		User u = new User("张三", "123123", "男", "aa");
		
		System.err.println(udi.addUser(u));
	}
}
