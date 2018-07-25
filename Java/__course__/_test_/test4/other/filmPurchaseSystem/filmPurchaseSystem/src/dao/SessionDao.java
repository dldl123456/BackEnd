package dao;

import java.util.Date;
import java.util.List;

import entity.Session;
/**
 * �����������ݿ�ӿ�
 * @author Administrator
 *
 */
public interface SessionDao {
	/**
	 * ��ӳ��Σ�����
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int addSession(Session session) throws Exception;
	/**
	 * ɾ��ĳ������
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public int deleteSession(int sessionId) throws Exception;
	/**
	 * �޸ĳ�����Ϣ
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int updateSession(Session session) throws Exception;
	/**
	 * ���ݵ�Ӱ���Ʋ�ѯ����
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByMovieName(String movieName) throws Exception;
	/**
	 * ���ݳ���id��ѯ����
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public Session querySessionById(int sessionId) throws Exception;
	/**
	 * ����ӰԺ���Ʋ�ѯ������Ϣ
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByCinema(String cinemaName,String cityName) throws Exception;
	/**
	 * ����Ӱ����Ų�ѯ������Ϣ
	 * @param HallId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByHall(int HallId) throws Exception;
	/**
	 * ����ӰԺ�͵�Ӱ���鿴����
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessionByCinemaMovie(String cinemaName,String movieName,String cityName) throws Exception;
	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Session> querySessions() throws Exception;
	/**
	 * �����鿴�����Ƿ����
	 * @param inputSessionId
	 * @return
	 * @throws Exception
	 */
	public int comparisonSessionId(int inputSessionId,String cinemaName,String movieName,String cityName) throws Exception;
	public int comparisonSessionHall(int hallId,Date time) throws Exception;
	public int comparisonSession(String movieName,Date time) throws Exception;
	public int comparisonSessionByid(int inputSessionId) throws Exception;
}
