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
 * @param ��Ӱ���Ʋ�
 * @author zmx2321
 * 
 */

public class MovieControl {
	static MovieService movieService = new MovieServiceImpl();
	static MovieDao movieDao = new MovieDaoImpl();
	
	//��ӵ�Ӱ
	public static void addMovie(){
		String movie_name = Help.getString("�������Ӱ���ƣ�");
		String movie_performer = Help.getString("��������Ա���Զ��Ÿ�����");
		String movie_length = Help.getString("�������Ӱʱ����");
		String movie_type = Help.getString("�������Ӱ���ͣ�");
		String movie_time = Help.getData("��������ӳ����(yyyy-MM-dd)��");
		int movie_score = Help.getInt("�������Ӱ���֣�");
		String movie_info = Help.getString("�������Ӱ��飺");
		
		Movie movie = new Movie(movie_name, movie_performer, movie_length, movie_type, movie_time, movie_score, movie_info);
		
		boolean success = movieService.addMovie(movie);
		
		if(success){
			System.out.println("��Ӱ��ӳɹ���\n");
		}else{
			System.out.println("��Ӱ���ʧ�ܣ�\n");
		}
	}
	
	//��ѯ��Ӱ
	public static void queryMovies(){
		List<Movie> movieList = movieDao.querryMovies();
		
		if (movieList.isEmpty()) {
			System.out.println("���޵�Ӱ��");
		}
		
		boolean success = movieService.querryEvaluate(movieList);
		
		if (success) {
			for(Movie movie : movieList){
				System.out.println(movie);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		movieList.clear();
	}
	
	//��ѯ��Ӱ����id
	public static void queryMoviesName(){
		List<Movie> movieList = movieDao.querryMovies();
		
		if (movieList.isEmpty()) {
			System.out.println("���޵�Ӱ��");
		}
		
		boolean success = movieService.querryEvaluate(movieList);
		
		if (success) {
			for(Movie movie : movieList){
				System.out.println(movie.getMovie_id() + "��" + movie.getMovie_name());
			}
			System.out.println();
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		movieList.clear();
	}
	
	//ɾ����Ӱ
	public static void deleteMovie(){
		queryMoviesName();
		
		int move_id = Help.getInt("��������Ҫɾ���ĵ�Ӱ��ţ�");
		
		boolean success = movieService.deleteMovie(move_id);
		
		if(success){
			System.out.println("��Ӱɾ���ɹ���\n");
			queryMoviesName();
		}else{
			System.out.println("��Ӱɾ��ʧ�ܣ�\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//��ӵ�Ӱ
		//addMovie();
		
		//��ѯ��Ӱ
		queryMovies();
		
		//��ѯ��Ӱ����id
		//queryMoviesName();
		
		//ɾ����Ӱ
		//deleteMovie();
	}
}
