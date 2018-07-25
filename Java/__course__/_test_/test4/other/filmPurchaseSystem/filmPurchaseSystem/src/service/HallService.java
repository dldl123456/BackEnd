package service;

public interface HallService {
	/**
	 * 管理员添加影厅的功能
	 * @throws Exception
	 */
	public void adminFunctionAddHall() throws Exception;
	
	/**
	 * 管理员删除影厅的功能
	 */
	public void adminFunctionDeleteHall() throws Exception;
	/**
	 * 修改影厅名称
	 */
	public void adminFunctionUpdateHallName() throws Exception;
	/**
	 * 管理员查看所有影厅的功能
	 */
	public void adminFunctionSeeAllHall() throws Exception;
	
	/**
	 * 管理员查看某个城市所有影厅院的功能
	 */
	public void adminFunctionSeeCityAllHall() throws Exception;
	
	/**
	 * 管理员查看单个影厅信息的功能
	 */
	public void aadminFunctionSeeHall() throws Exception;
}
