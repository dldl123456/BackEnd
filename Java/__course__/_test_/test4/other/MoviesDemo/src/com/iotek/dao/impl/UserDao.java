package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.iotek.dao.IUserDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.User;

public class UserDao implements IUserDao{
	private DbHelp db=null;
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public UserDao(){
		db=new DbHelp();
	}
	@Override
	public List<User> selectAllUsers() {
		List<User> ls=new ArrayList<User>();
		try {
			String sql="SELECT * FROM users";
			conn=db.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPsw(rs.getString(3));
				u.setAdress(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getInt(6));
				u.setTel(rs.getString(7));
				u.setRank(rs.getString(8));
				u.setBalance(rs.getDouble(9));
				u.setCost(rs.getDouble(10));
				ls.add(u);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}

	@Override
	public boolean nameIsOk(String name) {
		try {
			String sql="SELECT * FROM users where name=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}

	@Override
	public User login(String name, String psw) {
		try {
			String sql="SELECT * FROM users where name=? and psw=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, psw);
			rs=ps.executeQuery();
			User u=null;;
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPsw(rs.getString(3));
				u.setAdress(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getInt(6));
				u.setTel(rs.getString(7));
				u.setRank(rs.getString(8));
				u.setBalance(rs.getDouble(9));
				u.setCost(rs.getDouble(10));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public User selectUser(int userId) {
		try {
			String sql="SELECT * FROM users where id=?";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			User u=null;
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPsw(rs.getString(3));
				u.setAdress(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setAge(rs.getInt(6));
				u.setTel(rs.getString(7));
				u.setRank(rs.getString(8));
				u.setBalance(rs.getDouble(9));
				u.setCost(rs.getDouble(10));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public boolean register(User u) {
		if(u==null){
			return false;
		}
		try {
			String sql="insert into users "
					+ "(id,name,psw,adress,sex,age,tel,rank,balance,cost)"
					+ "values (null,?,?,?,?,?,?,?,?,?)";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPsw());
			ps.setString(3, u.getAdress());
			ps.setString(4,u.getSex());
			ps.setInt(5, u.getAge());
			ps.setString(6, u.getTel());
			ps.setString(7, u.getRank());
			ps.setDouble(8, u.getBalance());
			ps.setDouble(9, 0);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean updatePsw(int userId, String psw) {
		if(userId<1){
			return false;
		}
		try {
			String sql="update users "
					+ " set psw=? "
					+ " where id=? ";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, psw);
			ps.setInt(2, userId);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public boolean updateUser(User u) {
		if(u==null){
			return false;
		}
		try {
			String sql="update users "
					+ " set name=? , psw=? , adress=? , sex=? ,"
					+ " age=? , tel=? , rank=? , balance=? ,"
					+ " cost=? where id=? ";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPsw());
			ps.setString(3, u.getAdress());
			ps.setString(4,u.getSex());
			ps.setInt(5, u.getAge());
			ps.setString(6, u.getTel());
			ps.setString(7, u.getRank());
			ps.setDouble(8, u.getBalance());
			ps.setDouble(9, u.getCost());
			ps.setInt(10, u.getId());
			int i=ps.executeUpdate();
			if(i==1){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return false;
	}
	@Override
	public int updateUsers(List<User> uls) {
		if(uls.isEmpty()){
			return 0;
		}
		try {
			String sql="update users "
					+ " set name=? , psw=? , adress=? , sex=? ,"
					+ " age=? , tel=? , rank=? , balance=? ,"
					+ " cost=? where id=? ";
			conn=db.getConnection();
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for(User u:uls){
				ps.setString(1, u.getName());
				ps.setString(2, u.getPsw());
				ps.setString(3, u.getAdress());
				ps.setString(4,u.getSex());
				ps.setInt(5, u.getAge());
				ps.setString(6, u.getTel());
				ps.setString(7, u.getRank());
				ps.setDouble(8, u.getBalance());
				ps.setDouble(9, u.getCost());
				ps.setInt(10, u.getId());
				ps.addBatch();
			}int []i=ps.executeBatch();
			conn.commit();
			return i.length;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeAll(conn, ps, rs);
		}
		return 0;
	}
	@Override
	public double recharge(int userId, double balance, String rank) {
		if(userId<1){
			System.out.println("该用户不存在！");
			return -1;
		}
		try {
			String sql="update users "
					+ " set balance=?,"
					+ " rank=? where id=? ";
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, rank);
			ps.setInt(3, userId);
			int i=ps.executeUpdate();
			if(i==1){
				System.out.println("充值成功");
				return balance;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return -1;
	}
	@Override
	public boolean payment(int userId,double cost) {
		if(userId<1){
			return false;
		}
		String sql="update users set balance=balance-?,cost=cost+? "
				+ "where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, cost);
			ps.setDouble(2, cost);
			ps.setDouble(3, userId);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		return false;
	}
	@Override
	public boolean refund(int userId, double cost) {
		if(userId<1){
			return false;
		}
		String sql="update users set balance=balance+?,cost=cost-? "
				+ "where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, cost);
			ps.setDouble(2, cost);
			ps.setDouble(3, userId);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		return false;
	}
	@Override
	public int refunds(User u, ShowPlan sp) {
		String sql="update users inner join"
				+ "(select tickets.userId,tickets.prices "+
				"from tickets inner join plans "
				+ "on tickets.planId=plans.id where plans.id=?) as t on id=t.userId"
				+ " set balance=balance+t.prices,cost=cost-t.prices where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sp.getId());
			ps.setInt(2, u.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				System.out.println(i);
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return 0;
	}
	@Override
	public int refunds(ShowPlan sp) {
		String sql="update users inner join"
				+ "(select tickets.userId,tickets.prices "+
				"from tickets inner join plans "
				+ "on tickets.planId=plans.id where plans.id=?) as t on id=t.userId"
				+ " set balance=balance+t.prices,cost=cost-t.prices";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sp.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				System.out.println(i);
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return 0;
	}
	
}
