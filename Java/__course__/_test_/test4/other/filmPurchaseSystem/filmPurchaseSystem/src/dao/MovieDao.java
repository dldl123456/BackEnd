package dao;

import java.util.List;

import entity.Movie;

/**
 * 操作电影数据库接口
 * @author Administrator
 *
 */
public interface MovieDao {
	/**
	 * 添加电影信息（增）
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int addMovie(Movie movie) throws Exception;
	/**
	 * 删除电影信息（删）
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int deleteMovie(String MovieName) throws Exception;
	/**
	 * 修改电影信息
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovie(Movie movie) throws Exception;
	/**
	 * 修改电影状态
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovieStatus(String movieName,int status) throws Exception;
	/**
	 * 修改电影评分
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int updateMovieSorce(String movieName,double score) throws Exception;
	/**
	 * 查询单个电影信息
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public Movie queryMovie(String movieName) throws Exception;
	/**
	 * 根据电影id查找电影
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public Movie queryMovieById(int movieId) throws Exception;
	/**
	 * 查询所有电影信息
	 * @return
	 * @throws Exception
	 */
	public List<Movie> queryMovies() throws Exception;
	/**
	 * 电影排行榜
	 * @return
	 * @throws Exception
	 */
	public List<Movie> moviesRankList() throws Exception;
	/**
	 * 遍历查找movieID是否存在
	 * @param inputMovieId
	 * @return
	 * @throws Exception
	 */
	public int comparisonMovieId(int inputMovieId) throws Exception;
	/**
	 * 遍历查找movieName是否存在
	 * @param inputMovieId
	 * @return
	 * @throws Exception
	 */
	public int comparisonMovieName(String inputMovieName) throws Exception;
}
