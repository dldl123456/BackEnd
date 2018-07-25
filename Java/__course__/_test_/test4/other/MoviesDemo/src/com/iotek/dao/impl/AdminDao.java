package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Statement;*/

import com.iotek.dao.IAdminDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Admin;

public class AdminDao implements IAdminDao{
	private DbHelp db=null;
	private Connection conn=null;
	/*private Statement st=null;*/
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public AdminDao(){
		db=new DbHelp();
	}
	@Override
	public Admin selectAdmin(int id) {
		try {
			String sql="SELECT id,name,psw,adress,sex,age,tel FROM admins where id=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			Admin ad=null;
			if(rs.next()){
				ad=new Admin();
				ad.setId(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setPsw(rs.getString(3));
				ad.setAdress(rs.getString(4));
				ad.setSex(rs.getString(5));
				ad.setAge(rs.getInt(6));
				ad.setTel(rs.getString(7));
			}
			return ad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public boolean nameIsOk(String name) {
		try {
			String sql="SELECT * FROM admins where name=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public Admin login(String name, String psw) {
		try {
			String sql="SELECT id,name,psw,adress,sex,age,tel FROM admins where name=? and psw=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, psw);
			rs=ps.executeQuery();
			Admin ad=null;
			if(rs.next()){
				ad=new Admin();
				ad.setId(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setPsw(rs.getString(3));
				ad.setAdress(rs.getString(4));
				ad.setSex(rs.getString(5));
				ad.setAge(rs.getInt(6));
				ad.setTel(rs.getString(7));
			}
			return ad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public boolean register(Admin ad) {
		if(ad==null){
			return false;
		}
		try {
			String sql="insert into admins "
					+ "(id,name,psw,adress,sex,age,tel)"
					+ " values (null,?,?,?,?,?,?)";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getPsw());
			ps.setString(3, ad.getAdress());
			ps.setString(4, ad.getSex());
			ps.setInt(5, ad.getAge());
			ps.setString(6, ad.getTel());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean updateAdmin(Admin ad) {
		if(ad==null){
			return false;
		}
		try {
			String sql="update admins set name=?,psw=?,"
					+ "adress=?,sex=?,age=?,tel=? where id=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getPsw());
			ps.setString(3, ad.getAdress());
			ps.setString(4, ad.getSex());
			ps.setInt(5, ad.getAge());
			ps.setString(6, ad.getTel());
			ps.setInt(7, ad.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean updatePsw(int adminId, String psw) {
		if(adminId<1){
			return false;
		}
		try {
			String sql="update admins set psw=? where id=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, psw);
			ps.setInt(2, adminId);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
}
