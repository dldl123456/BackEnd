package com.itzzb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itzzb.pojo.User;
import com.itzzb.util.JDBCTemplate;
import com.itzzb.util.PreparedStatementSetter;
import com.itzzb.util.RsCallBackHandler;

public class UserDao extends JDBCTemplate{
	private String upass=null;
	
	public String loginDao(String uname){
		String sql="select upass from users where uname=?";
		this.query(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,uname);
			}
		}, new RsCallBackHandler(){
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				while(rs.next()){
					upass=rs.getString(1);
				}
			}
		});
		return upass;
	}
	
	public int saveUser(User user){
		int res=-1;
		String sql="insert into users(uname,upass,sex,address) values(?,?,?,?)";
		res=this.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,user.getUname());
				pstmt.setString(2,user.getUpass());
				pstmt.setString(3,user.getSex());
				pstmt.setString(4,user.getAddress());
			}
		});
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
