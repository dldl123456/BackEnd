package service;

public interface AdminService {
	/**
	 * 管理员登录功能
	 * @throws Exception
	 */
	public void adminFunctionLogin() throws Exception;
	/**
	 * 管理员管理电影功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseMovie() throws Exception;
	
	/**
	 * 管理员管理电影院功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseCinmea() throws Exception;
	
	/**
	 * 管理员管理影厅功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseHall() throws Exception;
	
	/**
	 * 管理员管理座位功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseSeat() throws Exception;
	
	/**
	 * 管理员管理城市功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseCity() throws Exception;
	/**
	 * 管理员管理场次功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseSession() throws Exception;
	
	/**
	 * 管理员管理用户功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseUser() throws Exception;
	
	/**
	 * 管理员管理用户评价功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseAssessment() throws Exception;
	
	/**
	 * 管理员管理电影票功能
	 * @throws Exception
	 */
	public void adminFunctionsuperviseFilmTicket() throws Exception;
}
