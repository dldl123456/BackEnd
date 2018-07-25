package dao;

import java.util.List;

import entity.Assessment;
/**
 * �����������ݿ�ӿ�
 * @author Administrator
 *
 */
public interface AssessmentDao {
	/**
	 * ���������Ϣ������
	 * @param assessment
	 * @return
	 * @throws Exception
	 */
	public int addAssessment(Assessment assessment) throws Exception;
	/**
	 * ��ѯ����������Ϣ
	 * @param assessmentId
	 * @return
	 * @throws Exception
	 */
	public Assessment queryAssessment(int assessmentId) throws Exception;
	/**
	 * ���ݵ�ӰƱ��ѯ����������Ϣ
	 * @param assessmentId
	 * @return
	 * @throws Exception
	 */
	public Assessment queryAssessmentByTicketId(int ticketId) throws Exception;
	/**
	 * ��ѯ����������Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessments() throws Exception;
	/**
	 * ��ѯĳ����Ӱ������������Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByMovie(int movieId) throws Exception;
	/**
	 * ��ѯĳ��ӰԺ������������Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByCinema(int cinemaId) throws Exception;
	/**
	 * ��ѯĳ��ӰԺĳ����Ӱ������������Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByCinemaMovie(int movieId,int cinemaId) throws Exception;
	/**
	 * ��ѯĳ���û�������������Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<Assessment> queryAssessmentsByUser(int userId) throws Exception;
	
	public int comparisonAssessmentId(int inputAssessmentId,int userId) throws Exception;
	public int comparisonAssessmentId(int inputAssessmentId) throws Exception;
}
