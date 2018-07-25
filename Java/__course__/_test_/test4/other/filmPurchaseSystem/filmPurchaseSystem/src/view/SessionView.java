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
				System.out.println("������Ҫ��ӳ��εĵ�Ӱ����");
				String movieName = input.next();
				if(new MovieDaoImpl().comparisonMovieName(movieName)!=-1) {
					int movieId = (new MovieDaoImpl()).queryMovie(movieName).getMovieId();
					b:while(true) {
						System.out.println("������Ҫ��ӵ��ĳ������ƣ�");
						String cityName = input.next();
						if(new CityDaoImpl().comparisonCityName(cityName)!=-1) {
							c:while(true) {
								System.out.println("������Ҫ��ӵ��ĵ�ӰԺ���ƣ�");
								String cinemaName = input.next();
								if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)!=-1) {
									d:while(true) {
										System.out.println("������Ҫ��ӵ���Ӱ�����ƣ�");
										String hallName = input.next();
										if(new HallDaoImpl().comparisonHallName(hallName, cinemaName, cityName)!=-1) {
											int hallId = (new HallDaoImpl()).queryHall(cityName, cinemaName, hallName).getHallId();
											e:while(true) {
												System.out.println("�����뿪ʼʱ�䣺�밴��ģ����ʽ����(yyyyMMddHHmm)(�������뷨)");
												String sessionStartTime = input.next();
												Date date1 = Time.StringToDate(sessionStartTime);//�жϸ�ʽ�Ƿ���ȷ
												if(date1==null) {
													continue e;
												}
												if(Time.compareTo4(date1)) {
													sessionStartTime = Time.DateToString(date1);//ת��String����
													if(new SessionDaoImpl().comparisonSessionHall(hallId,date1)==-1) {
														f:while(true) {
															System.out.println("���������ʱ�䣺�밴��ģ����ʽ����(yyyyMMddHHmm)(�������뷨)");
															String sessionStopTime = input.next();
															Date date2 = Time.StringToDate(sessionStopTime);//�жϸ�ʽ�Ƿ���ȷ
															if(date2==null) {
																continue f;
															}
															sessionStopTime = Time.DateToString(date2);//ת��String����
															if(new SessionDaoImpl().comparisonSessionHall(hallId, date2)==-1) {
																date1 = Time.StringToDate(sessionStartTime);
																date2 = Time.StringToDate(sessionStopTime);
																if(Time.compareTo3(date1, date2)) {
																	session = new Session(hallId,sessionStartTime,sessionStopTime,movieId);																
																}else {
																	System.out.println("��������ʱ�������������Сʱ���������������ʱ�䣺");
																	continue f;
																}
																break;
															}else {
																System.out.println("��Ҫ��ӵĿ�ʼʱ���뵱ǰ���г��ε�ʱ��γ�ͻ��������֤���������룺");
																//System.out.println("Ϊ����ʾ��ǰ�������г�����Ϣ��");
																continue f;
															}
														}
														break;
													}else {
														System.out.println("��Ҫ��ӵĿ�ʼʱ���뵱ǰ���г��ε�ʱ��γ�ͻ��������֤���������룺");
														//System.out.println("Ϊ����ʾ��ǰ�������г�����Ϣ��");
														continue e;
													}
												}else {
													System.out.println("ֻ����ӵ�ǰʱ���Ժ������ڵĳ��Σ�������������ʱ�䣺");
													continue e;
												}						
											}
											break;
										}else {
											System.out.println("��ӰԺû����Ҫ��ӵ�Ӱ�������֤���������룺");
											continue d;
										}
									}
									break;
								}else {
									System.out.println("�ó���û����Ҫ��ӵĵ�ӰԺ�����֤���������룺");
									continue c;
								}
							}
							break;
						}else {
							System.out.println("������ĳ��в����ڻ�����������֤���������룺");
							continue b;
						}
					}
					break;
				}else {
					System.out.println("������ĵ�Ӱ�����ڻ�����������֤���������룺");
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
		System.out.println("������Ҫɾ���ĳ��α�ţ�");
		int sessionId=0;
		sessionId=HandleInputMismatchException.handleInputMismatchException(sessionId);
		if(new SessionDaoImpl().comparisonSessionByid(sessionId)==-1) {
			System.out.println("������ı�Ų����ڻ��Ѿ���ɾ��");
			AdminView.adminOperateSessionPage();
		}
		System.out.println("��������Ҫɾ���ĳ�����Ϣ��ȷ��ɾ��������1,��ɾ�������������֣������ѡ��");
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
					System.out.println("ɾ���ɹ�");
					System.out.println("��ѡ������������");
					AdminView.adminOperateSessionPage();
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
			AdminView.adminOperateMoviePage();
			break;
		}
	}
	
	/*public static void SessionUpdateSession() {
		System.out.println("������Ҫ�޸ĵĳ��α�ţ�");
		int sessionId = input.nextInt();
		try {
			session = sd.querySessionById(sessionId);
			System.out.println("��������Ҫ�޸ĵĳ��ε���ϸ��Ϣ����ѡ����Ҫ�޸ĵ���Ϣ��");
			System.out.println(session);
			System.out.println("��1�����޸�");
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
			System.out.println("��ѡ������������");
			AdminView.adminOperateSessionPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void SessionSeeCinemaAllPage() throws Exception {
		System.out.println("������Ҫ���ҵĵ�ӰԺ���ڳ��У�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("������ĳ��в����ڣ����������룡");
			SessionSeeCinemaAllPage();
		}
		a:while(true) {
			System.out.println("������Ҫ���ҵĵ�ӰԺ���ƣ�");
			String cinemaName = input.next();
			if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
				System.out.println("�ó���û����Ҫ���ҵĵ�ӰԺ�����������룡");
				continue a;
			}
			try {
				List<Session> sessions;
				sessions = sd.querySessionByCinema(cinemaName,cityName);
				for(Session session :sessions) {
					System.out.println(sessionToString(session));
				}
				System.out.println("��ѡ������������");
				AdminView.adminOperateSessionPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	
	public static void SessionSeeMovieAllPage() throws Exception {
		System.out.println("������Ҫ���ҵĵ�Ӱ���ƣ�");
		String movieName = input.next();
		if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
			System.out.println("ϵͳ��û����Ҫ���ҵĵ�Ӱ��������������");
			SessionSeeMovieAllPage();
		}
		try {
			List<Session> sessions;
			sessions = sd.querySessionByMovieName(movieName);
			for(Session session :sessions) {
				System.out.println(sessionToString(session));
			}
			System.out.println("��ѡ������������");
			AdminView.adminOperateSessionPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void SessionSeeCinemaMovieAllPage() throws Exception {
		System.out.println("������Ҫ�鿴�ĳ������ƣ�");
		String cityName = input.next();
		if(new CityDaoImpl().comparisonCityName(cityName)==-1) {
			System.out.println("������ĳ��в����ڣ����������룡");
			SessionSeeCinemaMovieAllPage();
		}
		a:while(true) {
			System.out.println("������Ҫ���ҵĵ�Ӱ���ƣ�");
			String movieName = input.next();
			if(new MovieDaoImpl().comparisonMovieName(movieName)==-1) {
				System.out.println("ϵͳ��û����Ҫ���ҵĵ�Ӱ��������������");
				continue a;
			}
			b:while(true) {
				System.out.println("�鿴��Ҫ�鿴��ӰԺ����");
				String cinemaName = input.next();
				if(new CinemaDaoImpl().comparisonCinemaName(cinemaName, cityName)==-1) {
					System.out.println("�ó���û����Ҫ���ҵĵ�ӰԺ�����������룡");
					continue b;
				}
				try {
					List<Session> sessions;
					sessions = sd.querySessionByCinemaMovie(cinemaName, movieName,cityName);
					for(Session session :sessions) {
						System.out.println(sessionToString(session));
					}
					System.out.println("��ѡ������������");
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
		System.out.println("��������Ҫ�鿴�ĳ��α�ţ�");
		int sessionId=0;
		sessionId=HandleInputMismatchException.handleInputMismatchException(sessionId);
		if(new SessionDaoImpl().comparisonSessionByid(sessionId)==-1) {
			System.out.println("ϵͳ��û����Ҫ�鿴�ĳ��Σ�����������");
			SessionSeePage();
		}
		try {
			System.out.println("��������Ҫ���ҵĳ�����ϸ��Ϣ��");
			System.out.println(sessionToString(sd.querySessionById(sessionId)));
			System.out.println("��ѡ������������");
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
