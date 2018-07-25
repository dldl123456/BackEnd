package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.SessionDao;
import dao.impl.CinemaDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.HallDaoImpl;
import dao.impl.MovieDaoImpl;
import dao.impl.SessionDaoImpl;
import entity.Session;
import help.HandleInputMismatchException;
import help.Time;

public class SessionView {
	static Scanner input = new Scanner(System.in);
	static Session session = new Session();
	static SessionDao sd = new SessionDaoImpl();
	public static Session SessionAddPage() {
		try {
			a:while(true) {
				System.out.println("请输入要添加场次的电影名：");
				String movieName = input.next();
				if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
					int movieId = (new MovieDaoImpl()).queryMovie(movieName).getMovieId();
					b:while(true) {
						System.out.println("请输入要添加到的城市名称：");
						String cityName = input.next();
						if(new CityDaoImpl().comparisonCityName(cityName)!=-1) {
							c:while(true) {
								System.out.println("请输入要添加到的电影院名称：");
								String cinemaName = input.next();
								if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)!=-1) {
									d:while(true) {
										System.out.println("请输入要添加到的影厅名称：");
										String hallName = input.next();
										if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)!=-1) {
											int hallId = (new HallDaoImpl()).queryHall(cityName, cinemaName, hallName).getHallId();
											e:while(true) {
												System.out.println("请输入开始时间：请按照模板样式输入(yyyyMMddHHmm)(中文输入法)");
												String sessionStartTime = input.next();
												Date date1 = Time.StringToDate(sessionStartTime);//判断格式是否正确
												if(date1==null) {
													continue e;
												}
												if(Time.compareTo4(date1)) {
													sessionStartTime = Time.DateToString(date1);//转回String类型
													if(new SessionDaoImpl().comparisonSessionHall(hallId,date1)==-1) {
														f:while(true) {
															System.out.println("请输入结束时间：请按照模板样式输入(yyyyMMddHHmm)(中文输入法)");
															String sessionStopTime = input.next();
															Date date2 = Time.StringToDate(sessionStopTime);//判断格式是否正确
															if(date2==null) {
																continue f;
															}
															sessionStopTime = Time.DateToString(date2);//转回String类型
															if(new SessionDaoImpl().comparisonSessionHall(hallId, date2)==-1) {
																date1 = Time.StringToDate(sessionStartTime);
																date2 = Time.StringToDate(sessionStopTime);
																if(Time.compareTo3(date1, date2)) {
																	session = new Session(hallId,sessionStartTime,sessionStopTime,movieId);																
																}else {
																	System.out.println("本场场次时间过长，超出三小时，请重新输入结束时间：");
																	continue f;
																}
																break;
															}else {
																System.out.println("您要添加的开始时间与当前已有场次的时间段冲突，请您查证后重新输入：");
																//System.out.println("为您显示当前厅的所有场次信息：");
																continue f;
															}
														}
														break;
													}else {
														System.out.println("您要添加的开始时间与当前已有场次的时间段冲突，请您查证后重新输入：");
														//System.out.println("为您显示当前厅的所有场次信息：");
														continue e;
													}
												}else {
													System.out.println("只能添加当前时间以后三天内的场次，请您重新输入时间：");
													continue e;
												}						
											}
											break;
										}else {
											System.out.println("该影院没有您要添加的影厅，请查证后重新输入：");
											continue d;
										}
									}
									break;
								}else {
									System.out.println("该城市没有您要添加的电影院，请查证后重新输入：");
									continue c;
								}
							}
							break;
						}else {
							System.out.println("您输入的城市不存在或输入错误，请查证后重新输入：");
							continue b;
						}
					}
					break;
				}else {
					System.out.println("您输入的电影不存在或输入错误，请查证后重新输入：");
					continue a;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return session;
	}
	
	public static void SessionDeletePage() throws Exception {
		System.out.println("请输入要删除的场次编号：");
		int sessionId=0;
		sessionId=HandleInputMismatchException.handleInputMismatchException(sessionId);
		if(new SessionDaoImpl().comparisonSessionByid(sessionId)==-1) {
			System.out.println("您输入的编号不存在或已经被删除");
			AdminView.adminOperateSessionPage();
		}
		System.out.println("下面是你要删除的场次信息，确认删除请输入1,不删请输入其他数字，请谨慎选择：");
		try {
			session = sd.querySessionById(sessionId);
			System.out.println(sessionToString(session));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int choose=0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			try {
				int i=sd.deleteSession(sessionId);
				if(i>0) {
					System.out.println("删除成功");
					System.out.println("请选择其他操作：");
					AdminView.adminOperateSessionPage();
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
			AdminView.adminOperateMoviePage();
			break;
		}
	}
	
	/*public static void SessionUpdateSession() {
		System.out.println("请输入要修改的场次编号：");
		int sessionId = input.nextInt();
		try {
			session = sd.querySessionById(sessionId);
			System.out.println("下面是您要修改的场次的详细信息，请选择您要修改的信息：");
			System.out.println(session);
			System.out.println("【1】、修改");
			sd.updateSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static void SessionSeeAllPage() {
		try {
			List<Session> sessions;
			sessions = sd.querySessions();
			for(Session session :sessions) {
				System.out.println(sessionToString(session));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateSessionPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void SessionSeeCinemaAllPage() throws Exception {
		System.out.println("请输入要查找的电影院所在城市：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("您输入的城市不存在，请重新输入！");
			SessionSeeCinemaAllPage();
		}
		a:while(true) {
			System.out.println("请输入要查找的电影院名称：");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("该城市没有你要查找的电影院，请重新输入！");
				continue a;
			}
			try {
				List<Session> sessions;
				sessions = sd.querySessionByCinema(cinemaName,cityName);
				for(Session session :sessions) {
					System.out.println(sessionToString(session));
				}
				System.out.println("请选择其他操作：");
				AdminView.adminOperateSessionPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	
	public static void SessionSeeMovieAllPage() throws Exception {
		System.out.println("请输入要查找的电影名称：");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("系统中没有您要查找的电影名，请重新输入");
			SessionSeeMovieAllPage();
		}
		try {
			List<Session> sessions;
			sessions = sd.querySessionByMovieName(movieName);
			for(Session session :sessions) {
				System.out.println(sessionToString(session));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateSessionPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void SessionSeeCinemaMovieAllPage() throws Exception {
		System.out.println("请输入要查看的城市名称：");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("您输入的城市不存在，请重新输入！");
			SessionSeeCinemaMovieAllPage();
		}
		a:while(true) {
			System.out.println("请输入要查找的电影名称：");
			String movieName = input.next();
			if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
				System.out.println("系统中没有您要查找的电影名，请重新输入");
				continue a;
			}
			b:while(true) {
				System.out.println("查看想要查看的影院名称");
				String cinemaName = input.next();
				if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
					System.out.println("该城市没有你要查找的电影院，请重新输入！");
					continue b;
				}
				try {
					List<Session> sessions;
					sessions = sd.querySessionByCinemaMovie(cinemaName, movieName,cityName);
					for(Session session :sessions) {
						System.out.println(sessionToString(session));
					}
					System.out.println("请选择其他操作：");
					AdminView.adminOperateSessionPage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}				
			break;
		}
	}
	
	public static void SessionSeePage() throws Exception {
		System.out.println("请输入你要查看的场次编号：");
		int sessionId=0;
		sessionId=HandleInputMismatchException.handleInputMismatchException(sessionId);
		if(new SessionDaoImpl().comparisonSessionByid(sessionId)==-1) {
			System.out.println("系统中没有您要查看的场次，请重新输入");
			SessionSeePage();
		}
		try {
			System.out.println("下面是您要查找的场次详细信息：");
			System.out.println(sessionToString(sd.querySessionById(sessionId)));
			System.out.println("请选择其他操作：");
			AdminView.adminOperateSessionPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String sessionToString(Session session) throws Exception {
		String hallName = new HallDaoImpl().queryHallById(session.getSessionHall()).getHallName();
		String movieName = new MovieDaoImpl().queryMovieById(session.getSessionMovie()).getMovieName();
		return session.getSessionId()+"\t"+hallName+"\t"+movieName+"\t"+session.getSessionStarttime()+"\t"+session.getSeesionStoptime();
	}
}
