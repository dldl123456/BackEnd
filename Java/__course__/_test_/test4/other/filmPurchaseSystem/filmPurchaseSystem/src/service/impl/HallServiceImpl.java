package service.impl;

import dao.HallDao;
import dao.impl.HallDaoImpl;
import entity.Hall;
import service.HallService;
import view.AdminView;
import view.HallView;

public class HallServiceImpl implements HallService {
	/*public static void main(String[] args) {
		HallServiceImpl hsi = new HallServiceImpl();
		try {
			hsi.adminFunctionAddHall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	Hall hall = new Hall();
	HallDao cd = new HallDaoImpl();
	@Override
	public void adminFunctionAddHall() throws Exception {
		hall=HallView.HallAddPage();
		cd.addHall(hall);
		System.out.println("影厅添加成功！！！");
		System.out.println("请选择下一步操作：");
		AdminView.adminOperateHallPage();
	}

	@Override
	public void adminFunctionDeleteHall() throws Exception {
		HallView.HallDeletePage();
	}

	@Override
	public void adminFunctionSeeAllHall() throws Exception {
		HallView.HallSeeAllPage();
	}

	@Override
	public void adminFunctionSeeCityAllHall() throws Exception {
		HallView.HallSeeCityCinemaAllPage();
	}

	@Override
	public void aadminFunctionSeeHall() throws Exception {
		HallView.HallSeePage();
	}

	@Override
	public void adminFunctionUpdateHallName() throws Exception {
		HallView.HallUpdateHallName();
	}

}
