package service.impl;

import dao.CinemaDao;
import dao.impl.CinemaDaoImpl;
import entity.Cinema;
import service.CinemaService;
import view.CinemaView;

public class CinemaServiceImpl implements CinemaService {
	Cinema cinema = new Cinema();
	CinemaDao cd = new CinemaDaoImpl();
	@Override
	public void adminFunctionAddCinema() throws Exception {
		cinema=CinemaView.CinemaAddPage();
	}

	@Override
	public void adminFunctionDeleteCinema() throws Exception {
		CinemaView.CinemaDeletePage();
	}

	@Override
	public void adminFunctionSeeAllCinema() throws Exception {
		CinemaView.CinemaSeeAllPage();
	}

	@Override
	public void adminFunctionSeeCityAllCinema() throws Exception {
		CinemaView.CinemaSeeCityAllPage();
	}

	@Override
	public void aadminFunctionSeeCinema() throws Exception {
		CinemaView.CinemaSeePage();
	}

}
