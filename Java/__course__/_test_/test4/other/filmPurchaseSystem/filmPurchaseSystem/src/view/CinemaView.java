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
		System.out.println("������Ҫ��ӵĵ�ӰԺ������");
		String cinemaName = input.next();
		System.out.println("�õ�ӰԺ��Ҫ��ӵ��������У�������±�������б�ţ�");
		CityDao cityDao =  new CityDaoImpl();
		try {
			List<City> citys = cityDao.queryCitys();
			System.out.println("���\t����");
			for(City city:citys) {
				System.out.println(CityView.CityToString(city));
			}
			int cityId=0;
			cityId=HandleInputMismatchException.handleInputMismatchException(cityId);
			cinema = new Cinema(cinemaName,cityId);
			cd.addCinema(cinema);
			System.out.println("��ӰԺ��ӳɹ�������");
			System.out.println("��Ϊ����ת����һ���б�");
			AdminView.adminOperateCinemaPage();
			return cinema;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void CinemaDeletePage() throws Exception {
		System.out.println("������Ҫɾ���ĵ�ӰԺ���ڵĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("������ĳ��в���ϵͳ�У�����������");
			CinemaDeletePage();
		}
		a:while(true) {
			System.out.println("������Ҫɾ���ĵ�ӰԺ����");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("�������ӰԺ���Ƶ�ǰ����û�У�����������");
				continue a;
			}
			System.out.println("��������Ҫɾ���ĵ�ӰԺ��Ϣ��ȷ��ɾ��������1,��ɾ�������������֣������ѡ��");
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
						System.out.println("ɾ���ɹ�");
						System.out.println("��Ϊ����ת����һ���б�");
						AdminView.adminOperateCinemaPage();
					}else {
						System.out.println("ɾ��ʧ��");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("��ѡ������������");
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
			System.out.println("��Ϊ����ת����һ���б�");
			AdminView.adminOperateCinemaPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void CinemaSeeCityAllPage() throws Exception {
		System.out.println("������Ҫ���ҵĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("������ĳ��в���ϵͳ�У�����������");
			CinemaSeeCityAllPage();
		}
		try {
			List<Cinema> cinemas;
			cinemas = cd.queryCinemaByCity(cityName);
			for(Cinema cinema :cinemas) {
				System.out.println(CinemaToString(cinema));
			}
			System.out.println("��Ϊ����ת����һ���б�");
			AdminView.adminOperateCinemaPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void CinemaSeePage() throws Exception {
		System.out.println("������Ҫ�鿴�ĵ�ӰԺ���ڵĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("������ĳ��в���ϵͳ�У�����������");
			CinemaDeletePage();
		}
		a:while(true) {
			System.out.println("������Ҫ�鿴�ĵ�ӰԺ����");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("�������ӰԺ���Ƶ�ǰ����û�У�����������");
				continue a;
			}
			try {
				System.out.println("��������Ҫ�鿴����Ϣ��");
				System.out.println(CinemaToString(cd.queryCinema(cityName, cinemaName)));
				System.out.println("��Ϊ����ת����һ���б�");
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
