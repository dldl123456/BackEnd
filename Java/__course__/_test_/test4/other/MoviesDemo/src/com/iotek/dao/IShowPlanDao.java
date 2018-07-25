package com.iotek.dao;

import java.sql.Timestamp;
import java.util.List;

import com.iotek.entity.Movie;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;

public interface IShowPlanDao {
	/**
	 * 查找某一电影的所有场次(即将在影厅上映的)
	 * @param m
	 * @return
	 */
	public List<ShowPlan> selectShowPlans(Movie m);
	/**
	 * 查询一部电影所有场次
	 * @param m
	 * @return
	 */
	public List<ShowPlan> selectAllShowPlans(Movie m);
	/**
	 * 查找某一场次的具体情况
	 * @param planId
	 * @return
	 */
	public ShowPlan getShowPlan(int planId);
	/**
	 * 查找在某一影厅的播放的电影场次的详细信息
	 * @param hall
	 * @return
	 */
	public List<ShowPlan> selectShowPlans(ShowHall hall);
	/**
	 * 查找在某时间之后的电影场次
	 * @param time
	 * @return
	 */
	public List<ShowPlan> selectShowPlans(Timestamp time);
	/**
	 * 添加单场电影场次
	 * @param plan
	 * @return
	 */
	public int addShowPlan(ShowPlan plan);
	/**
	 * 添加多场电影场次
	 * @param pls
	 * @return
	 */
	public int addShowPlans(List<ShowPlan> pls);
	/**
	 * 判断场次是否能被删除
	 * @param sp
	 * @return
	 */
	public List<Ticket> canDelete(ShowPlan sp);
	/**
	 * 删除场次
	 * @param sp
	 * @return
	 */
	public boolean deleteShowPlan(ShowPlan sp);
	/**
	 * 判断添加的场次时间是否能被添加
	 * @param time
	 * @param btime
	 * @param atime
	 * @param hall
	 * @return
	 */
	public boolean timeIsOk(Timestamp time,Timestamp atime,ShowHall hall);
	/**
	 * 查询场次
	 * @return
	 */
	public List<ShowPlan> selectShowPlans();
	/**
	 * 添加场次
	 * @param t
	 * @return
	 */
	public List<ShowPlan> selectShowPlans(Theater t);
}
