package com.itzzb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itzzb.pojo.User;
import com.itzzb.util.JDBCTemplate;
import com.itzzb.util.PageUtil;
import com.itzzb.util.PreparedStatementSetter;
import com.itzzb.util.RsCallBackHandler;

public class UserDao extends JDBCTemplate{
	private int count=-1;
	//index:代表当前页数
	public List<User> getUsers(int index){
		List<User> list=new ArrayList<User>();
		String sql="select * from users limit ?,?";
		this.query(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1,(index-1)*PageUtil.PAGE_SIZE);
				pstmt.setInt(2,PageUtil.PAGE_SIZE);
			}
		}, new RsCallBackHandler(){
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				while(rs.next()){
					User user=new User();
					user.setId(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setUpass(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setAddress(rs.getString(5));
					list.add(user);
				}
			}
		});
		return list;
	}
	//总记录数 根据总记录数计算出总页数
	public int getUserCount(){
		String sql="select count(*) from users";
		this.query(sql,null, new RsCallBackHandler() {
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					count=rs.getInt(1);
				}
			}
		});
		return count;
	}
	
	
	
	
	
	
	
}
