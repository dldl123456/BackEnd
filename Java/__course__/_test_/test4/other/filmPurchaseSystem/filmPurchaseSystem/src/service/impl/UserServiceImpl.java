package service.impl;

import service.UserService;
import view.MovieView;
import view.UserView;

public class UserServiceImpl implements UserService {

	@Override
	public void userFunctionLogin() throws Exception {
		UserView.userLoginPage();
	}

	@Override
	public void userFunctionRegister() throws Exception {
		UserView.userRegister();
	}
	//忘记密码,找管理员来重置
	@Override
	public void forgetPassword() throws Exception {
		UserView.userForgetPassWord();
	}

	@Override
	public void userFunctionSeeRankList() throws Exception {
		MovieView.movieRankListPage();
		UserView.userMeanPage();
	}

	@Override
	public void userFunctionSeeMovie() throws Exception {
		UserView.userSeeMovie();
	}

	@Override
	public void userFunctionBuyTicket(int userId) throws Exception {
		UserView.userbuyTictetPage(userId);
	}

	@Override
	public void userFunctionWriteAssessment() throws Exception {
		UserView.userWriteAssessmentPage();	
	}

	@Override
	public void userFunctionFilmTicketRefund() throws Exception {
		UserView.userRefundTicketPage();
	}

	@Override
	public void userFunctionUpdateBalance() throws Exception {
		UserView.userUpdateBalance();	
	}
	@Override
	public void userFunctionUpdatePassword() throws Exception {
		UserView.userUpdatePasswordPage(UserView.userNum);
	}

	@Override
	public void userFunctionUpdatePhone() throws Exception {
		UserView.userUpdatePhone(UserView.userNum);	
	}

	@Override
	public void userFunctionSeeUser() throws Exception {
		UserView.UserSeePage();
	}

	@Override
	public void userFunctionSeeAllUser() throws Exception {
		UserView.UserSeeAllPage();
	}

	@Override
	public void userFunctionSeeCityAllUser() throws Exception {
		UserView.UserSeeCityPage();
	}

	@Override
	public void userFunctionResetPassword() throws Exception {
		UserView.userUpdatePasswordtoZeroPage();
	}

}
