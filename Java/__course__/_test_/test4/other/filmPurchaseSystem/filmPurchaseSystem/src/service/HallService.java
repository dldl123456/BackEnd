package service;

public interface HallService {
	/**
	 * ����Ա���Ӱ���Ĺ���
	 * @throws Exception
	 */
	public void adminFunctionAddHall() throws Exception;
	
	/**
	 * ����Աɾ��Ӱ���Ĺ���
	 */
	public void adminFunctionDeleteHall() throws Exception;
	/**
	 * �޸�Ӱ������
	 */
	public void adminFunctionUpdateHallName() throws Exception;
	/**
	 * ����Ա�鿴����Ӱ���Ĺ���
	 */
	public void adminFunctionSeeAllHall() throws Exception;
	
	/**
	 * ����Ա�鿴ĳ����������Ӱ��Ժ�Ĺ���
	 */
	public void adminFunctionSeeCityAllHall() throws Exception;
	
	/**
	 * ����Ա�鿴����Ӱ����Ϣ�Ĺ���
	 */
	public void aadminFunctionSeeHall() throws Exception;
}
