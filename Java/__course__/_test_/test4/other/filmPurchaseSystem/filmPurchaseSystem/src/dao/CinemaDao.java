package dao;

import java.util.List;

import entity.Cinema;

/**
 * ����ӰԺ���ݿ�ӿ�
 * @author Administrator
 *
 */
public interface CinemaDao {
	/**
	 * ���ӰԺ��Ϣ������
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int addCinema(Cinema cinema) throws Exception;
	/**
	 * ɾ��ӰԺ��Ϣ��ɾ��
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int deleteCinema(String cityName,String cinemaName) throws Exception;
	/**
	 * �޸�ӰԺ��Ϣ
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int updateCinema(Cinema cinema) throws Exception;
	/**
	 * ���ݳ��в�ѯ
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public Cinema queryCinema(String cityName,String cinemaName) throws Exception;
	/**
	 * ����id��ѯ
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public Cinema queryCinemaById(int cinemaId) throws Exception;
	/**
	 * ��ѯĳ����������ӰԺ��Ϣ
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public List<Cinema> queryCinemaByCity(String cityName) throws Exception;
	/**
	 * ��ѯ����ӰԺ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Cinema> queryCinemas() throws Exception;
	/**
	 * ����id�����鿴ӰԺ�Ƿ����
	 * @param inputCinemaId
	 * @return
	 * @throws Exception
	 */
	public int comparisonCinemaId(int inputCinemaId,String cityName) throws Exception;
	public int comparisonCinemaId(int inputCinemaId) throws Exception;
	public int comparisonCinemaName(String inputCinemaName,String cityName) throws Exception;
}
