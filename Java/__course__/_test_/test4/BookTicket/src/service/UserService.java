package service;

import java.util.List;

import entity.User;

/**
 * 
 * @param ���û������ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface UserService {
	//�û�ע��
	public boolean regist(User user);

	//�û���¼
	public boolean login(String username, String password);
	
	//�޸��˻����
	public boolean updateAccount(int id, float user_balance);
	
	//����id��ѯ�û�
	public boolean querryUser(int id);
	
	//��ѯ�����û�
	public boolean querryUsers(List<User> userlist);
	
	//����idɾ���û�
	public boolean deleteUser(int id);
	
	//�����û�id�޸��˻����(����)
	public boolean setupCount(int id, float user_balance);
}
