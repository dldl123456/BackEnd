package service;

public interface SessionService {
	/**
	 * ����Ա��ӳ��εĹ���
	 * @throws Exception
	 */
	public void adminFunctionAddSession() throws Exception;
	/**
	 * ����Աɾ�����εĹ���
	 */
	public void adminFunctionDeleteSession() throws Exception;
	/**
	 * �޸ĳ�������
	 */
	public void adminFunctionUpdateSessionName() throws Exception;
	/**
	 * ����Ա�鿴���г��εĹ���
	 */
	public void adminFunctionSeeAllSession() throws Exception;
	
	/**
	 * ����Ա�鿴ĳ��ӰԺ���г���Ժ�Ĺ���
	 */
	public void adminFunctionSeeCinemaAllSession() throws Exception;
	
	/**
	 * ����Ա�鿴ĳ����Ӱ���г���Ժ�Ĺ���
	 */
	public void adminFunctionSeeMovieAllSession() throws Exception;
	
	/**
	 * ����Ա�鿴ĳ��ӰԺĳ����Ӱ���г���Ժ�Ĺ���
	 */
	public void adminFunctionSeeCinemaMovieAllSession() throws Exception;
	
	
	/**
	 * ����Ա�鿴����������Ϣ�Ĺ���
	 */
	public void aadminFunctionSeeSession() throws Exception;
}
