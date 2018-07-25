package dao;

import java.util.List;

import entity.FilmTicket;
/**
 * 操作电影票数据库接口
 * @author Administrator
 *
 */
public interface FilmTicketDao {
	/**
	 * 添加电影票信息（增）
	 * @param filmTicket
	 * @return
	 * @throws Exception
	 */
	public int addFilmTicket(FilmTicket filmTicket) throws Exception;
	/**
	 * 根据id修改电影票状态
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	public int updateFilmTicketStatus(int ticketId) throws Exception;
	/**
	 * 根据用户id查看电影票信息
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByUser(int userId) throws Exception;
	/**
	 * 根据影院id查看电影票信息
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByCinema(int cinemaId) throws Exception;
	/**
	 * 根据电影id查看电影票信息
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByMovie(int movieId) throws Exception;
	/**
	 * 根据影院id和电影id查看电影票信息
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByMovieCinema(int movieId,int cinemaId) throws Exception;
	/**
	 * 查询所有电影票信息
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTickets() throws Exception;
	/**
	 * 根据电影票id查看单个电影票
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	public FilmTicket queryFilmTicket(int ticketId) throws Exception;
	/**
	 * 是否存在
	 * @param inputCinemaId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int comparisonTicketId(int inputTicketId,int userId) throws Exception;
}
