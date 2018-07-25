package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.Seat;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Ticket;
import com.iotek.entity.User;

public interface ITicketDao {
	/**
	 * 在数据库中添加对应场次的票
	 * 包含添加座位表
	 * 和支付功能
	 * 添加成功返回true
	 * 失败返回false
	 * @param u
	 * @param sp
	 * @return
	 */
	public boolean addTicket(User u,ShowPlan sp,int ro,int co);
	/**
	 * 数据库中添加对应得电影票
	 * @param t
	 * @return
	 */
	public boolean addTicket(Ticket t);
	/**
	 * 获取票的表中最大id值
	 * @return
	 */
	public int getMaxTicketId();
	/**
	 * 删除数据库中某个用户的某一张票
	 * 提醒：先删除座位
	 * 成功返回true
	 * 失败返回false
	 * @param u
	 * @param t
	 * @return
	 */
	public boolean deleteTicket(User u,Ticket t);
	/**
	 * 删除数据库中一系列的票（根据多个票的id来删除表）
	 *  提醒：先删除座位
	 * @param tls
	 * @return
	 */
	public int deleteTickets(List<Ticket> tls);
	/**
	 * 删除数据库中某一场次所有的票
	 *  提醒：先删除座位
	 * @param sp
	 * @return
	 */
	public int deleteTickets(ShowPlan sp);
	/**
	 * 删除数据库中的某一张票
	 *  提醒：先删除座位
	 * @param t
	 * @return
	 */
	public boolean deleteTicket(Ticket t);
	/**
	 * 查找数据库中所有的电影票
	 * @return
	 */
	public List<Ticket> selectAllTickets();
	
	/**
	 * 查找数据库中某一场次的所有票
	 * @param sp
	 * @return
	 */
	public List<Ticket> selectTickets(ShowPlan sp);
	/**
	 * 查找数据库中某张票
	 * @param ticketId
	 * @return
	 */
	public Ticket selectTicket(int ticketId);
	/**
	 * 查找数据库中某一用户的所有票
	 * @param u
	 * @return
	 */
	public List<Ticket> selectTickets(User u);
	/**
	 * 查找用户没有写的电影票
	 * @param u
	 * @return
	 */
	public List<Review> selectUnwriteTickets(User u);
	/**
	 * 查询数据库中某一电影已经售出的所有票
	 * @param m
	 * @return
	 */
	public List<Ticket> selectTickets(Movie m);
	public List<Seat> selectSeats(ShowPlan sp);
}
