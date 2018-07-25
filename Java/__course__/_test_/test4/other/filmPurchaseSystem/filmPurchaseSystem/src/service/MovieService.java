package service;

public interface MovieService {
	/**
	 * 管理员添加电影的功能
	 * @throws Exception
	 */
	public void adminFunctionAddMovie() throws Exception;
	
	/**
	 * 管理员删除电影的功能
	 */
	public void adminFunctionDeleteMovie() throws Exception;
	
	/**
	 * 管理员查看所有电影的功能
	 */
	public void adminFunctionSeeAllMovie() throws Exception;
	
	/**
	 * 管理员查看单个电影信息的功能
	 */
	public void aadminFunctionSeeMovie() throws Exception;
	
	/**
	 * 管理员上架下架电影的功能（修改电影状态）
	 */
	public void adminFunctionUpdateMovieStatus() throws Exception;
	
	/**
	 * 管理员修改电影评分的功能
	 */
	public void adminFunctionUpdateMovieScore() throws Exception;
	
	/**
	 * 电影排行榜
	 */
	public void movieRankListFunction() throws Exception;
}
