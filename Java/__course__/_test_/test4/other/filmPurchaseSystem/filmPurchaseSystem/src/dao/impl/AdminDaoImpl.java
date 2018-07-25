package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;
import dbutil.DbADUClose;
import entity.Admin;

public class AdminDaoImpl extends DbADUClose implements AdminDao {
	/**
	 * 管理员登录方法
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	@Override
	public Admin adminLogin(String adminName, String adminPassword) throws Exception {
		String sql = "select * from admin where admin_name=? and admin_password=?";
		ps = super.getConnection().prepareStatement(sql);
		ps.setString(1, adminName);
		ps.setString(2,adminPassword);
		rs = ps.executeQuery();
		if(rs.next()) {
			Admin admin = new Admin();
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminPassword(rs.getString(3));
			return admin;
		}
		super.closeAll();
		return null;
	}

	@Override
	public List<Admin> queryAdmins() throws Exception {
		try {
			List<Admin> admins = new ArrayList<Admin>();
			String sql = "select * from admin";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Admin admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				admins.add(admin);
			}
			return admins;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public int comparisonAdminName(String inputAdminName) throws Exception {
		int nameNum = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryAdmins().size();i++) {
			if(inputAdminName.equals(queryAdmins().get(i).getAdminName())) {
				nameNum=i;
				break;
			}
		}
		return nameNum;
	}

	@Override
	public int comparisonAdminPas(String inputAdminName,String inputAdminPas) throws Exception {
		int pasNum = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryAdmins().size();i++) {
			if(inputAdminPas.equals(queryAdmins().get(i).getAdminPassword()) && i==comparisonAdminName(inputAdminName)) {
				pasNum=i;
				break;
			}
		}
		return pasNum;
	}

	

}
