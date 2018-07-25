package dao;

import java.util.List;

import entity.Movie;

/**
 * 
 * @param 给电影类提供数据接口
 * @author zmx2321
 *
 */

public interface MovieDao {
	//添加电影
	public int addMovie(Movie movie);
	
	//查询所有电影信息
	public List<Movie> querryMovies();
	
	//根据id删除电影
	public int deleteMovie(int id);
	
	
}
