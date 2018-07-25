package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IReviewDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.User;

public class ReviewDao implements IReviewDao {
	private DbHelp db=null;
	private Connection conn=null;
	/*private Statement st=null;*/
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public ReviewDao(){
		db=new DbHelp();
	}
	@Override
	public boolean addReview(Review r) {
		if(r==null){
			return false;
		}
		String sql="insert into reviews (id,movieId,ticketId,mark,review) values(null,?,?,?,?)";
		String sql3="select last_insert_id()";
		String sql2="update movies m inner join "
		+ "(select avg(mark) as mk,movieId as mId from reviews where movieId=?) r on m.id=r.mId "
		+ " set m.mark=r.mk ";
		int movieId=0;
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r.getMovie().getId());
			ps.setInt(2, r.getTickId());
			ps.setDouble(3, r.getMark());
			ps.setString(4, r.getComments());
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql3);
				rs=ps.executeQuery();
				if(rs.next()){
					movieId=rs.getInt(1);
					ps=conn.prepareStatement(sql2);
					ps.setInt(1, movieId);
					int j=ps.executeUpdate();
					if(j!=0){
						System.out.println("更新了电影评分");
					}
					return true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public Review selectReview(int id) {
		String sql="select r.id,m.id,m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime,"
				+ "r.mark,r.review,r.ticketId,u.name "
				+ " from reviews r inner join movies m on r.movieId=m.id"
				+ "inner join tickets t on t.id=r.ticketId "
				+ " inner join users u on t.userId =u.id "
				+ " where r.id =?";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			Review r=null;
			while(rs.next()){
				 r=new Review();
				r.setId(rs.getInt(1));
				Movie m=new Movie();
				m.setId(rs.getInt(2));
				m.setName(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setStars(rs.getString(5));
				m.setType(rs.getString(6));
				m.setMins(rs.getInt(7));
				m.setIntro(rs.getString(8));
				m.setMark(rs.getDouble(9));
				m.setStatus(rs.getString(10));
				m.setOpenTime(rs.getDate(11));
				r.setMovie(m);
				r.setMark(rs.getDouble(12));
				r.setComments(rs.getString(13));
				r.setTickId(rs.getInt(14));
				r.setUserName(rs.getString(15));
			}
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public List<Review> selectReview(User u) {
		List<Review> rls=new ArrayList<>();
		String sql="select r.id,m.id,m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime,"
				+ "r.mark,r.review,r.ticketId "
				+ " from reviews r inner join movies m on r.movieId=m.id"
				+ " inner join tickets t on t.id=r.ticketId "
				+ " where t.userId =? order by r.id desc";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				Review r=new Review();
				r.setId(rs.getInt(1));
				Movie m=new Movie();
				m.setId(rs.getInt(2));
				m.setName(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setStars(rs.getString(5));
				m.setType(rs.getString(6));
				m.setMins(rs.getInt(7));
				m.setIntro(rs.getString(8));
				m.setMark(rs.getDouble(9));
				m.setStatus(rs.getString(10));
				m.setOpenTime(rs.getDate(11));
				r.setMovie(m);
				r.setMark(rs.getDouble(12));
				r.setComments(rs.getString(13));
				r.setTickId(rs.getInt(14));
				r.setUserName(u.getName());
				rls.add(r);
			}
			return rls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public List<Review> selectReview(Movie m) {
		if(m==null){
			return null;
		}
		String sql="select r.id,r.ticketId,r.mark,r.review,u.name from reviews r "
				+ " inner join movies m on r.movieId =m.id"
				+ " inner join tickets t on r.ticketId=t.id"
				+ " inner join users u on t.userId =u.id"
				+ "	where m.id=? ";
		List<Review> rls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			rs=ps.executeQuery();
			Review r=null;
			while(rs.next()){
				 r=new Review();
				r.setId(rs.getInt(1));
				r.setMovie(m);
				r.setMark(rs.getDouble(3));
				r.setComments(rs.getString(4));
				r.setTickId(rs.getInt(2));
				r.setUserName(rs.getString(5));
				rls.add(r);
			}
			return rls;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public boolean updateReview(Review r) {
		String sql ="update reviews set mark=?,review=? where id=?";
		String sql2="update movies m inner join "
				+ "(select avg(mark) as mark,movieId from reviews where movieId=?) r on m.id=r.movieId "
				+ " set m.mark=r.mark ";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, r.getMark());
			ps.setString(2, r.getComments());
			ps.setInt(3, r.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, r.getMovie().getId());
				int j=ps.executeUpdate();
				if(j!=0){
					System.out.println("更新了电影评分");
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
	public boolean deleteReview(Review r) {
		String sql="delete from reviews where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
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
