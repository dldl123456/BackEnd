package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IMovieDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Movie;

public class MovieDao implements IMovieDao{
	private DbHelp db=null;
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public MovieDao(){
		db=new DbHelp();
	}
	@Override
	public Movie selectMovie(int movieId) {
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			rs=ps.executeQuery();
			if(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				return m;
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public List<Movie> selecMovies() {
		List<Movie> mls=new ArrayList<>();
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies where status <>'-1' order by id";
		conn=db.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				mls.add(m);
			}
			if(mls.isEmpty()){
				return null;
			}else{
				return mls;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}
	@Override
	public List<Movie> selectMovies(String movieName) {
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies where status<>'-1' and name like ?";
		movieName="%"+movieName+"%";
		List<Movie> mls=new ArrayList<>();
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, movieName);
			rs=ps.executeQuery();
			while(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				mls.add(m);
			}
			if(mls.isEmpty()){
				return null;
			}else{
				return mls;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return null;
	}
	@Override
	public List<Movie> selecMovies(double mark) {
		List<Movie> mls=new ArrayList<>();
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies where mark>? and status<>'-1' order by mark desc";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, mark);
			rs=ps.executeQuery();
			while(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				mls.add(m);
			}
			if(mls.isEmpty()){
				return null;
			}else{
				return mls;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	public List<Movie> selecTopMovies() {
		List<Movie> mls=new ArrayList<>();
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies  where status <>'-1' order by mark desc";
		conn=db.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				mls.add(m);
			}
			if(mls.isEmpty()){
				return null;
			}else{
				return mls;
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}
	@Override
	public List<Movie> selectDeletedMovies() {
		List<Movie> mls=new ArrayList<>();
		String sql="select id,name,director,stars,type,mins,intro,mark,status,opentime"
				+ " from movies where status ='-1' order by id";
		conn=db.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setStars(rs.getString(4));
				m.setType(rs.getString(5));
				m.setMins(rs.getInt(6));
				m.setIntro(rs.getString(7));
				m.setMark(rs.getDouble(8));
				m.setStatus(rs.getString(9));
				m.setOpenTime(rs.getDate(10));
				mls.add(m);
			}
			if(mls.isEmpty()){
				return null;
			}else{
				return mls;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}
	@Override
	public boolean addMovie(Movie m) {
		String sql="insert into movies (id,name,director,stars,type,intro,"
				+ "mins,mark,status,opentime)"
				+ "values (null,?,?,?,?,?,?,?,?,?)";
		String sql2="select last_insert_id()";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2,m.getDirector());
			ps.setString(3, m.getStars());
			ps.setString(4,m.getType());
			ps.setString(5, m.getIntro());
			ps.setInt(6, m.getMins());
			ps.setDouble(7, m.getMark());
			ps.setString(8,m.getStatus());
			ps.setDate(9, m.getOpenTime());
		   int i=ps.executeUpdate();
		   if(i!=0){
			   ps=conn.prepareStatement(sql2);
			   rs=ps.executeQuery();
			   if(rs.next()){
				   m.setId(rs.getInt(1));
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
	public boolean nameIsOK(String name) {
		try {
			String sql="SELECT * FROM movies where name=? ";
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
	public boolean deleteMovie(Movie m) {
		if(m==null){
			return  true;
		}
		String sql ="delete from movies where id=? and status=? ";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getStatus());
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
	public boolean setMovie(Movie m) {
		String sql ="update  movies set status=? where id=? ";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getStatus());
			ps.setInt(2, m.getId());
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
	public boolean updateMovie(Movie m) {
		String sql="update  movies set name=?,director=?,stars=?,type=?,intro=?,"
				+ "mins=?,mark=?,status=?,opentime=? where id=?";
				
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2,m.getDirector());
			ps.setString(3, m.getStars());
			ps.setString(4,m.getType());
			ps.setString(5, m.getIntro());
			ps.setInt(6, m.getMins());
			ps.setDouble(7, m.getMark());
			ps.setString(8,m.getStatus());
			ps.setDate (9, m.getOpenTime());
			ps.setInt(10, m.getId());
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
	public boolean movieIsDelete(Movie m) {
		if(m==null){
			return true;
		}
		String sql="select * from movies m"
				+ " inner join plans p  on m.id=p.movieId"
				+ "  where m.id=?";
		conn=db.getConnection();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn,ps, rs);
		}
		return false;
	}
}
