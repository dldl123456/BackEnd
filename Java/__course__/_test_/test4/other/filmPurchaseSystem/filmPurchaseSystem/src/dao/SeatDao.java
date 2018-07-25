package dao;

import java.util.List;

import entity.Seat;
/**
 * 操作座位数据库接口
 * @author Administrator
 *
 */
public interface SeatDao {
	/**
	 * 添加座位信息（增）
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int addSeat(Seat seat) throws Exception;
	/**
	 * 根据ID删除座位（删）
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatById(int seatId) throws Exception;
	/**
	 * 根据行号和厅号删除座位（删）
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatByRow(int row,int hallId) throws Exception;
	/**
	 * 根据列号和厅号删除座位（删）
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatByRank(int rank,int hallId) throws Exception;
	/**
	 * 删除影院被删的座位
	 */
	public void deleteSeatCinemaIsNull() throws Exception;
	/**
	 * 删除厅被删的座位
	 */
	public void deleteSeatHallIsNull() throws Exception;
	/**
	 * 根据id修改座位状态
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int updateSeatStatusById(int seatId,int status) throws Exception;
	/**
	 * 根据厅号修改座位状态
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int updateSeatStatusByHall(int hallId,int status) throws Exception;
	/**
	 * 查询所有座位信息
	 * @return
	 * @throws Exception
	 */
	public List<Seat> querySeats() throws Exception;
	
	/**
	 * 查询某个厅所有座位信息
	 * @return
	 * @throws Exception
	 */
	public List<Seat> querySeatsByHall(int hallId) throws Exception;
	/**
	 * 查询某个座位
	 * @param SeatId
	 * @return
	 * @throws Exception
	 */
	public Seat querySeatById(int SeatId) throws Exception;
	/**
	 * 遍历查看座位是否存在
	 * @param inputSeatId
	 * @return
	 * @throws Exception
	 */
	public int comparisonSeatId(int inputSeatId,int hallId) throws Exception;
	public int comparisonSeatId(int inputSeatId) throws Exception;
}
