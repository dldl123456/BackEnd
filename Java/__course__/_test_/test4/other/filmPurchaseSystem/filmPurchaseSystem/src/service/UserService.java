package service;

public interface UserService {
	/**
	 * 用户登录功能
	 * @throws Exception
	 */
	public void userFunctionLogin() throws Exception;
	/**
	 * 用户注册的功能
	 * @throws Exception
	 */
	public void userFunctionRegister() throws Exception;
	/**
	 * 查找单个用户的功能
	 * @throws Exception
	 */
	public void userFunctionSeeUser() throws Exception;
	/**
	 * 查找所有用户的功能
	 * @throws Exception
	 */
	public void userFunctionSeeAllUser() throws Exception;
	/**
	 * 查找某个城市所有用户的功能
	 * @throws Exception
	 */
	public void userFunctionSeeCityAllUser() throws Exception;
	/**
	 * 用户忘记密码的方法
	 * @param userName 用户姓名
	 * @param userPhonenumber 用户电话
	 * @return
	 * @throws Exception
	 */
	public void forgetPassword() throws Exception;
	/**
	 * 查看电影排行榜
	 */
	public void userFunctionSeeRankList() throws Exception;
	/**
	 * 查看某个电影详细信息
	 */
	public void userFunctionSeeMovie() throws Exception;
	/**
	 * 用户购买电影票的方法
	 */
	public void userFunctionBuyTicket(int userId) throws Exception;
	/**
	 * 用户退票的方法
	 */
	public void userFunctionFilmTicketRefund() throws Exception;
	/**
	 * 用户写影评的方法
	 */
	public void userFunctionWriteAssessment() throws Exception;
	/**
	 * 修改用户余额的方法(管理员充值可用)
	 * @throws Exception
	 */
	public void userFunctionUpdateBalance() throws Exception;
	/**
	 * 用户修改密码方法
	 */
	public void userFunctionUpdatePassword() throws Exception;
	/**
	 * 用户修改密码方法
	 */
	public void userFunctionResetPassword() throws Exception;
	/**
	 * 用户修改电话方法
	 */
	public void userFunctionUpdatePhone() throws Exception;
}
