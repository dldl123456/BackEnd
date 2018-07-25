package dao;

import java.util.List;

import entity.Assessment;
/**
 * 操作评论数据库接口
 * @author Administrator
 *
 */
public interface AssessmentDao {
	/**
	 * 添加评论信息（增）
	 * @param assessment
	 * @return
	 * @throws Exception
	 */
	public int addAssessment(Assessment assessment) throws Exception;
	/**
	 * 查询单个评论信息
	 * @param assessmentId
	 * @return
	 * @throws Exception
	 */
	public Assessment queryAssessment(int assessmentId) throws Exception;
	/**
	 * 根据电影票查询单个评论信息
	 * @param assessmentId
	 * @return
	 * @throws Exception
	 */
	public Assessment queryAssessmentByTicketId(int ticketId) throws Exception;
	/**
	 * 查询所有评论信息
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessments() throws Exception;
	/**
	 * 查询某个电影的所有评论信息
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByMovie(int movieId) throws Exception;
	/**
	 * 查询某个影院的所有评论信息
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByCinema(int cinemaId) throws Exception;
	/**
	 * 查询某个影院某部电影的所有评论信息
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByCinemaMovie(int movieId,int cinemaId) throws Exception;
	/**
	 * 查询某个用户的所有评论信息
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByUser(int userId) throws Exception;
	
	public int comparisonAssessmentId(int inputAssessmentId,int userId) throws Exception;
	public int comparisonAssessmentId(int inputAssessmentId) throws Exception;
}
