package service.impl;

import java.util.List;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import entity.Movie;
import service.MovieService;

/**
 * 
 * @param 实现电影服务接口
 * @author zmx2321
 * 
 */

public class MovieServiceImpl implements MovieService {
	private static List<Movie> movielist = null;
	private int code = 0;  //sql执行状态
	
	private MovieDao movieDao;
	
	public MovieServiceImpl() {
		movieDao = new MovieDaoImpl();
	}
	
	//添加电影
	@Override
	public boolean addMovie(Movie movie){
		code = movieDao.addMovie(movie);
		
		return code == 0 ? false : true;
	}
	
	//查询所有电影
	@Override
	public boolean querryEvaluate(List<Movie> movielist) {
		movielist = movieDao.querryMovies();
		
		return movielist == null ? false : true;
	}
	
	//删除电影
	@Override
	public boolean deleteMovie(int movie_id) {
		code = movieDao.deleteMovie(movie_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		MovieServiceImpl msi = new MovieServiceImpl();
		
		Movie movie = new Movie(
			"我不是药神", 
			"徐峥 / 王传君 / 周一围 / 谭卓 / 章宇 / 杨新鸣", 
			"117分钟", "喜剧", "2018-07-05", 88, 
			"普通中年男子程勇（徐峥 饰）经营着一家保健品店，失意又失婚。不速之客吕受益（王传君 饰）的到来，让他开辟了一条去印度买药做“代购”的新事业，虽然困难重重，但他在这条“买药之路”上发现了商机，一发不可收拾地做起了治疗慢粒白血病的印度仿制药独家代理商。"
		);
		
		//添加电影
		System.out.println(msi.addMovie(movie));
		
		//查询所有评论
		System.out.println(msi.querryEvaluate(movielist));
		
		//删除电影
		System.out.println(msi.deleteMovie(5));
	}
}
