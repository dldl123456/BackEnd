package service;

public interface AdminService {
	/**
	 * ����Ա��¼����
	 * @throws Exception
	 */
	public void adminFunctionLogin() throws Exception;
	/**
	 * ����Ա�����Ӱ����
	 * @throws Exception
	 */
	public void adminFunctionsuperviseMovie() throws Exception;
	
	/**
	 * ����Ա�����ӰԺ����
	 * @throws Exception
	 */
	public void adminFunctionsuperviseCinmea() throws Exception;
	
	/**
	 * ����Ա����Ӱ������
	 * @throws Exception
	 */
	public void adminFunctionsuperviseHall() throws Exception;
	
	/**
	 * ����Ա������λ����
	 * @throws Exception
	 */
	public void adminFunctionsuperviseSeat() throws Exception;
	
	/**
	 * ����Ա������й���
	 * @throws Exception
	 */
	public void adminFunctionsuperviseCity() throws Exception;
	/**
	 * ����Ա�����ι���
	 * @throws Exception
	 */
	public void adminFunctionsuperviseSession() throws Exception;
	
	/**
	 * ����Ա�����û�����
	 * @throws Exception
	 */
	public void adminFunctionsuperviseUser() throws Exception;
	
	/**
	 * ����Ա�����û����۹���
	 * @throws Exception
	 */
	public void adminFunctionsuperviseAssessment() throws Exception;
	
	/**
	 * ����Ա�����ӰƱ����
	 * @throws Exception
	 */
	public void adminFunctionsuperviseFilmTicket() throws Exception;
}
