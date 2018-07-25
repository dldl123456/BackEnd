package view;

import java.util.List;
import java.util.Scanner;

import dao.CinemaDao;
import dao.HallDao;
import dao.SeatDao;
import dao.impl.CinemaDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.HallDaoImpl;
import dao.impl.SeatDaoImpl;
import entity.Cinema;
import entity.Hall;
import help.HandleInputMismatchException;

public class HallView {
	static Scanner input = new Scanner(System.in);
	static Hall hall = new Hall();
	static HallDao hd = new HallDaoImpl();
	
	public static Hall HallAddPage() {
		System.out.println("������Ҫ��ӵ�Ӱ��������");
		String hallName = input.next();
		a:while(true) {
			System.out.println("��Ӱ����Ҫ��ӵ��Ǹ�ӰԺ��������±������ӰԺ��ţ�");
			CinemaDao cinemaDao =  new CinemaDaoImpl();
			try {
				List<Cinema> cinemas = cinemaDao.queryCinemas();
				for(Cinema cinema:cinemas) {
					System.out.println(CinemaView.CinemaToString(cinema));
				}
				int cinemaId=0;
				cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
				if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
					System.out.println("������ı�ų���ϵͳ��Χ�����������룡");
					continue a;
				}
				hall = new Hall(hallName,cinemaId);
				return hall;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}	
		return null;
	}
	public static void HallDeletePage() throws Exception {
		System.out.println("������Ҫɾ����Ӱ�����ڵĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("ϵͳ��û��������ĳ��У������������룡");
			HallDeletePage();
		}
		a:while(true) {
			System.out.println("������Ҫɾ����Ӱ�����ڵĵ�ӰԺ����");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("��ǰ����û��������ĵ�ӰԺ�����������룡");
				continue a;
			}
			b:while(true) {
				System.out.println("������Ҫɾ����Ӱ������");
				String hallName = input.next();
				if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)==-1) {
					System.out.println("��ǰӰԺû���������Ӱ�������������룡");
					continue b;
				}
				System.out.println("��������Ҫɾ����Ӱ����Ϣ��ȷ��ɾ��������1,��ɾ�������������֣������ѡ��");
				try {
					hall = hd.queryHall(cityName,cinemaName, hallName);
					System.out.println(HallView.HallToString(hall));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int choose=0;
				choose=HandleInputMismatchException.handleInputMismatchException(choose);
				switch(choose) {
				case 1:
					try {
						int i=hd.deleteHall(cityName,cinemaName, hallName);
						SeatDao sd = new SeatDaoImpl();
						sd.deleteSeatHallIsNull();
						if(i>0) {
							System.out.println("ɾ���ɹ�");
							System.out.println("��ѡ����һ��������");
							AdminView.adminOperateHallPage();
						}else {
							System.out.println("ɾ��ʧ��");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("��ѡ����һ��������");
					AdminView.adminOperateHallPage();
					break;
				}
				break;
			}
			break;
		}
	}
	
	public static void HallSeeAllPage() {
		try {
			List<Hall> halls;
			halls = hd.queryHalls();
			for(Hall hall :halls) {
				System.out.println(HallToString(hall));
				System.out.println("��ѡ����һ��������");
				AdminView.adminOperateHallPage();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void HallSeeCityCinemaAllPage() throws Exception {
		System.out.println("�������Ӱ������ӰԺ�ĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("ϵͳ��û��������ĳ��У������������룡");
			HallSeeCityCinemaAllPage();
		}
		a:while(true) {
			System.out.println("������Ҫ���ҵĵ�ӰԺ���ƣ�");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("��ǰ����û��������ĵ�ӰԺ�����������룡");
				continue a;
			}
			try {
				List<Hall> halls;
				halls = hd.queryHallByCinemaCity(cinemaName, cityName);
				for(Hall hall :halls) {
					System.out.println(HallToString(hall));
					System.out.println("��ѡ����һ��������");
					AdminView.adminOperateHallPage();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	public static void HallSeePage() throws Exception {
		System.out.println("�������Ӱ������ӰԺ�ĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("ϵͳ��û��������ĳ��У������������룡");
			HallSeePage();
		}
		a:while(true) {
			System.out.println("������Ҫ���ҵ�Ӱ�����ڵ�ӰԺ���ƣ�");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("��ǰ����û��������ĵ�ӰԺ�����������룡");
				continue a;
			}
			b:while(true) {
				System.out.println("��������Ҫ��ѯ��Ӱ�����֣�");
				String hallName = input.next();
				if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)==-1) {
					System.out.println("��ǰӰԺû���������Ӱ�������������룡");
					continue b;
				}
				try {
					System.out.println(hd.queryHall(cityName,cinemaName, hallName));
					System.out.println("��ѡ����һ��������");
					AdminView.adminOperateHallPage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}			
			break;
		}
	}
	public static void HallUpdateHallName() throws Exception {
		System.out.println("������Ҫ�޸ĵ�Ӱ����ţ�");
		int hallId = input.nextInt();
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("��ǰӰԺû���������Ӱ�������������룡");
			HallUpdateHallName();
		}
		System.out.println("������Ҫ�޸ĵ����ƣ�");
		String newHallName = input.next();
		try {
			hd.updateHallName(newHallName, hallId);
			System.out.println("��ѡ����һ��������");
			AdminView.adminOperateHallPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String HallToString(Hall hall) throws Exception {
		String cinemaName = new CinemaDaoImpl().queryCinemaById(hall.getHallCinema()).getCinemaName();
		return hall.getHallId()+"\t"+hall.getHallName()+"\t"+cinemaName;
	}
}
