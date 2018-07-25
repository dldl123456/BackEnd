package dao;

import java.util.List;

import entity.User;

/**
 * �����û����ݿ�ӿ�
 * @author Useristrator
 *
 */
public interface Userdao {
	/**
	 * �û���¼�ķ���(��)
	 * @param user_name�û���
	 * @param user_password�û�����
	 * @return
	 * @throws Exception
	 */
	public User userLogin(int userAccount,String userPassword) throws Exception;
	/**
	 * �û���¼�ķ���(��)
	 * @param user_name�û���
	 * @param user_password�û�����
	 * @return
	 * @throws Exception
	 */
	public User userLoginByPhone(int userAccount,String userPhone) throws Exception;
	/**
	 * �û�ע��ķ���������
	 * @param user ��һ���µ��û�����
	 * @return
	 * @throws Exception
	 */
	public int userRegister(User user) throws Exception;
	/**
	 * �޸��û�����ķ������ģ�
	 * @param user_name �û�������Ϊ����
	 * @param oldPassword ������
	 * @param newPassword ������
	 * @return
	 * @throws Exception
	 */
	public int updateUserPassword(String userName,String newPassword) throws Exception;
	/**
	 * �޸��˻����ķ���
	 * @param userId
	 * @param userBalance
	 * @return
	 * @throws Exception
	 */
	public int updateUserBalance(int userId,double userBalance) throws Exception;
	/**
	 * �޸��˻��绰�ķ���
	 *
	 */
	public int updateUserPhone(int userId,String newPhone) throws Exception;
	/**
	 * �޸��û���Ϣ�ķ��������ܸ����룩
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateUser(User user) throws Exception;
	
	/**
	 * ��ѯ�����û��ķ���
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsers() throws Exception;
	/**
	 * ��ѯĳ�����������û��ķ���
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsersByCity(int cityId) throws Exception;
	/**
	 * �����û���Ų�ѯ�û�
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int userId) throws Exception;
	public User queryUserByAccount(int userAccount) throws Exception;
	/**
	 * �ȶ��û��˺��Ƿ���ڵķ���
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserAccount(int inputUserAccount) throws Exception;
	
	public int comparisonUserId(int inputUserId) throws Exception;
	
	/**
	 * �ȶ��û������Ƿ���ȷ�ķ���
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserPas(int inputUserAccount,String inputUserPas) throws Exception;
	/**
	 * �ȶ��û��绰�����Ƿ���ȷ�ķ���
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserPhone(int inputUserAccount,String inputUserPhone) throws Exception;
	
}
