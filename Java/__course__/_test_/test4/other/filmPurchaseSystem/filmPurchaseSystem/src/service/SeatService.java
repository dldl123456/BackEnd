package service;

public interface SeatService {
	
	/**
	 * �����λ
	 */
	public void seatFunctionAdd() throws Exception;
	/**
	 * ����idɾ����λ
	 */
	public void seatFunctionDeleteById() throws Exception;
	/**
	 * �����кź�����ɾ��������λ
	 */
	public void seatFunctionDeleteByRowHall() throws Exception;
	/**
	 * �����кź�����ɾ��������λ
	 */
	public void seatFunctionDeleteByRankHall() throws Exception;
	/**
	 * �޸ĵ�����λ״̬
	 */
	public void seatFunctionUpdateStatusById(int seatId) throws Exception;
	/**
	 * �ָ���������λ״̬
	 */
	public void seatFunctionUpdateStatusByHall() throws Exception;
	/**
	 * �鿴������λ
	 */
	public void seatFunctionSeeAll() throws Exception;
	/**
	 * �鿴ĳ����������λ
	 */
	public void seatFunctionSeeHallAllSeat() throws Exception;
}
