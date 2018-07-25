package service;
public interface FilmTicketService {
	/**
	 * 添加电影票
	 */
	public void ticketFunctionAdd(int userId ,int cityId) throws Exception;
	/**
	 * 退票
	 */
	public void ticketFunctionRefund() throws Exception;
	/**
	 * 查看单个电影票
	 * @throws Exception
	 */
	/*public void ticketFunctionSee() throws Exception;*/
	/**
	 * 查看所有电影票
	 */
	public void ticketFunctionSeeAll() throws Exception;
	/**
	 * 查看某个影院所有电影票
	 */
	public void ticketFunctionSeeCinemaAllTicket() throws Exception;
	/**
	 * 查看某个电影所有电影票
	 */
	public void ticketFunctionSeeMovieAllTicket() throws Exception;
	/**
	 * 查看某个用户所有电影票
	 */
	public void ticketFunctionSeeUserAllTicket() throws Exception;
	/**
	 * 查看某个电影在某个影院的所有电影票
	 */
	public void ticketFunctionSeeMovieCinemaAllTicket() throws Exception;
}
