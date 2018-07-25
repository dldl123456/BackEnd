package service.impl;

import service.AdminService;
import view.AdminView;

public class AdminServiceImpl implements AdminService {

	@Override
	public void adminFunctionLogin() throws Exception {
		AdminView.adminLoginPage();
	}

	@Override
	public void adminFunctionsuperviseMovie() throws Exception {
		AdminView.adminOperateMoviePage();
	}

	@Override
	public void adminFunctionsuperviseCinmea() throws Exception {
		AdminView.adminOperateCinemaPage();
	}

	@Override
	public void adminFunctionsuperviseHall() throws Exception {
		AdminView.adminOperateHallPage();
	}

	@Override
	public void adminFunctionsuperviseCity() throws Exception {
		AdminView.adminOperateCityPage();
	}

	@Override
	public void adminFunctionsuperviseSession() throws Exception {
		AdminView.adminOperateSessionPage();
	}

	@Override
	public void adminFunctionsuperviseSeat() throws Exception {
		AdminView.adminOperateSeatPage();
	}

	@Override
	public void adminFunctionsuperviseUser() throws Exception {
		AdminView.adminOperateUserPage();	
	}

	@Override
	public void adminFunctionsuperviseAssessment() throws Exception {
		AdminView.adminOperateAssessmentPage();
	}

	@Override
	public void adminFunctionsuperviseFilmTicket() throws Exception {
		AdminView.adminOperateFilMTicketPage();
	}
}
