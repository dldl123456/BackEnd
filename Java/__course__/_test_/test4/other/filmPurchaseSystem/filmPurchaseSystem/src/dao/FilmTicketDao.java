package dao;

import java.util.List;

import entity.FilmTicket;
/**
 * ������ӰƱ���ݿ�ӿ�
 * @author Administrator
 *
 */
public interface FilmTicketDao {
	/**
	 * ��ӵ�ӰƱ��Ϣ������
	 * @param filmTicket
	 * @return
	 * @throws Exception
	 */
	public int addFilmTicket(FilmTicket filmTicket) throws Exception;
	/**
	 * ����id�޸ĵ�ӰƱ״̬
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	public int updateFilmTicketStatus(int ticketId) throws Exception;
	/**
	 * �����û�id�鿴��ӰƱ��Ϣ
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByUser(int userId) throws Exception;
	/**
	 * ����ӰԺid�鿴��ӰƱ��Ϣ
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByCinema(int cinemaId) throws Exception;
	/**
	 * ���ݵ�Ӱid�鿴��ӰƱ��Ϣ
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByMovie(int movieId) throws Exception;
	/**
	 * ����ӰԺid�͵�Ӱid�鿴��ӰƱ��Ϣ
	 * @param filmTicketId
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTicketsByMovieCinema(int movieId,int cinemaId) throws Exception;
	/**
	 * ��ѯ���е�ӰƱ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<FilmTicket> queryFilmTickets() throws Exception;
	/**
	 * ���ݵ�ӰƱid�鿴������ӰƱ
	 * @param ticketId
	 * @return
	 * @throws Exception
	 */
	public FilmTicket queryFilmTicket(int ticketId) throws Exception;
	/**
	 * �Ƿ����
	 * @param inputCinemaId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int comparisonTicketId(int inputTicketId,int userId) throws Exception;
}
