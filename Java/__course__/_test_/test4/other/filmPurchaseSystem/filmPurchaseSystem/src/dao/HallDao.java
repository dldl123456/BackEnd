package dao;

import java.util.List;

import entity.Hall;
/**
 * ����Ӱ�����ݿ�ӿ�
 * @author Administrator
 *
 */
public interface HallDao {
	/**
	 * ���Ӱ��������
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int addHall(Hall hall) throws Exception;
	/**
	 * ɾ��Ӱ����ɾ��
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int deleteHall(String cityName,String cinemaName,String hallName) throws Exception;
	/**
	 * ɾ����ӰԺ�����ڵ�Ӱ��
	 */
	public void deleteHallCinmeaIsNull() throws Exception;
	
	/**
	 * �޸�Ӱ����Ϣ
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int updateHallName(String hallName,int hallId) throws Exception;
	/**
	 * ���ݳ��к�ӰԺ��ѯӰ����Ϣ
	 * @param hallId
	 * @return
	 * @throws Exception
	 */
	public Hall queryHall(String cityName,String cinemaName,String hallName) throws Exception;
	/**
	 * ����id��ѯӰ��
	 */
	public Hall queryHallById(int hallId) throws Exception;
	/**
	 * ��ѯ����Ӱ����Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Hall> queryHalls() throws Exception;
	/**
	 * ��ѯĳ����������ӰԺ��Ϣ
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Hall> queryHallByCinemaCity(String cinemaName,String cityName) throws Exception;
	
	public int comparisonHallId(int inputHallId) throws Exception;
	
	public int comparisonHallName(String inputHallName,String cinemaName,String cityName) throws Exception;
}
