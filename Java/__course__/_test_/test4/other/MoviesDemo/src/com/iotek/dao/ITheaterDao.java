package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Theater;

public interface ITheaterDao {
	/**
	 * 查询电影院
	 * @param id
	 * @return
	 */
	public Theater selectTheater(int id);
	/**
	 * 根据影院名字模糊查询电影院
	 * @param name
	 * @return
	 */
	public List<Theater> selectTheaters(String name);
	/**
	 * 添加电影院
	 * @param t
	 * @return
	 */
	public boolean addTheater(Theater t);
	/**
	 * 删除电影院
	 * @param t
	 * @return
	 */
	public boolean deleteTheater(Theater t);
	/**
	 * 查询所有未关闭的电影院
	 * @return
	 */
	public List<Theater> selectTheaters();
	/**
	 * 查询所有关门的电影院
	 * @return
	 */
	public List<Theater> selectClosedTheaters();
	/**
	 * 判断影院能否被删除
	 * @param t
	 * @return
	 */
	public boolean theaterCanDeleted(Theater t);
	/**
	 * 更新电影院信息
	 * @param t
	 * @return
	 */
	public boolean updateTheater(Theater t);
	/**
	 * 对电影院实行关门和营业操作
	 * @param t
	 * @return
	 */
	public boolean setTheater(Theater t);
}
