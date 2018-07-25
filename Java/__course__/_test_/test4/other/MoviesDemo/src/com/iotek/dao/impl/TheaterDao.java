package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.iotek.dao.ITheaterDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Theater;

public class TheaterDao implements ITheaterDao {
	private DbHelp db=null;
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public TheaterDao(){
		db=new DbHelp();
	}
	@Override
	public List<Theater> selectTheaters(String name) {
		List<Theater> tls=new ArrayList<>();
		String sql="select id,name,adress,status from theaters where name like ?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			String str="%"+name+"%";
			ps.setString(1, str);
			rs=ps.executeQuery();
			while(rs.next()){
				Theater t=new Theater();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setAdress(rs.getString(3));
				t.setStatus(rs.getString(4));
				tls.add(t);
			}
			if(tls.isEmpty()){
				return null;
			}
			return tls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return null;
	}
	@Override
	public Theater selectTheater(int id) {
		String sql="select id,name,adress,status from theaters where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				Theater t=new Theater();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setAdress(rs.getString(3));
				t.setStatus(rs.getString(4));
				return t;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return null;
	}
	@Override
	public boolean addTheater(Theater t) {
		String sql="insert into theaters (id,name,adress,status) values (null,?,?,?)";
		String sql2="select last_insert_id()";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getAdress());
			ps.setString(3, t.getStatus());
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql2);
				rs=ps.executeQuery();
				if(rs.next()){
					t.setId(rs.getInt(1));
				}
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
	public boolean deleteTheater(Theater t) {
		String sql="delete from theaters where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
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
	public List<Theater> selectTheaters() {
		String sql="select id,name,adress,status from theaters where status<>'0'";
		List<Theater> tls=new ArrayList<>();
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Theater t=new Theater();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setAdress(rs.getString(3));
				t.setStatus(rs.getString(4));
				tls.add(t);
			}
			if(tls.isEmpty()){
				return null;
			}
			return tls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public boolean updateTheater(Theater t) {
		String sql="update theaters set name=?,adress=?,status=? where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getAdress());
			ps.setString(3, t.getStatus());
			ps.setInt(4, t.getId());
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
	public List<Theater> selectClosedTheaters() {
		String sql="select id,name,adress,status from theaters where status='0'";
		List<Theater> tls=new ArrayList<>();
		conn=db.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Theater t=new Theater();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setAdress(rs.getString(3));
				t.setStatus(rs.getString(4));
				tls.add(t);
			}
			if(tls.isEmpty()){
				return null;
			}
			return tls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}
	@Override
	public boolean theaterCanDeleted(Theater t) {
		String sql="select h.id,h.title,h.theaterId,h.ros,h.cos from "
				+ " showhalls h inner join theaters t on h.theaterId=t.id"
				+ " inner join plans p on p.hallId=h.id "
				+ " where t.id=? ";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean setTheater(Theater t) {
		String sql="update theaters set status=? where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getStatus());
			ps.setInt(2, t.getId());
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
