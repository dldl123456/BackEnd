package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Userdao;
import dbutil.DbADUClose;
import entity.User;

public class UserDaoImpl extends DbADUClose implements Userdao {
	/**
	 * �û���¼�ķ���(��)
	 * @param userName�û���
	 * @param userPassword�û�����
	 * @return
	 * @throws Exception
	 */
	@Override
	public User userLogin(int userAccount, String userPassword) throws Exception {
		String sql = "select * from user where user_account=? and user_password=?";
		//�������
		ps=super.getConnection().prepareStatement(sql);
		ps.setInt(1, userAccount);
		ps.setString(2, userPassword);
		rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserAccount(rs.getInt(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserCity(rs.getInt(5));
			user.setUserPhone(rs.getString(6));
			user.setUserBalance(rs.getDouble(7));
			return user;
		}
		super.closeAll();
		return null;
	}
	@Override
	public User userLoginByPhone(int userAccount, String userPhone) throws Exception {
		String sql = "select * from user where user_account=? and user_phone=?";
		//�������
		ps=super.getConnection().prepareStatement(sql);
		ps.setInt(1, userAccount);
		ps.setString(2, userPhone);
		rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserAccount(rs.getInt(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserCity(rs.getInt(5));
			user.setUserPhone(rs.getString(6));
			user.setUserBalance(rs.getDouble(7));
			return user;
		}
		super.closeAll();
		return null;
	}
	
	@Override
	public User queryUserById(int userId) throws Exception {
		String sql = "select * from user where user_id=?";
		//�������
		ps=super.getConnection().prepareStatement(sql);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserAccount(rs.getInt(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserCity(rs.getInt(5));
			user.setUserPhone(rs.getString(6));
			user.setUserBalance(rs.getDouble(7));
			return user;
		}
		super.closeAll();
		return null;
	}
	@Override
	public User queryUserByAccount(int userAccount) throws Exception {
		String sql = "select * from user where user_account=?";
		//�������
		ps=super.getConnection().prepareStatement(sql);
		ps.setInt(1, userAccount);
		rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUserAccount(rs.getInt(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserCity(rs.getInt(5));
			user.setUserPhone(rs.getString(6));
			user.setUserBalance(rs.getDouble(7));
			return user;
		}
		super.closeAll();
		return null;
	}
	/**
	 * �û�ע��ķ���������
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public int userRegister(User user) throws Exception {
		String sql="insert into user values(default,?,?,?,?,?,default)";
		Object[] params = {user.getUserAccount(),user.getUserName(),user.getUserPassword(),user.getUserCity(),
				user.getUserPhone()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * �޸��û�����ķ������ģ�
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateUserPassword(String userName,String newPassword) throws Exception {
		String sql = "update user set user_password=? where user_name=?";
		Object[] params= {newPassword,userName};
		return super.executeUpdate(sql, params);
	}
	/**
	 * �޸��˻����ķ���
	 * @param userId
	 * @param userBalance
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateUserBalance(int userId, double userBalance) throws Exception {
		String sql = "update user set user_balance=? where user_id=?";
		Object[] params= {userBalance,userId};
		return super.executeUpdate(sql, params);
	}
	@Override
	public int updateUserPhone(int userId, String newPhone) throws Exception {
		String sql = "update user set user_phone=? where user_id=?";
		Object[] params= {newPhone,userId};
		return super.executeUpdate(sql, params);
	}
	/**
	 * �޸��˻�������Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateUser(User user) throws Exception {
		String sql = "update user set user_name=?,user_city=?,user_phone=? where user_id=?";
		Object[] params = {user.getUserName(),user.getUserCity(),user.getUserPhone(),user.getUserId()};
		return super.executeUpdate(sql, params);
	}
	
	@Override
	public List<User> queryUsers() throws Exception {
		try {
			List<User> users = new ArrayList<User>();
			String sql = "select * from user";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserAccount(rs.getInt(2));
				user.setUserName(rs.getString(3));
				user.setUserPassword(rs.getString(4));
				user.setUserCity(rs.getInt(5));
				user.setUserPhone(rs.getString(6));
				user.setUserBalance(rs.getDouble(7));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public List<User> queryUsersByCity(int cityId) throws Exception {
		try {
			List<User> users = new ArrayList<User>();
			String sql = "select * from user,city where user_city=city_id and city_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cityId);
			rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserAccount(rs.getInt(2));
				user.setUserName(rs.getString(3));
				user.setUserPassword(rs.getString(4));
				user.setUserCity(rs.getInt(5));
				user.setUserPhone(rs.getString(6));
				user.setUserBalance(rs.getDouble(7));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public int comparisonUserAccount(int inputUserAccount) throws Exception {
		int nameNum = -1;//����һ���������մ�������ID
		for(int i=0;i<queryUsers().size();i++) {
			if(inputUserAccount==queryUsers().get(i).getUserAccount()) {
				nameNum=i;
				break;
			}
		}
		return nameNum;
	}
	@Override
	public int comparisonUserId(int inputUserId) throws Exception {
		int nameNum = -1;//����һ���������մ�������ID
		for(int i=0;i<queryUsers().size();i++) {
			if(inputUserId==queryUsers().get(i).getUserId()) {
				nameNum=i;
				break;
			}
		}
		return nameNum;
	}
	@Override
	public int comparisonUserPas(int inputUserAccount, String inputUserPas) throws Exception {
		int pasNum = -1;//����һ���������մ�������ID
		for(int i=0;i<queryUsers().size();i++) {
			if(inputUserPas.equals(queryUsers().get(i).getUserPassword()) && i==comparisonUserAccount(inputUserAccount)) {
				pasNum=i;
				break;
			}
		}
		return pasNum;
	}
	@Override
	public int comparisonUserPhone(int inputUserAccount, String inputUserPhone) throws Exception {
		int PhoNum = -1;//����һ���������մ�������ID
		for(int i=0;i<queryUsers().size();i++) {
			if(inputUserPhone.equals(queryUsers().get(i).getUserPhone()) && i==comparisonUserAccount(inputUserAccount)) {
				PhoNum=i;
				break;
			}
		}
		return PhoNum;
	}

}
