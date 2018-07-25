package view;

import java.util.List;
import java.util.Scanner;

import dao.CinemaDao;
import dao.CityDao;
import dao.HallDao;
import dao.SeatDao;
import dao.impl.CinemaDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.HallDaoImpl;
import dao.impl.SeatDaoImpl;
import entity.Cinema;
import entity.City;
import help.HandleInputMismatchException;

public class CinemaView {
	
	static Scanner input = new Scanner(System.in);
	static Cinema cinema = new Cinema();
	static CinemaDao cd = new CinemaDaoImpl();
	
	public static Cinema CinemaAddPage() {
		System.out.println("请输入要添加的电影院姓名：");
		String cinemaName = input.next();
		System.out.println("该电影院需要添加到哪座城市，请对照下表输入城市编号：");
		CityDao cityDao =  new CityDaoImpl();
		try {
			List<City> citys = cityDao.queryCitys();
			System.out.println("编号\t名称");
			for(City city:citys) {
				System.out.println(CityView.CityToString(city));
			}
			int cityId=0;
			cityId=HandleInputMismatchException.handleInputMismatchException(cityId);
			cinema = new Cinema(cinemaName,cityId);
			cd.addCinema(cinema);
			System.out.println("电影院添加成功！！！");
			System.out.println("已为您跳转到上一级列表：");
			AdminView.adminOperateCinemaPage();
			return cinema;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void CinemaDeletePage() throws Exception {
		System.out.println("请输入要删除的电影院所在的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("您输入的城市不在系统中，请重新输入");
			CinemaDeletePage();
		}
		a:while(true) {
			System.out.println("请输入要删除的电影院名：");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("您输入的影院名称当前城市没有，请重新输入");
				continue a;
			}
			System.out.println("下面是你要删除的电影院信息，确认删除请输入1,不删请输入其他数字，请谨慎选择：");
			try {
				cinema = cd.queryCinema(cityName, cinemaName);
				System.out.println(CinemaToString(cinema));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int choose=0;
			choose=HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				try {
					int i=cd.deleteCinema(cityName, cinemaName);
					HallDao hd = new HallDaoImpl();
					SeatDao sd = new SeatDaoImpl();
					hd.deleteHallCinmeaIsNull();
					sd.deleteSeatCinemaIsNull();
					if(i>0) {
						System.out.println("删除成功");
						System.out.println("已为您跳转到上一级列表：");
						AdminView.adminOperateCinemaPage();
					}else {
						System.out.println("删除失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("请选择其他操作：");
				AdminView.adminOperateCinemaPage();
				break;
			}
			break;
		}	
	}
	
	public static void CinemaSeeAllPage() {
		try {
			List<Cinema> cinemas;
			cinemas = cd.queryCinemas();
			for(Cinema cinema :cinemas) {
				System.out.println(CinemaToString(cinema));
			}
			System.out.println("已为您跳转到上一级列表：");
			AdminView.adminOperateCinemaPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void CinemaSeeCityAllPage() throws Exception {
		System.out.println("请输入要查找的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("您输入的城市不在系统中，请重新输入");
			CinemaSeeCityAllPage();
		}
		try {
			List<Cinema> cinemas;
			cinemas = cd.queryCinemaByCity(cityName);
			for(Cinema cinema :cinemas) {
				System.out.println(CinemaToString(cinema));
			}
			System.out.println("已为您跳转到上一级列表：");
			AdminView.adminOperateCinemaPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void CinemaSeePage() throws Exception {
		System.out.println("请输入要查看的电影院所在的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("您输入的城市不在系统中，请重新输入");
			CinemaDeletePage();
		}
		a:while(true) {
			System.out.println("请输入要查看的电影院名：");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("您输入的影院名称当前城市没有，请重新输入");
				continue a;
			}
			try {
				System.out.println("下面是您要查看的信息：");
				System.out.println(CinemaToString(cd.queryCinema(cityName, cinemaName)));
				System.out.println("已为您跳转到上一级列表：");
				AdminView.adminOperateCinemaPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}
	public static String CinemaToString(Cinema cinema) {
		return cinema.getCinemaId()+"\t"+cinema.getCinemaName();
	}
}
