package dao;

import java.util.List;

import entity.Movie;

/**
 * 
 * @param ����Ӱ���ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface MovieDao {
	//��ӵ�Ӱ
	public int addMovie(Movie movie);
	
	//��ѯ���е�Ӱ��Ϣ
	public List<Movie> querryMovies();
	
	//����idɾ����Ӱ
	public int deleteMovie(int id);
	
	
}
