package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IShowHallDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.ShowHall;
import com.iotek.entity.Theater;

public class ShowHallDao implements IShowHallDao{
	private DbHelp db=null;
	private Connection conn=null;
	//private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public ShowHallDao(){
		db=new DbHelp();
	}
	@Override
	public boolean addShowHall(ShowHall hall) {
		String sql="insert into showhalls (id,title,theaterId,ros,cos) values (null,?,?,?,?)";
		if(hall==null){
			return false;
		}
		String sql2="update theaters set status='2' where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, hall.getTitle());
			ps.setInt(2, hall.getTheaterId());
			ps.setInt(3, hall.getRows());
			ps.setInt(4, hall.getColums());
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, hall.getTheaterId());
				int j=ps.executeUpdate();
				if(j!=0){
					System.out.println("电影院更新成功");
				}
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean deleteShowHall(ShowHall hall) {
		if(hall==null){
			return false;
		}
		String sql="delete from showhalls where id=? and title=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, hall.getId());
			ps.setString(2, hall.getTitle());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public List<ShowHall> selectAllShowHalls(Theater t) {
		if(t==null){
			return null;
		}
		String sql="select h.id,h.title,h.theaterId,h.ros,h.cos from "
				+ " showhalls h inner join theaters t on h.theaterId=t.id"
				+ " where t.id=?";
		List<ShowHall> shls =new ArrayList<>();
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				ShowHall hall=new ShowHall();
				hall.setId(rs.getInt(1));
				hall.setTitle(rs.getString(2));
				hall.setTheaterId(rs.getInt(3));
				hall.setRows(rs.getInt(4));
				hall.setColums(rs.getInt(5));
				hall.setTheater(t);
				shls.add(hall);
			}
			return shls;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return null;
	}

	@Override
	public ShowHall selectShowHall(int id) {
		String sql="select h.title,h.theaterId,h.ros,h.cos,t.name,t.adress from "
				+ " showhalls h inner join theaters t on h.theaterId=t.id"
				+ " where h.id=?";
		ShowHall hall=null;
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				hall=new ShowHall();
				hall.setId(id);
				hall.setTitle(rs.getString(1));
				hall.setTheaterId(rs.getInt(2));
				hall.setRows(rs.getInt(3));
				hall.setColums(rs.getInt(4));
				Theater t=new Theater();
				t.setId(rs.getInt(2));
				t.setName(rs.getString(5));
				t.setAdress(rs.getString(6));
				hall.setTheater(t);
				return hall;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return null;
	}
	@Override
	public boolean updateShowHall(ShowHall hall) {
		if(hall==null){
			return false;
		}
		String sql="update showhalls set title=?,cos=?,ros=?,theaterId=？ where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, hall.getTitle());
			ps.setInt(2, hall.getColums());
			ps.setInt(3, hall.getRows());
			ps.setInt(4, hall.getTheaterId());
			ps.setInt(5, hall.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}	
}
