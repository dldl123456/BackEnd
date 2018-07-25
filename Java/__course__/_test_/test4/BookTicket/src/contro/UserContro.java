package contro;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.CodeGen;
import util.Help;

/**
 * 
 * @param �û����Ʋ�
 * @author zmx2321
 * 
 */


public class UserContro {
	static UserService userService = new UserServiceImpl();
	static UserDao userDao = new UserDaoImpl();
	
	//��¼
	public static User login(){
		String username = Help.getString("�������˺ţ�");
		String password = Help.getString("���������룺");

		boolean success = userService.login(username, password);
		
		if(success){
			System.out.println("\n" + username + "��½�ɹ�!\n");
			
			User user= new UserDaoImpl().queryUser(username, password);
			return user;
		}else{
			System.out.println("�û����������������������");
		}
		
		return null;
	}
	
	//ע��
	public static User regist(){
		String username = Help.getString("�������˺ţ�");
		String password = Help.getString("���������룺");
		String repassword = Help.getString("��ȷ�����룺");
		
		int times = 3;  //������
		
		while (!password.equals(repassword)){
			repassword = Help.getString("�������벻һ�£�����������ȷ�����룺");
			times--;
			
			if(times < 0){
				System.out.println("ȷ���������볬�����ޣ����˳�ע�ᣡ\n");
				return null;
			}
		}

		String sex = Help.getString("�������Ա�");
		
		while(!(sex.equals("��") || sex.equals("Ů"))){
			System.out.println("�Ա����������������л���Ů");
			sex = Help.getString("�������Ա�");
		}
		
		String phone = Help.getString("�������ֻ����룺");
		
		CodeGen.operaCodeGen();  //��֤��

		User user = new User();
		user.setUser_name(username);
		user.setUser_password(repassword);
		user.setUser_sex(sex);
		user.setUser_phone(phone);

		boolean success = userService.regist(user);
		
		if (success) {
			System.out.println("ע��ɹ���\n");
			return user;
		} else {
			System.out.println("ע��ʧ�ܣ�\n");
			return null;
		}
	}
	
	//������Ϣ
	public static void PersonalInformation(int user_id){
		boolean success = userService.querryUser(user_id);
		
		User user = userDao.queryUser(user_id);
		
		if(success){
			System.out.println("��ѯ�ɹ���\n");
			System.out.println(user + "\n");
		}else{
			System.out.println("��ѯʧ�ܣ�\n");
		}
	}
	
	//�޸��˻�����ֵ��
	public static void updateAccount(int user_id){
		
		float user_balance = Help.getFloat("��������Ҫ��ֵ�Ľ�");
		
		boolean success = userService.updateAccount(user_id, user_balance);
		
		//��¼���
		float user_balance1 = userDao.queryUserAccount(user_id);
		
		if(success){
			System.out.println("��ֵ�ɹ��������ڵ����Ϊ��" + user_balance1 + "\n");
		}else{
			System.out.println("��ֵʧ�ܣ�");
		}
	}
	
	//�鿴�����û�
	public static void queryUsers(){
		List<User> userList = userDao.querryUsers();
		
		if (userList.isEmpty()) {
			System.out.println("�����û�");
		}
		
		boolean success = userService.querryUsers(userList);
		
		if (success) {
			for(User user : userList){
				System.out.println(user + "\n");
			}
			System.out.println();
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		userList.clear();
	}
	
	//ɾ���û�
	public static void deleteUser(){
		queryUsersName();
		
		int user_id = Help.getInt("��������Ҫɾ�����û���ţ�");
		
		boolean success = userService.deleteUser(user_id);
		
		if (success) {
			System.out.println("ɾ���ɹ���\n");
			queryUsersName();
		} else {
			System.out.println("ɾ��ʧ�ܣ�\n");
		}
	}
	
	//��ѯ�û���
	public static void queryUsersName(){
		List<User> userList = userDao.querryUsers();
		
		if (userList.isEmpty()) {
			System.out.println("�����û�");
		}
		
		boolean success = userService.querryUsers(userList);
		
		if (success) {
			for(User user : userList){
				System.out.println(user.getUser_id() + "��" + user.getUser_name());
			}
			System.out.println();
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		userList.clear();
	}
	
	//�����û�id�޸��˻����(����)
	public static void setupCount(int id, float user_balance){
		
		boolean success = userService.setupCount(id, user_balance);
		
		if(success){
			userDao.setupCount(id, user_balance);
		}else{
			System.out.println("ϵͳ����");
		}
	}

	//test
	public static void main(String[] args) {
		//��¼
		/*User resultLogin = login();
		System.out.println(resultLogin);*/
		
		//ע��
		/*User resultRegist = regist();
		System.out.println(resultRegist);*/
		
		//�޸��˻�����ֵ��
		/*User ResultUpdateAccount = updateAccount();
		System.out.println(ResultUpdateAccount);*/
		
		//������Ϣ
		//PersonalInformation(3);
		
		//�鿴�����û�
		queryUsers();
		
		//ɾ���û�
		//deleteUser();
		
		//��ѯ�û���
		//queryUsersName();
		
		//�����û�id�޸��˻����(����)
		//setupCount(1, 900);
	}
}
