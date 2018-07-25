package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AssessmentDao;
import dbutil.DbADUClose;
import entity.Assessment;

public class AssessmentDaoImpl extends DbADUClose implements AssessmentDao {

	@Override
	public int addAssessment(Assessment assessment) throws Exception {
		String sql="insert into Assessment values (default,?,?,?,?)";
		Object[] params = {assessment.getAssessmentTicket(),assessment.getAssessmentTime(),
				assessment.getAssessmentContent(),assessment.getAssessmentScore()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public Assessment queryAssessment(int assessmentId) throws Exception {
		try {
			String sql="select * from assessment where assessment_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, assessmentId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				return assessment;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public Assessment queryAssessmentByTicketId(int ticketId) throws Exception {
		try {
			String sql="select assessment_id,assessment_ticket,assessment_time,assessment_content,"
					+ "assessment_score from assessment,filmticket where assessment_ticket=ticket_id and ticket_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, ticketId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				return assessment;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public List<Assessment> queryAssessments() throws Exception {
		try {
			List<Assessment> assessments = new ArrayList<Assessment>();
			String sql ="select * from assessment";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				assessments.add(assessment);
			}
			return assessments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<Assessment> queryAssessmentsByMovie(int movieId) throws Exception {
		try {
			List<Assessment> assessments = new ArrayList<Assessment>();
			String sql ="select assessment_id,assessment_ticket,assessment_time,assessment_content,"
					+ "assessment_score from assessment,filmticket,movie where assessment_ticket=ticket_id "
					+ "and ticket_movie=movie_id and movie_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, movieId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				assessments.add(assessment);
			}
			return assessments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<Assessment> queryAssessmentsByCinema(int cinemaId) throws Exception {
		try {
			List<Assessment> assessments = new ArrayList<Assessment>();
			String sql ="select assessment_id,assessment_ticket,assessment_time,assessment_content,"
					+ "assessment_score from assessment,filmticket,cinema,seat,hall where "
					+ "assessment_ticket=ticket_id and ticket_seat=seat_id and seat_hall=hall_id "
					+ "and hall_cinema=cinema_id and cinema_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cinemaId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				assessments.add(assessment);
			}
			return assessments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<Assessment> queryAssessmentsByCinemaMovie(int cinemaId,int movieId) throws Exception {
		try {
			List<Assessment> assessments = new ArrayList<Assessment>();
			String sql ="select assessment_id,assessment_ticket,assessment_time,assessment_content,"
					+ "assessment_score from assessment,filmticket,cinema,seat,hall,movie where "
					+ "assessment_ticket=ticket_id and ticket_seat=seat_id and ticket_movie=movie_id and "
					+ "seat_hall=hall_id and hall_cinema=cinema_id and cinema_id=? and movie_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cinemaId);
			ps.setInt(2, movieId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				assessments.add(assessment);
			}
			return assessments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<Assessment> queryAssessmentsByUser(int userId) throws Exception {
		try {
			List<Assessment> assessments = new ArrayList<Assessment>();
			String sql ="select assessment_id,assessment_ticket,assessment_time,assessment_content,"
					+ "assessment_score from assessment,filmticket,user where assessment_ticket=ticket_id "
					+ "and ticket_user=user_id and user_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Assessment assessment=new Assessment();
				assessment.setAssessmentId(rs.getInt(1));
				assessment.setAssessmentTicket(rs.getInt(2));
				assessment.setAssessmentTime(rs.getString(3));
				assessment.setAssessmentContent(rs.getString(4));
				assessment.setAssessmentScore(rs.getDouble(5));
				assessments.add(assessment);
			}
			return assessments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * 判断输入的评论编号是否在用户所有评论中
	 */
	@Override
	public int comparisonAssessmentId(int inputAssessmentId,int userId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryAssessmentsByUser(userId).size();i++) {
			if(inputAssessmentId==queryAssessmentsByUser(userId).get(i).getAssessmentId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	@Override
	public int comparisonAssessmentId(int inputAssessmentId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryAssessments().size();i++) {
			if(inputAssessmentId==queryAssessments().get(i).getAssessmentId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
