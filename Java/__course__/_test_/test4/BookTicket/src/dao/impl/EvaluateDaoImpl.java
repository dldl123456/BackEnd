package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EvaluateDao;
import dbhelp.DbHelp;
import entity.Evaluate;
import entity.Movie;
import entity.User;

/**
 * 
 * @param 实现评论类数据接口
 * @author zmx2321
 * 
 */

public class EvaluateDaoImpl implements EvaluateDao {
	private DbHelp db;
	private Connection conn;
	private List<Evaluate> list;
	
	//构造方法初始化
	public EvaluateDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//添加评论
	@Override
	public int addEvaluate(Evaluate evaluate) {
		conn = db.getConnection();
		String sql = "insert into evaluate(`evaluate_content`, `movie_id`, `user_id`) values (?,?,?)";
		
		PreparedStatement ps  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, evaluate.getEvaluate_content());
			ps.setInt(2, evaluate.getMovie_id());
			ps.setInt(3, evaluate.getUser_id());
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//查询所有评论
	@Override
	public List<Evaluate> querryEvaluate() {
		conn = db.getConnection();
		String sql = "select e.evaluate_id, e.evaluate_time, e.evaluate_content ,"
				+ "u.user_name, m.movie_name from user u, movie m, evaluate e "
				+ "where u.user_id = e.user_id and m.movie_id = e.movie_id";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//一条一条地记录信息
			while(rs.next()){
				Evaluate e = new Evaluate();
				
				e.setMovie(new Movie());
				e.setUser(new User());
				
				e.setEvaluate_id(rs.getInt(1));
				e.setEvaluate_time(rs.getTimestamp(2));
				e.setEvaluate_content(rs.getString(3));
				e.getUser().setUser_name(rs.getString(4));
				e.getMovie().setMovie_name(rs.getString(5));
				
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}
	
	//根据id删除评论
	@Override
	public int deleteEvaluate(int evaluate_id) {
		conn = db.getConnection();
		String sql = "delete from evaluate where evaluate_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, evaluate_id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//test
	public static void main(String[] args) {
		EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
		
		//添加评论
		/*Evaluate evaluate = new Evaluate("123123", 1, 4);
		System.out.println(evaluate);
		int code = evaluateDao.addEvaluate(evaluate);
		System.out.println(code);*/
		
		//根据id删除评论
		//System.out.println(evaluateDao.deleteEvaluate(3));
		
		//查询所有评论
		System.out.println("***** 查询 *****");
		List<Evaluate> evaluateList = evaluateDao.querryEvaluate();
		for(Evaluate evaluate1 : evaluateList){
			System.out.println(evaluate1.getEvaluate_id() + "、" + 
				evaluate1.getMovie().getMovie_name() + "\n" + 
				evaluate1.getUser().getUser_name() + "\n" + 
				evaluate1.getEvaluate_content() + " \n" + 
				evaluate1.getEvaluate_time() + "\n"
			);
		}
		
		
	}
}
