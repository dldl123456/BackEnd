package dao;

import java.util.List;

import entity.Seat;
/**
 * ������λ���ݿ�ӿ�
 * @author Administrator
 *
 */
public interface SeatDao {
	/**
	 * �����λ��Ϣ������
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int addSeat(Seat seat) throws Exception;
	/**
	 * ����IDɾ����λ��ɾ��
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatById(int seatId) throws Exception;
	/**
	 * �����кź�����ɾ����λ��ɾ��
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatByRow(int row,int hallId) throws Exception;
	/**
	 * �����кź�����ɾ����λ��ɾ��
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int deleteSeatByRank(int rank,int hallId) throws Exception;
	/**
	 * ɾ��ӰԺ��ɾ����λ
	 */
	public void deleteSeatCinemaIsNull() throws Exception;
	/**
	 * ɾ������ɾ����λ
	 */
	public void deleteSeatHallIsNull() throws Exception;
	/**
	 * ����id�޸���λ״̬
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int updateSeatStatusById(int seatId,int status) throws Exception;
	/**
	 * ���������޸���λ״̬
	 * @param seat
	 * @return
	 * @throws Exception
	 */
	public int updateSeatStatusByHall(int hallId,int status) throws Exception;
	/**
	 * ��ѯ������λ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Seat> querySeats() throws Exception;
	
	/**
	 * ��ѯĳ����������λ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Seat> querySeatsByHall(int hallId) throws Exception;
	/**
	 * ��ѯĳ����λ
	 * @param SeatId
	 * @return
	 * @throws Exception
	 */
	public Seat querySeatById(int SeatId) throws Exception;
	/**
	 * �����鿴��λ�Ƿ����
	 * @param inputSeatId
	 * @return
	 * @throws Exception
	 */
	public int comparisonSeatId(int inputSeatId,int hallId) throws Exception;
	public int comparisonSeatId(int inputSeatId) throws Exception;
}
