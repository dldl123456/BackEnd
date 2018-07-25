package dao;

import java.util.Date;
import java.util.List;

import entity.Session;
/**
 * 操作场次数据库接口
 * @author Administrator
 *
 */
public interface SessionDao {
	/**
	 * 添加场次（增）
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int addSession(Session session) throws Exception;
	/**
	 * 删除某个场次
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public int deleteSession(int sessionId) throws Exception;
	/**
	 * 修改场次信息
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int updateSession(Session session) throws Exception;
	/**
	 * 根据电影名称查询场次
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByMovieName(String movieName) throws Exception;
	/**
	 * 根据场次id查询场次
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public Session querySessionById(int sessionId) throws Exception;
	/**
	 * 根据影院名称查询场次信息
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByCinema(String cinemaName,String cityName) throws Exception;
	/**
	 * 根据影厅编号查询场次信息
	 * @param HallId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByHall(int HallId) throws Exception;
	/**
	 * 根据影院和电影名查看场次
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByCinemaMovie(String cinemaName,String movieName,String cityName) throws Exception;
	/**
	 * 查询所有场次信息
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessions() throws Exception;
	/**
	 * 遍历查看场次是否存在
	 * @param inputSessionId
	 * @return
	 * @throws Exception
	 */
	public int comparisonSessionId(int inputSessionId,String cinemaName,String movieName,String cityName) throws Exception;
	public int comparisonSessionHall(int hallId,Date time) throws Exception;
	public int comparisonSession(String movieName,Date time) throws Exception;
	public int comparisonSessionByid(int inputSessionId) throws Exception;
}
