package service;
public interface FilmTicketService {
	/**
	 * ��ӵ�ӰƱ
	 */
	public void ticketFunctionAdd(int userId ,int cityId) throws Exception;
	/**
	 * ��Ʊ
	 */
	public void ticketFunctionRefund() throws Exception;
	/**
	 * �鿴������ӰƱ
	 * @throws Exception
	 */
	/*public void ticketFunctionSee() throws Exception;*/
	/**
	 * �鿴���е�ӰƱ
	 */
	public void ticketFunctionSeeAll() throws Exception;
	/**
	 * �鿴ĳ��ӰԺ���е�ӰƱ
	 */
	public void ticketFunctionSeeCinemaAllTicket() throws Exception;
	/**
	 * �鿴ĳ����Ӱ���е�ӰƱ
	 */
	public void ticketFunctionSeeMovieAllTicket() throws Exception;
	/**
	 * �鿴ĳ���û����е�ӰƱ
	 */
	public void ticketFunctionSeeUserAllTicket() throws Exception;
	/**
	 * �鿴ĳ����Ӱ��ĳ��ӰԺ�����е�ӰƱ
	 */
	public void ticketFunctionSeeMovieCinemaAllTicket() throws Exception;
}
