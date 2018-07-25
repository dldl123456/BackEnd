package com.iotek.service;

import java.sql.Timestamp;
import java.util.List;
import com.iotek.entity.Admin;
import com.iotek.entity.Movie;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;


public interface IAdminFunctions {
	/**
	 * 管理员登陆功能
	 * @return
	 */
	public Admin login();
	/**
	 * 打开操作电影的界面
	 */
	public void movieOptions();
	/**
	 * 查看因为某些原因下架的电影
	 * （已经上映过无法删除的电影）
	 * @return
	 */
	public List<Movie> selectDeletedMovies();
	/**
	 * 设置电影状态
	 * @param m
	 * @return
	 */
	public boolean setMovieStatus(Movie m);
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
	public void movieOptions(Movie m);
	/**
	 * 从电影表中选择电影
	 * @param mls
	 * @return
	 */
	public Movie selectMovie(List<Movie> mls);
	/**
	 * 添加电影
	 * @return
	 */
	public boolean addMovie();
	/**
	 * 更细电影
	 * @param m
	 * @return
	 */
	public boolean updateMovie(Movie m);
	/**
	 * 删除电影
	 * 不能删除的下架
	 * @param m
	 * @return
	 */
	public boolean deleteMovie(Movie m);
	/**
	 * 查找所有电影
	 * @return
	 */
	public List<Movie> selectAllMovies();
	
	/**
	 * 搜索电影
	 * @return
	 */
	public Movie selectMovie();
	/**
	 * 电影票功能
	 * @param u
	 */
	public void ticketOptions();
	/**
	 * 查看用户的所有票
	 * @param u
	 * @return
	 */
	public List<Ticket> selectTickets();
	/**
	 * 影院功能
	 * @param u
	 */
	public void theaterOptions();
	/**
	 * 查看所有电影院
	 * @return
	 */
	public List<Theater> selectTheaters();
	/**
	 * 获取已经关闭的电影院列表
	 * @return
	 */
	public List<Theater> selectClosedTheater();
	/**
	 * 从电影院列表中选择电影院
	 * @param tls
	 * @return
	 */
	public Theater getTheater(List<Theater> tls);
	/**
	 * 电影院操作界面
	 * @param t
	 */
	public void theaterOptions(Theater t);
	/**
	 * 添加电影院
	 */
	public void addTheater();
	/**
	 * 删除电影院
	 * 1.不能删除的关闭
	 * @param t
	 * @return
	 */
	public boolean deleteTheater(Theater t);
	/**
	 * 更新电影院信息
	 * @param t
	 * @return
	 */
	public boolean updateTheater(Theater t);
	/**
	 * 通过电影院查询所有相关的影厅
	 * @param t
	 * @return
	 */
	public List<ShowHall> selectShowHalls(Theater t);
	/**
	 * 从影厅列表中选择影厅
	 * @param shls
	 * @return
	 */
	public ShowHall getShowHall(List<ShowHall> shls);
	/**
	 * 展示影厅操作
	 * @param sh
	 */
	public void showhallOptions(ShowHall sh);
	/**
	 * 设置电影院状态
	 * @param t
	 * @return
	 */
	public boolean setTheaterStatus(Theater t);
	/**
	 * 添加影厅
	 * @param sh
	 * @return
	 */
	public boolean addShowHall(ShowHall sh);
	/**
	 * 更新影厅信息
	 * @param sh
	 * @return
	 */
	public boolean updateShowHall(ShowHall sh);
	/**
	 * 判断影厅是否能被删除
	 * @param sh
	 * @return
	 */
	public boolean deleteShowHall(ShowHall sh);
	/**
	 * 判断场次时间是否能被添加
	 * @param time
	 * @param m
	 * @param hall
	 * @return
	 */
	public boolean showtimeIsOk(Timestamp time,Movie m,ShowHall hall);
	/**
	 * 场次选项
	 */
	public void showplanOptions();
	/**
	 * 单场场次的操作选项
	 * @param sp
	 */
	public void showplanOptions(ShowPlan sp);
	/**
	 * 获取所有未被下架电影的场次
	 * @return
	 */
	public List<ShowPlan> getShowPlans();
	/**
	 * 通过电影来查询场次信息
	 * @param m
	 * @return
	 */
	public List<ShowPlan> getShowPlans(Movie m);
	/**
	 * 从列表中选择单场电影场次信息
	 * @param spls
	 * @return
	 */
	public ShowPlan getShowPlan(List<ShowPlan> spls);
	/**
	 * 未选中电影，先选择电影在添加场次
	 * @return
	 */
	public boolean addShowPlan();
	/**
	 * 添加场次（选择了电影的情况下）
	 * @param m
	 * @return
	 */
	public boolean addShowPlan(Movie m);
	/**
	 * 删除场次
	 * @param sp
	 * @return
	 */
	public boolean deleteShowPlan(ShowPlan sp);
	/**
	 * 更新场次信息
	 * @param sp
	 * @return
	 */
	public boolean updateShowPlan(ShowPlan sp);
	/**
	 * 修改密码
	 * @param u
	 */
	public boolean updatePsw(Admin ad);
	/**
	 * 修改用户个人信息
	 * @param u
	 */
	public void updateAdmin(Admin ad);
	/**
	 * 注册管理员
	 * @param ad
	 */
	public boolean register(Admin ad);

}
