package service;

public interface CinemaService {
	/**
	 * ����Ա��ӵ�ӰԺ�Ĺ���
	 * @throws Exception
	 */
	public void adminFunctionAddCinema() throws Exception;
	
	/**
	 * ����Աɾ����ӰԺ�Ĺ���
	 */
	public void adminFunctionDeleteCinema() throws Exception;
	
	/**
	 * ����Ա�鿴���е�ӰԺ�Ĺ���
	 */
	public void adminFunctionSeeAllCinema() throws Exception;
	
	/**
	 * ����Ա�鿴ĳ���������е�ӰԺԺ�Ĺ���
	 */
	public void adminFunctionSeeCityAllCinema() throws Exception;
	
	/**
	 * ����Ա�鿴������ӰԺ��Ϣ�Ĺ���
	 */
	public void aadminFunctionSeeCinema() throws Exception;
}
