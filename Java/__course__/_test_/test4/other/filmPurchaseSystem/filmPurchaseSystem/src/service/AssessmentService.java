package service;

public interface AssessmentService {
	/**
	 * 查看全部评论的功能
	 * @throws Exception
	 */
	public void seeAllAssessmentOperate() throws Exception;
	/**
	 * 查看某部电影评论的功能
	 * @throws Exception
	 */
	public void seeSomeMovieAssessmentOperate() throws Exception;
	/**
	 * 查看某部电影某个影院评论的功能
	 * @throws Exception
	 */
	public void seeSomeCinemaMovieAssessmentOperate() throws Exception;
	
	/**
	 * 查看某个影院全部评论的功能
	 * @throws Exception
	 */
	public void seeSomeCinemaAssessmentOperate() throws Exception;
	
	/**
	 * 查看某个用户全部评论的功能
	 * @throws Exception
	 */
	public void seeSomeUserAssessmentOperate() throws Exception;
	
	/**
	 * 查看单个评论的功能
	 * @throws Exception
	 */
	public void seeAssessmentOperate() throws Exception;
}
