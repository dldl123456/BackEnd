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
		System.out.println("请输入要添加的影厅姓名：");
		String hallName = input.next();
		a:while(true) {
			System.out.println("该影厅需要添加到那个影院，请对照下表输入电影院编号：");
			CinemaDao cinemaDao =  new CinemaDaoImpl();
			try {
				List<Cinema> cinemas = cinemaDao.queryCinemas();
				for(Cinema cinema:cinemas) {
					System.out.println(CinemaView.CinemaToString(cinema));
				}
				int cinemaId=0;
				cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
				if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)==-1) {
					System.out.println("您输入的编号超出系统范围，请重新输入！");
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
		System.out.println("请输入要删除的影厅所在的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("系统中没有您输入的城市，请您重新输入！");
			HallDeletePage();
		}
		a:while(true) {
			System.out.println("情输入要删除的影厅所在的电影院名称");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("当前城市没有您输入的电影院，请重新输入！");
				continue a;
			}
			b:while(true) {
				System.out.println("请输入要删除的影厅名：");
				String hallName = input.next();
				if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)==-1) {
					System.out.println("当前影院没有您输入的影厅，请重新输入！");
					continue b;
				}
				System.out.println("下面是你要删除的影厅信息，确认删除请输入1,不删请输入其他数字，请谨慎选择：");
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
							System.out.println("删除成功");
							System.out.println("请选择下一步操作：");
							AdminView.adminOperateHallPage();
						}else {
							System.out.println("删除失败");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("请选择下一步操作：");
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
				System.out.println("请选择下一步操作：");
				AdminView.adminOperateHallPage();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void HallSeeCityCinemaAllPage() throws Exception {
		System.out.println("请输入该影厅所在影院的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("系统中没有您输入的城市，请您重新输入！");
			HallSeeCityCinemaAllPage();
		}
		a:while(true) {
			System.out.println("请输入要查找的电影院名称：");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("当前城市没有您输入的电影院，请重新输入！");
				continue a;
			}
			try {
				List<Hall> halls;
				halls = hd.queryHallByCinemaCity(cinemaName, cityName);
				for(Hall hall :halls) {
					System.out.println(HallToString(hall));
					System.out.println("请选择下一步操作：");
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
		System.out.println("请输入该影厅所在影院的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("系统中没有您输入的城市，请您重新输入！");
			HallSeePage();
		}
		a:while(true) {
			System.out.println("请输入要查找的影厅所在的影院名称：");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("当前城市没有您输入的电影院，请重新输入！");
				continue a;
			}
			b:while(true) {
				System.out.println("请输入你要查询的影厅名字：");
				String hallName = input.next();
				if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)==-1) {
					System.out.println("当前影院没有您输入的影厅，请重新输入！");
					continue b;
				}
				try {
					System.out.println(hd.queryHall(cityName,cinemaName, hallName));
					System.out.println("请选择下一步操作：");
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
		System.out.println("请输入要修改的影厅编号：");
		int hallId = input.nextInt();
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("当前影院没有您输入的影厅，请重新输入！");
			HallUpdateHallName();
		}
		System.out.println("请输入要修改的名称：");
		String newHallName = input.next();
		try {
			hd.updateHallName(newHallName, hallId);
			System.out.println("请选择下一步操作：");
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
