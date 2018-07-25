package service;

import java.util.List;

import entity.Movie;

/**
 * 
 * @param 给电影服务提供接口
 * @author zmx2321
 *
 */

public interface MovieService {
	//添加电影
	public boolean addMovie(Movie movie);
	
	//查询所有电影
	public boolean querryEvaluate(List<Movie> movielist);
	
	//删除电影
	public boolean deleteMovie(int movie_id);
}
