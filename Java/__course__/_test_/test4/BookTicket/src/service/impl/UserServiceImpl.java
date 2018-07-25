package service.impl;

import java.util.List;

import dao.UserDao;
import entity.User;
import service.UserService;
import dao.impl.UserDaoImpl;

/**
 * 
 * @param ʵ���û�����ӿ�
 * @author zmx2321
 * 
 */

public class UserServiceImpl implements UserService {
	private static List<User> userlist = null;
	private User user = null;  //��ʼ��user
	private int code = 0;  //sqlִ��״̬
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	//ע��
	@Override
	public boolean regist(User user) {
		code = userDao.addUser(user);
		
		return code == 0 ? false : true;
	}

	//��¼
	@Override
	public boolean login(String username, String password) {
		user = userDao.queryUser(username, password);
		
		return user == null ? false : true;
	}

	//�޸��˻����
	@Override
	public boolean updateAccount(int id, float user_balance) {
		code = userDao.updateUser(id, user_balance);
		
		return code == 0 ? false : true;
	}
	
	//�޸��˻����
	@Override
	public boolean setupCount(int id, float user_balance) {
		code = userDao.updateUser(id, user_balance);
		
		return code == 0 ? false : true;
	}
	
	//��ѯ�û�
	public boolean querryUser(int id){
		user = userDao.queryUser(id);
		
		return user == null ? false : true;
	}
	
	//��ѯ�����û�
	@Override
	public boolean querryUsers(List<User> userlist) {
		userlist = userDao.querryUsers();
		
		return userlist == null ? false : true;
	}
	
	//����idɾ���û�
	@Override
	public boolean deleteUser(int id) {
		code = userDao.deleteUser(id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		UserServiceImpl usi = new UserServiceImpl();
		
		//User user = new User("Сi", "��", "78569", 1111);
		
		//ע��
		//System.out.println(usi.regist(user));
		
		//��¼
		//System.out.println(usi.login("����", "123123"));
		
		//�޸��˻����
		//System.out.println(usi.updateAccount(5, 302));
		
		//��ѯ�û�
		//System.out.println(usi.querryUser(1));
		
		//��ѯ�����û�
		System.out.println(usi.querryUsers(userlist));
		
		//����idɾ���û�
		//System.out.println(usi.deleteUser(1));
	}
}
