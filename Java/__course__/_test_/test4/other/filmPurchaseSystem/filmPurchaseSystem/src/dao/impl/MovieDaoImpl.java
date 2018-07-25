package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import dbutil.DbADUClose;
import entity.Movie;

public class MovieDaoImpl extends DbADUClose implements MovieDao {

	@Override
	public int addMovie(Movie movie) throws Exception {
		String sql="insert into Movie values (default,?,?,?,?,?,?,?,?,?,?,default)";
		Object[] params = {movie.getMovieName(),movie.getMovieDirect(),movie.getMovieMainactor(),
				movie.getMovieType(),movie.getMovieLanguage(),movie.getMovieShowtime(),
				movie.getMovieTimelength(),movie.getMoviePrice(),movie.getMovieScore(),movie.getMovieIntroduce()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteMovie(String movieName) throws Exception {
		String sql="delete from movie where movie_name=?";
		Object[] params = {movieName};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int updateMovie(Movie movie) throws Exception {
		String sql="update movie set movie_name=?,movie_direct=?,movie_mainactor=?,movie_type=?,"
				+ "movie_language=?,movie_showtime=?,movie_timelength=?,movie_price=?,"
				+ "movie_score=?,movie_introduce=? where movie_id=?";
		Object[] params= {movie.getMovieName(),movie.getMovieDirect(),movie.getMovieMainactor(),
				movie.getMovieType(),movie.getMovieLanguage(),movie.getMovieShowtime(),
				movie.getMovieTimelength(),movie.getMoviePrice(),movie.getMovieScore(),
				movie.getMovieIntroduce(),movie.getMovieId()};
		return super.executeUpdate(sql, params);
	}
	@Override
	public int updateMovieStatus(String movieName,int status) throws Exception {
		String sql="update movie set movie_status=? where movie_name=?";
		Object[] params= {status,movieName};
		return super.executeUpdate(sql, params);
	}
	
	@Override
	public Movie queryMovie(String movieName) throws Exception {
		try {
			String sql="select * from movie where movie_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, movieName);
			rs=ps.executeQuery();
			if(rs.next()) {
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDirect(rs.getString(3));
				movie.setMovieMainactor(rs.getString(4));
				movie.setMovieType(rs.getString(5));
				movie.setMovieLanguage(rs.getString(6));
				movie.setMovieShowtime(rs.getString(7));
				movie.setMovieTimelength(rs.getString(8));
				movie.setMoviePrice(rs.getDouble(9));
				movie.setMovieScore(rs.getDouble(10));
				movie.setMovieIntroduce(rs.getString(11));
				movie.setMovieStatus(rs.getInt(12));
				return movie;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public Movie queryMovieById(int movieId) throws Exception {
		try {
			String sql="select * from movie where movie_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, movieId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDirect(rs.getString(3));
				movie.setMovieMainactor(rs.getString(4));
				movie.setMovieType(rs.getString(5));
				movie.setMovieLanguage(rs.getString(6));
				movie.setMovieShowtime(rs.getString(7));
				movie.setMovieTimelength(rs.getString(8));
				movie.setMoviePrice(rs.getDouble(9));
				movie.setMovieScore(rs.getDouble(10));
				movie.setMovieIntroduce(rs.getString(11));
				movie.setMovieStatus(rs.getInt(12));
				return movie;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public List<Movie> queryMovies() throws Exception {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			String sql ="select * from movie";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDirect(rs.getString(3));
				movie.setMovieMainactor(rs.getString(4));
				movie.setMovieType(rs.getString(5));
				movie.setMovieLanguage(rs.getString(6));
				movie.setMovieShowtime(rs.getString(7));
				movie.setMovieTimelength(rs.getString(8));
				movie.setMoviePrice(rs.getDouble(9));
				movie.setMovieScore(rs.getDouble(10));
				movie.setMovieIntroduce(rs.getString(11));
				movie.setMovieStatus(rs.getInt(12));
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public int updateMovieSorce(String movieName, double score) throws Exception {
		String sql="update movie set movie_score=? where movie_name=?";
		Object[] params= {score,movieName};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Movie> moviesRankList() throws Exception {
		try {
			List<Movie> movies = new ArrayList<Movie>();
			String sql ="select * from movie order by movie_score desc";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDirect(rs.getString(3));
				movie.setMovieMainactor(rs.getString(4));
				movie.setMovieType(rs.getString(5));
				movie.setMovieLanguage(rs.getString(6));
				movie.setMovieShowtime(rs.getString(7));
				movie.setMovieTimelength(rs.getString(8));
				movie.setMoviePrice(rs.getDouble(9));
				movie.setMovieScore(rs.getDouble(10));
				movie.setMovieIntroduce(rs.getString(11));
				movie.setMovieStatus(rs.getInt(12));
				movies.add(movie);
			}
			return movies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public int comparisonMovieId(int inputMovieId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryMovies().size();i++) {
			if(inputMovieId==queryMovies().get(i).getMovieId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}

	@Override
	public int comparisonMovieName(String inputMovieName) throws Exception {
		int Num = -1;//定义一个变量接收传回来的姓名
		for(int i=0;i<queryMovies().size();i++) {
			if(inputMovieName.equals(queryMovies().get(i).getMovieName())) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
