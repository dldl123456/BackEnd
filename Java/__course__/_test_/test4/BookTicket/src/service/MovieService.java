package service;

import java.util.List;

import entity.Movie;

/**
 * 
 * @param ����Ӱ�����ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface MovieService {
	//��ӵ�Ӱ
	public boolean addMovie(Movie movie);
	
	//��ѯ���е�Ӱ
	public boolean querryEvaluate(List<Movie> movielist);
	
	//ɾ����Ӱ
	public boolean deleteMovie(int movie_id);
}
