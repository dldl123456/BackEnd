package com.iotek.service;

import java.util.List;

import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.Seat;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;
import com.iotek.entity.User;

public interface IUserFunctions {
	/**
	 * 用户注册功能
	 * 先输入用户名，如果用户名已经有了则重新注册，没有该用户名继续输入密码
	 * 注册成功输出注册成功，否则提示注册失败
	 * @return
	 */
	public boolean register();
	/**
	 * 用户登录功能
	 * 先后输入用户名，如果在数据库中查找到相应的用户，返回该用户的详细信息
	 * 否则返回null
	 * @return
	 */
	public User login();
	/**
	 * 所有电影功能
	 */
	public void movieOptions(User u);
	/**
	 * 查看所有电影
	 * @return
	 */
	public List<Movie> selectMovies();
	/**
	 * 选定电影后的操作选项
	 * @param u
	 * @param m
	 */
	public void movieOptions(User u,Movie m);
	/**
	 * 购票界面
	 * @param u
	 */
	public void tobuyTicket(User u,ShowPlan sp);
	public Movie selectMovie(List<Movie> mls);
	/**
	 * 搜索电影
	 * @return
	 */
	public Movie selectMovie();
	/**
	 * 电影票功能
	 * @param u
	 */
	public void ticketOptions(User u);
	/**
	 * 购票
	 * @param u
	 * @return
	 */
	public boolean buyTicket(User u,ShowPlan sp);
	/**
	 * 选择座位
	 * @return
	 */
	public Seat selectSeat(Ticket t);
	/**
	 * 选票
	 * @param sp
	 * @return
	 */
	public Seat selectSeat(List<Seat> sls,ShowHall hall);
	/**
	 * 查看用户的所有票
	 * @param u
	 * @return
	 */
	public List<Ticket> selectTickets(User u);
	/**
	 * 退票
	 * @return
	 */
	public boolean returnTicket(User u,Ticket t);
	/**
	 * 影院功能
	 * @param u
	 */
	public void theaterOptions(User u);
	/**
	 * 查看所有电影院
	 * @return
	 */
	public List<Theater> selectTheaters();
	/**
	 * 查看电影院
	 * @return
	 */
	public Theater selectTheater();
	/**
	 * 榜单功能
	 */
	public void topMovies(User u);
	/**
	 * 影评功能
	 * @param u
	 */
	public void reviewOptions(User u);
	/**
	 * 用户查看自己影评
	 * @param u
	 * @param rls
	 * @return
	 */
	public Review selectReview(User u,List<Review> rls);
	/**
	 * 添加影评
	 * @param u
	 * @param t
	 * @return
	 */
	public boolean addReview(User u,Ticket t);
	/**
	 * 修改影评
	 * @param u
	 * @param t
	 * @return
	 */
	public boolean updateReview(Review r);
	/**
	 * 删除影评
	 * @param reviewId
	 * @return
	 */
	public boolean deleteReview(Review r);
	/**
	 * 充值功能
	 * @param u
	 */
	public void rechargeOptions(User u);
	/**
	 * 修改密码
	 * @param u
	 */
	public boolean updatePsw(User u);
	/**
	 * 修改用户个人信息（待做）
	 * @param u
	 */
	public void updateUser(User u);
	/**
	 * 从电影院列表中获取电影院
	 * @param tls
	 * @return
	 */
	public Theater getTheater(List<Theater> tls);
	/**
	 * 通过电影院来查询有哪些场次在该电影院播放
	 * @param t
	 * @return
	 */
	public List<ShowPlan> getShowPlan(Theater t);
	/**
	 * 从场次表中选择场次
	 * @param spls
	 * @return
	 */
	public ShowPlan getShowPlan(List<ShowPlan> spls);
}
