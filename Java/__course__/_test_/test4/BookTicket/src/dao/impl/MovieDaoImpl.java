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
 * @param 实现电影类数据接口
 * @author zmx2321
 * 
 */

public class MovieDaoImpl implements MovieDao {
	private DbHelp db;
	private Connection conn;
	private List<Movie> list;
	
	//构造方法初始化
	public MovieDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}
	
	//添加电影
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
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//查询所有电影信息
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
			//一条一条地记录信息
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

	//根据id删除电影
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
		//实例化数据库操作接口实现类
		MovieDaoImpl movieDao = new MovieDaoImpl();
		
		/*Movie movie = new Movie(
			"我不是药神", 
			"徐峥 / 王传君 / 周一围 / 谭卓 / 章宇 / 杨新鸣", 
			"117分钟", "喜剧", "2018-07-05", 88, 
			"普通中年男子程勇（徐峥 饰）经营着一家保健品店，失意又失婚。不速之客吕受益（王传君 饰）的到来，让他开辟了一条去印度买药做“代购”的新事业，虽然困难重重，但他在这条“买药之路”上发现了商机，一发不可收拾地做起了治疗慢粒白血病的印度仿制药独家代理商。"
		);*/
		
		//添加电影
		//System.out.println(movieDao.addMovie(movie));
		
		//根据id删除电影
		//System.out.println(movieDao.deleteMovie(3));
		
		//查
		System.out.println("***** 查询 *****");
		List<Movie> movieList = movieDao.querryMovies();
		for(Movie movie1 : movieList){
			System.out.println(movie1);
		}
	}


}
