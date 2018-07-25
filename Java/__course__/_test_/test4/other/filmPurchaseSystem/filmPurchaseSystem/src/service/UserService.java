package service;

public interface UserService {
	/**
	 * �û���¼����
	 * @throws Exception
	 */
	public void userFunctionLogin() throws Exception;
	/**
	 * �û�ע��Ĺ���
	 * @throws Exception
	 */
	public void userFunctionRegister() throws Exception;
	/**
	 * ���ҵ����û��Ĺ���
	 * @throws Exception
	 */
	public void userFunctionSeeUser() throws Exception;
	/**
	 * ���������û��Ĺ���
	 * @throws Exception
	 */
	public void userFunctionSeeAllUser() throws Exception;
	/**
	 * ����ĳ�����������û��Ĺ���
	 * @throws Exception
	 */
	public void userFunctionSeeCityAllUser() throws Exception;
	/**
	 * �û���������ķ���
	 * @param userName �û�����
	 * @param userPhonenumber �û��绰
	 * @return
	 * @throws Exception
	 */
	public void forgetPassword() throws Exception;
	/**
	 * �鿴��Ӱ���а�
	 */
	public void userFunctionSeeRankList() throws Exception;
	/**
	 * �鿴ĳ����Ӱ��ϸ��Ϣ
	 */
	public void userFunctionSeeMovie() throws Exception;
	/**
	 * �û������ӰƱ�ķ���
	 */
	public void userFunctionBuyTicket(int userId) throws Exception;
	/**
	 * �û���Ʊ�ķ���
	 */
	public void userFunctionFilmTicketRefund() throws Exception;
	/**
	 * �û�дӰ���ķ���
	 */
	public void userFunctionWriteAssessment() throws Exception;
	/**
	 * �޸��û����ķ���(����Ա��ֵ����)
	 * @throws Exception
	 */
	public void userFunctionUpdateBalance() throws Exception;
	/**
	 * �û��޸����뷽��
	 */
	public void userFunctionUpdatePassword() throws Exception;
	/**
	 * �û��޸����뷽��
	 */
	public void userFunctionResetPassword() throws Exception;
	/**
	 * �û��޸ĵ绰����
	 */
	public void userFunctionUpdatePhone() throws Exception;
}
