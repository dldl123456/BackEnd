package contro;

import java.util.List;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import entity.Movie;
import service.MovieService;
import service.impl.MovieServiceImpl;
import util.Help;

/**
 * 
 * @param 电影控制层
 * @author zmx2321
 * 
 */

public class MovieControl {
	static MovieService movieService = new MovieServiceImpl();
	static MovieDao movieDao = new MovieDaoImpl();
	
	//添加电影
	public static void addMovie(){
		String movie_name = Help.getString("请输入电影名称：");
		String movie_performer = Help.getString("请输入演员，以逗号隔开：");
		String movie_length = Help.getString("请输入电影时长：");
		String movie_type = Help.getString("请输入电影类型：");
		String movie_time = Help.getData("请输入上映日期(yyyy-MM-dd)：");
		int movie_score = Help.getInt("请输入电影评分：");
		String movie_info = Help.getString("请输入电影简介：");
		
		Movie movie = new Movie(movie_name, movie_performer, movie_length, movie_type, movie_time, movie_score, movie_info);
		
		boolean success = movieService.addMovie(movie);
		
		if(success){
			System.out.println("电影添加成功！\n");
		}else{
			System.out.println("电影添加失败！\n");
		}
	}
	
	//查询电影
	public static void queryMovies(){
		List<Movie> movieList = movieDao.querryMovies();
		
		if (movieList.isEmpty()) {
			System.out.println("暂无电影！");
		}
		
		boolean success = movieService.querryEvaluate(movieList);
		
		if (success) {
			for(Movie movie : movieList){
				System.out.println(movie);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		movieList.clear();
	}
	
	//查询电影名和id
	public static void queryMoviesName(){
		List<Movie> movieList = movieDao.querryMovies();
		
		if (movieList.isEmpty()) {
			System.out.println("暂无电影！");
		}
		
		boolean success = movieService.querryEvaluate(movieList);
		
		if (success) {
			for(Movie movie : movieList){
				System.out.println(movie.getMovie_id() + "、" + movie.getMovie_name());
			}
			System.out.println();
		}else {
			System.out.println("查询失败！\n");
		}
		
		movieList.clear();
	}
	
	//删除电影
	public static void deleteMovie(){
		queryMoviesName();
		
		int move_id = Help.getInt("请输入您要删除的电影编号：");
		
		boolean success = movieService.deleteMovie(move_id);
		
		if(success){
			System.out.println("电影删除成功！\n");
			queryMoviesName();
		}else{
			System.out.println("电影删除失败！\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//添加电影
		//addMovie();
		
		//查询电影
		queryMovies();
		
		//查询电影名和id
		//queryMoviesName();
		
		//删除电影
		//deleteMovie();
	}
}
