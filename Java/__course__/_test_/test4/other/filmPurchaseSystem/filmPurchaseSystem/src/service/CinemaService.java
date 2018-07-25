package service;

public interface CinemaService {
	/**
	 * 管理员添加电影院的功能
	 * @throws Exception
	 */
	public void adminFunctionAddCinema() throws Exception;
	
	/**
	 * 管理员删除电影院的功能
	 */
	public void adminFunctionDeleteCinema() throws Exception;
	
	/**
	 * 管理员查看所有电影院的功能
	 */
	public void adminFunctionSeeAllCinema() throws Exception;
	
	/**
	 * 管理员查看某个城市所有电影院院的功能
	 */
	public void adminFunctionSeeCityAllCinema() throws Exception;
	
	/**
	 * 管理员查看单个电影院信息的功能
	 */
	public void aadminFunctionSeeCinema() throws Exception;
}
