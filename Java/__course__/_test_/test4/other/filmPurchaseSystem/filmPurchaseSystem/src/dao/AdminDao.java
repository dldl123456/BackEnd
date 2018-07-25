package dao;

import java.util.List;

import entity.Admin;

/**
 * ��������Ա���ݿ�ӿ�
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * ����Ա��¼����
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	public Admin adminLogin(String adminName,String adminPassword) throws Exception;
	/**
	 * ��ѯ���й���Ա�ķ���
	 * @return
	 * @throws Exception
	 */
	public List<Admin> queryAdmins() throws Exception;
	/**
	 * �ȶԹ���Ա�����Ƿ���ڵķ���
	 * @param inputAdminName
	 * @return
	 * @throws Exception
	 */
	public int comparisonAdminName(String inputAdminName) throws Exception;
	
	/**
	 * �ȶԹ���Ա�����Ƿ���ȷ�ķ���
	 * @param inputAdminName
	 * @return
	 * @throws Exception
	 */
	public int comparisonAdminPas(String inputAdminName,String inputAdminPas) throws Exception;
	
}
