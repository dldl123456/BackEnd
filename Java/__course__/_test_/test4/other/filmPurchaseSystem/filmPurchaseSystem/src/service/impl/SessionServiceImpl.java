package service.impl;

import dao.SessionDao;
import dao.impl.SessionDaoImpl;
import entity.Session;
import service.SessionService;
import view.AdminView;
import view.SessionView;

public class SessionServiceImpl implements SessionService {
	Session session = new Session();
	SessionDao sd = new SessionDaoImpl();
	
	public static void main(String[] args) {
		SessionServiceImpl ssi = new SessionServiceImpl();
		try {
			ssi.adminFunctionAddSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void adminFunctionAddSession() throws Exception {
		session=SessionView.SessionAddPage();
		sd.addSession(session);
		System.out.println("添加成功！！！");
		System.out.println("请选择其他操作：");
		AdminView.adminOperateSessionPage();
	}

	@Override
	public void adminFunctionDeleteSession() throws Exception {
		SessionView.SessionDeletePage();
	}

	@Override
	public void adminFunctionUpdateSessionName() throws Exception {
		
		
	}

	@Override
	public void adminFunctionSeeAllSession() throws Exception {
		SessionView.SessionSeeAllPage();	
	}

	@Override
	public void adminFunctionSeeCinemaAllSession() throws Exception {
		SessionView.SessionSeeCinemaAllPage();	
	}

	@Override
	public void adminFunctionSeeMovieAllSession() throws Exception {
		SessionView.SessionSeeMovieAllPage();	
	}

	@Override
	public void adminFunctionSeeCinemaMovieAllSession() throws Exception {
		SessionView.SessionSeeCinemaMovieAllPage();	
	}

	@Override
	public void aadminFunctionSeeSession() throws Exception {
		SessionView.SessionSeePage();	
	}

}
