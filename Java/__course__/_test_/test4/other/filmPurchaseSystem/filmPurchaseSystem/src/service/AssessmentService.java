package service;

public interface AssessmentService {
	/**
	 * �鿴ȫ�����۵Ĺ���
	 * @throws Exception
	 */
	public void seeAllAssessmentOperate() throws Exception;
	/**
	 * �鿴ĳ����Ӱ���۵Ĺ���
	 * @throws Exception
	 */
	public void seeSomeMovieAssessmentOperate() throws Exception;
	/**
	 * �鿴ĳ����Ӱĳ��ӰԺ���۵Ĺ���
	 * @throws Exception
	 */
	public void seeSomeCinemaMovieAssessmentOperate() throws Exception;
	
	/**
	 * �鿴ĳ��ӰԺȫ�����۵Ĺ���
	 * @throws Exception
	 */
	public void seeSomeCinemaAssessmentOperate() throws Exception;
	
	/**
	 * �鿴ĳ���û�ȫ�����۵Ĺ���
	 * @throws Exception
	 */
	public void seeSomeUserAssessmentOperate() throws Exception;
	
	/**
	 * �鿴�������۵Ĺ���
	 * @throws Exception
	 */
	public void seeAssessmentOperate() throws Exception;
}
