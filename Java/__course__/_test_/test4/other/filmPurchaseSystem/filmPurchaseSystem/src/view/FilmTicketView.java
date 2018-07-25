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
	 * 直接买票
	 * @return
	 * @throws Exception 
	 */
	public static FilmTicket FilmTicketBuyPage(int userId,int cityId) throws Exception {
		System.out.println("请输入要选择的电影编号：");
		System.out.println("电影编号\t电影名称");
		List<Movie> movies=new MovieDaoImpl().queryMovies();
		for(Movie movie:movies) {
			System.out.println(MovieView.movieToString2(movie));
		}
		int movieNumber=0;
		movieNumber=HandleInputMismatchException.handleInputMismatchException(movieNumber);
		if(new MovieDaoImpl().comparisonMovieId(movieNumber)!=-1) {
			int movieId=movieNumber;
			a:while(true) {
				System.out.println("请输入要选择的影院编号：");
				System.out.println("电影院编号\t电影院名称");
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
						System.out.println("非常抱歉，您选中的电影院还没有相关电影的场次，请重新选择影院：");
						continue a;
					}
					b:while(true) {						
						System.out.println("请输入您要选择的场次编号：");
						System.out.println("场次编号\t影厅名称\t播放电影\t开场时间\t结束时间：");
						for(Session session:sessions) {
							/*
							 * 判断场次时间是否在当前时间之后
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
								System.out.println("请输入您要选择的座位号（空座表示可选）：");
								System.out.println("座位编号\t厅名\t座位号\t状态");
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
									System.out.println("您输入的座位编号不存在，请重新输入：");
									continue c;
								}
							}
							break;
						}else {
							System.out.println("您输入的场次编号不存在，请重新输入：");
							continue b;
						}
					}
					break;
				}else {
					System.out.println("您当前所在城市没有此电影院，请您确认后重新输入编号：");
					continue a;
				}
			}
		}else {
			System.out.println("您选择的电影不存在，请您重新比对后重新输入：");
			FilmTicketBuyPage(userId,cityId);
		}
		return ticket;
	}
	
	public static int FilmTicketRefund() throws Exception {
		int userId = UserView.userNum;
		List<FilmTicket> tickets;
		c:while(true) {
			System.out.println("下面是您的全部订单信息，请输入您要退订的订单编号：");
			tickets = tdi.queryFilmTicketsByUser(userId);
			for(FilmTicket ticket :tickets) {
				/*
				 * 判断场次时间是否在当前时间之前
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
				System.out.println("以下是您想要退订的电影票信息");
				System.out.println(ticketToString(ticket1));
				if(ticket1.getTicketStatus()==0) {
					a:while(true) {
						System.out.println("请确认是否退票:1、退票，2、放弃");
						int choose=0;
						choose=HandleInputMismatchException.handleInputMismatchException(choose);
						switch(choose) {
						case 1:
							int i = tdi.updateFilmTicketStatus(ticket1.getTicketId());
							if(i>0) {
								System.out.println("退票成功");
								double moviePrice = new MovieDaoImpl().queryMovieById(ticket1.getTicketMovie()).getMoviePrice();
								System.out.println(moviePrice);
								UserView.userUpBalance(moviePrice);
								System.out.println("已为您跳转到上级列表：");
								UserView.userMeanPage();
							}else {
								System.out.println("退票失败");
							}
							break;
						case 2:
							System.out.println("您已放弃退票，请注意开场时间，祝您观影愉快");
							break;
						default:
							System.out.println("您输入的编号有误，请重新输入:");
							continue a;
						}
						break;
					}
				}else {
					System.out.println("该影票已经退过，请选择其他操作：");
					UserView.userMeanPage();
				}				
			}else {
				System.out.println("您输入的编号有误，请重新输入：");
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
			System.out.println("已为您跳转到上级列表：");
			AdminView.adminOperateFilMTicketPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void FilmTicketSeeMovieAllPage() throws Exception {
		System.out.println("请输入要查看的电影的编号：");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByMovie(movieId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("已为您跳转到上级列表：");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("您输入的电影不存在，请查证后重新输入");
			FilmTicketSeeMovieAllPage();
		}
	}
	public static void FilmTicketSeeCinemaAllPage() throws Exception {
		System.out.println("请输入要查看的电影院的编号：");
		int cinemaId=0;
		cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
		if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByCinema(cinemaId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("已为您跳转到上级列表：");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("您输入的电影院编号不存在，请查证后再重新输入");
			FilmTicketSeeCinemaAllPage();
		}
	}
	public static void FilmTicketSeeMovieCinemaAllPage() throws Exception {
		System.out.println("请输入要查看的电影的编号：");
		int movieId=0;
		movieId=HandleInputMismatchException.handleInputMismatchException(movieId);
		if(new MovieDaoImpl().comparisonMovieId(movieId)!=-1) {
			a:while(true) {
				System.out.println("请输入要查看的电影院的编号：");
				int cinemaId=0;
				cinemaId=HandleInputMismatchException.handleInputMismatchException(cinemaId);
				if(new CinemaDaoImpl().comparisonCinemaId(cinemaId)!=-1) {
					try {
						List<FilmTicket> tickets;
						tickets = tdi.queryFilmTicketsByMovieCinema(movieId, cinemaId);
						for(FilmTicket ticket :tickets) {
							System.out.println(ticketToString1(ticket));
						}
						System.out.println("已为您跳转到上级列表：");
						AdminView.adminOperateFilMTicketPage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("您输入的电影院编号不存在，请查证后再重新输入");
					continue a;
				}
				break;
			}			
		}else {
			System.out.println("您输入的电影不存在，请查证后重新输入");
			FilmTicketSeeMovieCinemaAllPage();
		}
	}
	public static void FilmTicketSeeUserAllPage() throws Exception {
		System.out.println("请输入要查看的用户的编号：");
		int userId=0;
		userId=HandleInputMismatchException.handleInputMismatchException(userId);
		if(new UserDaoImpl().comparisonUserId(userId)!=-1) {
			try {
				List<FilmTicket> tickets;
				tickets = tdi.queryFilmTicketsByUser(userId);
				for(FilmTicket ticket :tickets) {
					System.out.println(ticketToString1(ticket));
				}
				System.out.println("已为您跳转到上级列表：");
				AdminView.adminOperateFilMTicketPage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("您输入的用户编号不存在，请查证后重新输入");
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
		return movieName+"\n开场时间："+startTime+"\n结束时间："+stopTime+"\n影厅："+hallName+
				"\t第"+row+"排"+rank+"座\n电影院："+cinemaName+"\n价格："+price+"\n用户账号："+account+"\n状态："+status;
	}
	
	public static String ticketToString1(FilmTicket ticket) throws Exception{
		String movieName = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMovieName();
		String startTime = new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionStarttime();
		String cinemaName = new CinemaDaoImpl().queryCinemaById(new HallDaoImpl().queryHallById(new SessionDaoImpl().querySessionById(ticket.getTicketSession()).getSessionHall()).getHallCinema()).getCinemaName();
		double price = new MovieDaoImpl().queryMovieById(ticket.getTicketMovie()).getMoviePrice();
		int account = new UserDaoImpl().queryUserById(ticket.getTicketUser()).getUserAccount();
		return "编号"+ticket.getTicketId()+"\t"+movieName+"\t开场时间："+startTime+"\t电影院："+cinemaName+"\t价格："+price+"\t用户账号："+account;
	}
}
