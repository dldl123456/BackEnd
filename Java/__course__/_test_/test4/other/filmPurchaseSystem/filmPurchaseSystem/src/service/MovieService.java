package service;

public interface MovieService {
	/**
	 * ����Ա��ӵ�Ӱ�Ĺ���
	 * @throws Exception
	 */
	public void adminFunctionAddMovie() throws Exception;
	
	/**
	 * ����Աɾ����Ӱ�Ĺ���
	 */
	public void adminFunctionDeleteMovie() throws Exception;
	
	/**
	 * ����Ա�鿴���е�Ӱ�Ĺ���
	 */
	public void adminFunctionSeeAllMovie() throws Exception;
	
	/**
	 * ����Ա�鿴������Ӱ��Ϣ�Ĺ���
	 */
	public void aadminFunctionSeeMovie() throws Exception;
	
	/**
	 * ����Ա�ϼ��¼ܵ�Ӱ�Ĺ��ܣ��޸ĵ�Ӱ״̬��
	 */
	public void adminFunctionUpdateMovieStatus() throws Exception;
	
	/**
	 * ����Ա�޸ĵ�Ӱ���ֵĹ���
	 */
	public void adminFunctionUpdateMovieScore() throws Exception;
	
	/**
	 * ��Ӱ���а�
	 */
	public void movieRankListFunction() throws Exception;
}
