package service;

public interface SessionService {
	/**
	 * 管理员添加场次的功能
	 * @throws Exception
	 */
	public void adminFunctionAddSession() throws Exception;
	/**
	 * 管理员删除场次的功能
	 */
	public void adminFunctionDeleteSession() throws Exception;
	/**
	 * 修改场次名称
	 */
	public void adminFunctionUpdateSessionName() throws Exception;
	/**
	 * 管理员查看所有场次的功能
	 */
	public void adminFunctionSeeAllSession() throws Exception;
	
	/**
	 * 管理员查看某个影院所有场次院的功能
	 */
	public void adminFunctionSeeCinemaAllSession() throws Exception;
	
	/**
	 * 管理员查看某个电影所有场次院的功能
	 */
	public void adminFunctionSeeMovieAllSession() throws Exception;
	
	/**
	 * 管理员查看某个影院某个电影所有场次院的功能
	 */
	public void adminFunctionSeeCinemaMovieAllSession() throws Exception;
	
	
	/**
	 * 管理员查看单个场次信息的功能
	 */
	public void aadminFunctionSeeSession() throws Exception;
}
