package service;

public interface SeatService {
	
	/**
	 * 添加座位
	 */
	public void seatFunctionAdd() throws Exception;
	/**
	 * 根据id删除座位
	 */
	public void seatFunctionDeleteById() throws Exception;
	/**
	 * 根据行号和厅号删除整行座位
	 */
	public void seatFunctionDeleteByRowHall() throws Exception;
	/**
	 * 根据列号和厅号删除整列座位
	 */
	public void seatFunctionDeleteByRankHall() throws Exception;
	/**
	 * 修改单个座位状态
	 */
	public void seatFunctionUpdateStatusById(int seatId) throws Exception;
	/**
	 * 恢复整个厅座位状态
	 */
	public void seatFunctionUpdateStatusByHall() throws Exception;
	/**
	 * 查看所有座位
	 */
	public void seatFunctionSeeAll() throws Exception;
	/**
	 * 查看某个厅所有座位
	 */
	public void seatFunctionSeeHallAllSeat() throws Exception;
}
