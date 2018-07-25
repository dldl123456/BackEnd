package dao;

import java.util.List;

import entity.Movie;

/**
 * ������Ӱ���ݿ�ӿ�
 * @author Administrator
 *
 */
public interface MovieDao {
	/**
	 * ��ӵ�Ӱ��Ϣ������
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int addMovie(Movie movie) throws Exception;
	/**
	 * ɾ����Ӱ��Ϣ��ɾ��
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int deleteMovie(String MovieName) throws Exception;
	/**
	 * �޸ĵ�Ӱ��Ϣ
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovie(Movie movie) throws Exception;
	/**
	 * �޸ĵ�Ӱ״̬
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovieStatus(String movieName,int status) throws Exception;
	/**
	 * �޸ĵ�Ӱ����
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovieSorce(String movieName,double score) throws Exception;
	/**
	 * ��ѯ������Ӱ��Ϣ
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public Movie queryMovie(String movieName) throws Exception;
	/**
	 * ���ݵ�Ӱid���ҵ�Ӱ
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public Movie queryMovieById(int movieId) throws Exception;
	/**
	 * ��ѯ���е�Ӱ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Movie> queryMovies() throws Exception;
	/**
	 * ��Ӱ���а�
	 * @return
	 * @throws Exception
	 */
	public List<Movie> moviesRankList() throws Exception;
	/**
	 * ��������movieID�Ƿ����
	 * @param inputMovieId
	 * @return
	 * @throws Exception
	 */
	public int comparisonMovieId(int inputMovieId) throws Exception;
	/**
	 * ��������movieName�Ƿ����
	 * @param inputMovieId
	 * @return
	 * @throws Exception
	 */
	public int comparisonMovieName(String inputMovieName) throws Exception;
}
