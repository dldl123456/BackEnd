package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Movie;

public interface IMovieDao {
	/**
	 * 根据id查询某一部电影
	 * @param movieId
	 * @return
	 */
	public Movie selectMovie(int movieId);
	/**
	 * 查询所有未下架的电影
	 * @return
	 */
	public List<Movie> selecMovies();
	/**
	 * 根据电影名模糊查询电影
	 * @param movieName
	 * @return
	 */
	public List<Movie> selectMovies(String movieName);
	/**
	 * 根据评分查询电影
	 * 所有评分高于该评分的都被被返回
	 * @param mark
	 * @return
	 */
	public List<Movie> selecMovies(double mark);
	/**
	 * 查询榜单电影
	 * @return
	 */
	public List<Movie> selecTopMovies();
	/**
	 * 查询下架电影
	 * @return
	 */
	public List<Movie> selectDeletedMovies();
	/**
	 * 添加电影
	 * @param m
	 * @return
	 */
	public boolean addMovie(Movie m);
	/**
	 * 判断添加和修改的时候电影名是否合法
	 * @param name
	 * @return
	 */
	public boolean nameIsOK(String name);
	/**
	 * 删除电影
	 * @param m
	 * @return
	 */
	public boolean deleteMovie(Movie m);
	/**
	 * 下架电影
	 * @param m
	 * @return
	 */
	public boolean setMovie(Movie m);
	/**
	 * 更新电影信息
	 * @param m
	 * @return
	 */
	public boolean updateMovie(Movie m);
	/**
	 * 判断电影是否可以被删除
	 * @param m
	 * @return
	 */
	public boolean movieIsDelete(Movie m);
}
