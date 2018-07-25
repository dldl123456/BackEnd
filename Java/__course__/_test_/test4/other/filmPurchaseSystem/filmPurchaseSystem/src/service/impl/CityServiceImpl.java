package service.impl;

import service.CityService;
import view.CityView;

public class CityServiceImpl implements CityService {
	@Override
	public void adminFunctionAddCity() throws Exception {
		CityView.CityAddPage();
	}

	@Override
	public void adminFunctionSeeAllCity() throws Exception {
		CityView.CitySeeAllPage();
	}

}
