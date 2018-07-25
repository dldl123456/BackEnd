package view;

import java.util.Date;
import java.util.List;

import dao.FilmTicketDao;
import dao.impl.CinemaDaoImpl;
import dao.impl.CityDaoImpl;
import dao.impl.FilmTicketDaoImpl;
import dao.impl.HallDaoImpl;
import dao.impl.MovieDaoImpl;
import dao.impl.SeatDaoImpl;
import dao.impl.SessionDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Cinema;
import entity.FilmTicket;
import entity.Movie;
import entity.Seat;
import entity.Session;
import help.HandleInputMismatchException;
import help.Time;

public class FilmTicketView {
	static FilmTicket ticket = new FilmTicket();
	static FilmTicketDao tdi = new FilmTicketDaoImpl();
	/**
	 * ֱ����Ʊ
	 * @return
	 * @throws Exception 
	 */
	public static FilmTicket FilmTicketBuyPage(int userId,int cityId) throws Exception {
		System.out.println("������Ҫѡ��ĵ�Ӱ��ţ�");
		System.out.println("��Ӱ���\t��Ӱ����");
		List<Movie> movies=new MovieDaoImpl().queryMovies();
		for(Movie movie:movies) {
			System.out.println(MovieView.movieToString2(movie));
		}
		int movieNumber=0;
		movieNumber=HandleInputMismatchException.handleInputMismatchException(movieNumber);
		if(new MovieDaoImpl().comparisonMovieId(movieNumber)!=-1) {
			int movieId=movieNumber;
			a:while(true) {
				System.out.println("������Ҫѡ���ӰԺ��ţ�");
				System.out.println("��ӰԺ���\t��ӰԺ����");
				String cityName = new CityDaoImpl().queryCityById(cityId).getCityName();
				List<Cinema> cinemas = new CinemaDaoImpl().queryCinemaByCity(cityName);
				for(Cinema cinema:cinemas) {
					System.out.println(CinemaView.CinemaToString(cinema));
				}
				int cinemaNumber=0;
				cinemaNumber=HandleInputMismatchException.handleInputMismatchException(cinemaNumber);
				if(new CinemaDaoImpl().comparisonCinemaId(cinemaNumber,cityName)!=-1) {
					int cinemaId=cinemaNumber;
					String movieName = new MovieDaoImpl().queryMovieById(movieId).getMovieName();
					String cinemaName = new CinemaDaoImpl().queryCinemaById(cinemaId).getCinemaName();
					List<Session> sessions = new SessionDaoImpl().querySessionByCinemaMovie(cinemaName, movieName,cityName);
					if(sessions.size()==0) {
						System.out.println("�ǳ���Ǹ����ѡ�еĵ�ӰԺ��û����ص�Ӱ�ĳ��Σ�������ѡ��ӰԺ��");
						continue a;
					}
					b:while(true) {						
						System.out.println("��������Ҫѡ��ĳ��α�ţ�");
						System.out.println("���α��\tӰ������\t���ŵ�Ӱ\t����ʱ��\t����ʱ�䣺");
						for(Session session:sessions) {
							/*
							 * �жϳ���ʱ���Ƿ��ڵ�ǰʱ��֮��
							 */
							String starttime = session.getSessionStarttime();
							Date date1 = Time.StringToDate(starttime);
							Date date2 = new Date();
							if(Time.compareTo2(date2, date1)) {
								System.out.println(SessionView.sessionToString(session));
							}else {
								continue;
							}
						}
						int sessionNumber=0;
						sessionNumber=HandleInputMismatchException.handleInputMismatchException(sessionNumber);
						if(new SessionDaoImpl().comparisonSessionId(sessionNumber,cinemaName, movieName, cityName)!=-1) {
							int sessionId=sessionNumber;
							c:while(true) {
								System.out.println("��������Ҫѡ�����λ�ţ�������ʾ��ѡ����");
								System.out.println("��λ���\t����\t��λ��\t״̬");
								int hallId = new SessionDaoImpl().querySessionById(sessionId).getSessionHall();
								List<Seat> seats = new SeatDaoImpl().querySeatsByHall(hallId);
								for(Seat seat:seats) {
									System.out.println(SeatView.seatToString(seat));
								}
								int seatNumber=0;
								seatNumber=HandleInputMismatchException.handleInputMismatchException(seatNumber);
								if(new SeatDaoImpl().comparisonSeatId(seatNumber,hallId)!=-1) {
									int fh = SeatView.SeatUpdateStatusById(seatNumber);
									System.out.println(fh);
									if(fh==1) {
										int seatId = seatNumber;
										double moviePrice = new MovieDaoImpl().queryMovieById(movieId).getMoviePrice();
										System.out.println(moviePrice);
										UserView.userDownBalance(moviePrice);
										ticket = new FilmTicket(userId,movieId,sessionId,seatId,0);
									}else {
										continue c;
									}
									break;
								}else {
									System.out.println("���������λ��Ų����ڣ����������룺");
									continue c;
								}
							}
							break;
						}else {
							System.out.println("������ĳ��α�Ų����ڣ����������룺");
							continue b;
						}
					}
					break;
				}else {
					System.out.println("����ǰ���ڳ���û�д˵�ӰԺ������ȷ�Ϻ����������ţ�");
					continue a;
				}
			}
		}else {
			System.out.println("��ѡ��ĵ�Ӱ�����ڣ��������±ȶԺ��������룺");
			FilmTicketBuyPage(userId,cityId);
		}
		return ticket;
	}
	
	public static int FilmTicketRefund() throws Exception {
		int userId = UserView.userNum;
		List<FilmTicket> tickets;
		c:while(true) {
			System.out.println("����������ȫ��������Ϣ����������Ҫ�˶��Ķ�����ţ�");
			tickets = tdi.queryFilmTicketsByUser(userId);
			for(FilmTicket ticket :tickets) {
				/*
				 * �жϳ���ʱ���Ƿ��ڵ�ǰʱ��֮ǰ
				 */
				String starttime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSeesionStoptime();
				Date date1 = Time.StringToDate(starttime);
				Date date2 = new Date();
				if(Time.compareTo2(date1, date2)) {
					continue;
				}else {
					System.out.println(ticketToString1(ticket));
				}
			}
			int ticketId=0;
			ticketId=HandleInputMismatchException.handleInputMismatchException(ticketId);
			if(new FilmTicketDaoImpl().comparisonTicketId(ticketId, userId)!=-1) {
				FilmTicket ticket1 = new FilmTicketDaoImpl().queryFilmTicket(ticketId); 
				System.out.println("����������Ҫ�˶��ĵ�ӰƱ��Ϣ");
				System.out.println(ticketToString(ticket1));
				if(ticket1.getTicketStatus()==0) {
					a:while(true) {
						System.out.println("��ȷ���Ƿ���Ʊ:1����Ʊ��2������");
						int choose=0;
						choose=HandleInputMismatchException.handleInputMismatchException(choose);
						switch(choose) {
						case 1:
							int i = tdi.updateFilmTicketStatus(ticket1.getTicketId());
							if(i>0) {
								System.out.println("��Ʊ�ɹ�");
								double moviePrice = new MovieDaoImpl().queryMovieById(ticket1.getTicketMovie()).getMoviePrice();
								System.out.println(moviePrice);
								UserView.userUpBalance(moviePrice);
								System.out.println("��Ϊ����ת���ϼ��б�");
								UserView.userMeanPage();
							}else {
								System.out.println("��Ʊʧ��");
							}
							break;
						case 2:
							System.out.println("���ѷ�����Ʊ����ע�⿪��ʱ�䣬ף����Ӱ���");
							break;
						default:
							System.out.println("������ı����������������:");
							continue a;
						}
						break;
					}
				}else {
					System.out.println("��ӰƱ�Ѿ��˹�����ѡ������������");
					UserView.userMeanPage();
				}				
			}else {
				System.out.println("������ı���������������룺");
				continue c;
			}
			break;
		}
		return 0;
	}
	public static void FilmTicketSeeAllPage() {
		try {
			List<FilmTicket> tickets;
			tickets = tdi.queryFilmTickets();
			for(FilmTicket ticket :tickets) {
				System.out.println(ticketToString1(ticket));
			}
			System.out.println("��Ϊ����ת���ϼ��б�");
			AdminView.adminOperateFilMTicketPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void FilmTicketSeeMovieAllPage() throws Exception {
		System.out.println("������Ҫ�鿴�ĵ�Ӱ�ı�ţ�");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByMovie(movieId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("��Ϊ����ת���ϼ��б�");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ĵ�Ӱ�����ڣ����֤����������");
			FilmTicketSeeMovieAllPage();
		}
	}
	public static void FilmTicketSeeCinemaAllPage() throws Exception {
		System.out.println("������Ҫ�鿴�ĵ�ӰԺ�ı�ţ�");
		int cinemaId=0;
		cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
		if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByCinema(cinemaId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("��Ϊ����ת���ϼ��б�");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ĵ�ӰԺ��Ų����ڣ����֤������������");
			FilmTicketSeeCinemaAllPage();
		}
	}
	public static void FilmTicketSeeMovieCinemaAllPage() throws Exception {
		System.out.println("������Ҫ�鿴�ĵ�Ӱ�ı�ţ�");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)!=-1) {
			a:while(true) {
				System.out.println("������Ҫ�鿴�ĵ�ӰԺ�ı�ţ�");
				int cinemaId=0;
				cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
				if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)!=-1) {
					try {
						List<FilmTicket> tickets;
						tickets = tdi.queryFilmTicketsByMovieCinema(movieId, cinemaId);
						for(FilmTicket ticket :tickets) {
							System.out.println(ticketToString1(ticket));
						}
						System.out.println("��Ϊ����ת���ϼ��б�");
						AdminView.adminOperateFilMTicketPage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("������ĵ�ӰԺ��Ų����ڣ����֤������������");
					continue a;
				}
				break;
			}			
		}else {
			System.out.println("������ĵ�Ӱ�����ڣ����֤����������");
			FilmTicketSeeMovieCinemaAllPage();
		}
	}
	public static void FilmTicketSeeUserAllPage() throws Exception {
		System.out.println("������Ҫ�鿴���û��ı�ţ�");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByUser(userId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("��Ϊ����ת���ϼ��б�");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("��������û���Ų����ڣ����֤����������");
			FilmTicketSeeUserAllPage();
		}	
	}
	
	public static String ticketToString(FilmTicket ticket) throws Exception{
		String movieName = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMovieName();
		String startTime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionStarttime();
		String stopTime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSeesionStoptime();
		String hallName =new HallDaoImpl().queryHallById(new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionHall()).getHallName();
		int row = new SeatDaoImpl().querySeatById(ticket.getTicketSeat()).getSeatRow();
		int rank = new SeatDaoImpl().querySeatById(ticket.getTicketSeat()).getSeatRank();
		String cinemaName = new CinemaDaoImpl().queryCinemaById(new HallDaoImpl().queryHallById(new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionHall()).getHallCinema()).getCinemaName();
		double price = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMoviePrice();
		int account = new UserDaoImpl().queryUserById(ticket.getTicketUser()).getUserAccount();
		String status = ticket.judgeTicketStatus();
		return movieName+"\n����ʱ�䣺"+startTime+"\n����ʱ�䣺"+stopTime+"\nӰ����"+hallName+
				"\t��"+row+"��"+rank+"��\n��ӰԺ��"+cinemaName+"\n�۸�"+price+"\n�û��˺ţ�"+account+"\n״̬��"+status;
	}
	
	public static String ticketToString1(FilmTicket ticket) throws Exception{
		String movieName = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMovieName();
		String startTime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionStarttime();
		String cinemaName = new CinemaDaoImpl().queryCinemaById(new HallDaoImpl().queryHallById(new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionHall()).getHallCinema()).getCinemaName();
		double price = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMoviePrice();
		int account = new UserDaoImpl().queryUserById(ticket.getTicketUser()).getUserAccount();
		return "���"+ticket.getTicketId()+"\t"+movieName+"\t����ʱ�䣺"+startTime+"\t��ӰԺ��"+cinemaName+"\t�۸�"+price+"\t�û��˺ţ�"+account;
	}
}
