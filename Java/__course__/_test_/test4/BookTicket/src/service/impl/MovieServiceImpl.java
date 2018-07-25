package service.impl;

import java.util.List;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import entity.Movie;
import service.MovieService;

/**
 * 
 * @param ʵ�ֵ�Ӱ����ӿ�
 * @author zmx2321
 * 
 */

public class MovieServiceImpl implements MovieService {
	private static List<Movie> movielist = null;
	private int code = 0;  //sqlִ��״̬
	
	private MovieDao movieDao;
	
	public MovieServiceImpl() {
		movieDao = new MovieDaoImpl();
	}
	
	//��ӵ�Ӱ
	@Override
	public boolean addMovie(Movie movie){
		code = movieDao.addMovie(movie);
		
		return code == 0 ? false : true;
	}
	
	//��ѯ���е�Ӱ
	@Override
	public boolean querryEvaluate(List<Movie> movielist) {
		movielist = movieDao.querryMovies();
		
		return movielist == null ? false : true;
	}
	
	//ɾ����Ӱ
	@Override
	public boolean deleteMovie(int movie_id) {
		code = movieDao.deleteMovie(movie_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		MovieServiceImpl msi = new MovieServiceImpl();
		
		Movie movie = new Movie(
			"�Ҳ���ҩ��", 
			"��� / ������ / ��һΧ / ̷׿ / ���� / ������", 
			"117����", "ϲ��", "2018-07-05", 88, 
			"��ͨ�������ӳ��£���� �Σ���Ӫ��һ�ұ���Ʒ�꣬ʧ����ʧ�顣����֮�������棨������ �Σ��ĵ���������������һ��ȥӡ����ҩ����������������ҵ����Ȼ�������أ���������������ҩ֮·���Ϸ������̻���һ��������ʰ������������������Ѫ����ӡ�ȷ���ҩ���Ҵ����̡�"
		);
		
		//��ӵ�Ӱ
		System.out.println(msi.addMovie(movie));
		
		//��ѯ��������
		System.out.println(msi.querryEvaluate(movielist));
		
		//ɾ����Ӱ
		System.out.println(msi.deleteMovie(5));
	}
}
