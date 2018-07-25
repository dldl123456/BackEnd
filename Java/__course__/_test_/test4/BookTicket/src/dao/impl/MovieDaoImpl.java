package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import dbhelp.DbHelp;
import entity.Movie;

/**
 * 
 * @param ʵ�ֵ�Ӱ�����ݽӿ�
 * @author zmx2321
 * 
 */

public class MovieDaoImpl implements MovieDao {
	private DbHelp db;
	private Connection conn;
	private List<Movie> list;
	
	//���췽����ʼ��
	public MovieDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}
	
	//��ӵ�Ӱ
	@Override
	public int addMovie(Movie movie){
		conn = db.getConnection();
		String sql = "insert into movie(`movie_name`, `movie_performer`, `movie_length`, `movie_type`, `movie_time`, `movie_score`, `movie_info`) values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps  = null;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, movie.getMovie_name());
			ps.setString(2, movie.getMovie_performer());
			ps.setString(3, movie.getMovie_length());
			ps.setString(4, movie.getMovie_type());
			ps.setString(5, movie.getMovie_time());
			ps.setInt(6, movie.getMovie_score());
			ps.setString(7, movie.getMovie_info());
			
			return ps.executeUpdate();//ִ�в��������ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//��ѯ���е�Ӱ��Ϣ
	@Override
	public List<Movie> querryMovies() {
		conn = db.getConnection();
		String sql = "select * from movie";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			Movie movie;
			//һ��һ���ؼ�¼��Ϣ
			while(rs.next()){
				int movie_id = rs.getInt("movie_id");
				String movie_name = rs.getString("movie_name");
				String movie_performer = rs.getString("movie_performer");
				String movie_length = rs.getString("movie_length");
				String movie_type = rs.getString("movie_type");
				String movie_time = rs.getString("movie_time");
				int movie_score = rs.getInt("movie_score");
				String movie_info = rs.getString("movie_info");
				
				movie = new Movie(movie_id, movie_name, movie_performer, movie_length, movie_type, movie_time, movie_score, movie_info);
			
				list.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	//����idɾ����Ӱ
	@Override
	public int deleteMovie(int movie_id) {
		conn = db.getConnection();
		String sql = "delete from movie where movie_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movie_id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//test
	public static void main(String[] args) {
		//ʵ�������ݿ�����ӿ�ʵ����
		MovieDaoImpl movieDao = new MovieDaoImpl();
		
		/*Movie movie = new Movie(
			"�Ҳ���ҩ��", 
			"��� / ������ / ��һΧ / ̷׿ / ���� / ������", 
			"117����", "ϲ��", "2018-07-05", 88, 
			"��ͨ�������ӳ��£���� �Σ���Ӫ��һ�ұ���Ʒ�꣬ʧ����ʧ�顣����֮�������棨������ �Σ��ĵ���������������һ��ȥӡ����ҩ����������������ҵ����Ȼ�������أ���������������ҩ֮·���Ϸ������̻���һ��������ʰ������������������Ѫ����ӡ�ȷ���ҩ���Ҵ����̡�"
		);*/
		
		//��ӵ�Ӱ
		//System.out.println(movieDao.addMovie(movie));
		
		//����idɾ����Ӱ
		//System.out.println(movieDao.deleteMovie(3));
		
		//��
		System.out.println("***** ��ѯ *****");
		List<Movie> movieList = movieDao.querryMovies();
		for(Movie movie1 : movieList){
			System.out.println(movie1);
		}
	}


}
