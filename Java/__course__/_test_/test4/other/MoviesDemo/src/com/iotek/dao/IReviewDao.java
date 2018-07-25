package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.User;

public interface IReviewDao {
	/**
	 * 查询某一个电影影评
	 * @param id
	 * @return
	 */
	public Review selectReview(int id);
	/**
	 * 查询某个用户写的影评
	 * @param u
	 * @return
	 */
	public List<Review> selectReview(User u);
	/**
	 * 查询某部电影的所有影评
	 * @param m
	 * @return
	 */
	public List<Review> selectReview(Movie m);
	/**
	 * 更新影评
	 * @param r
	 * @return
	 */
	public boolean updateReview(Review r);
	/**
	 * 添加影评
	 * @param r
	 * @return
	 */
	public boolean addReview(Review r);
	/**
	 * 删除影评
	 * @param r
	 * @return
	 */
	public boolean deleteReview(Review r);
}
