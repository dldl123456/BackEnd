package entity;
/**
 * 电影票实体类
 * @author Administrator
 *
 */
public class FilmTicket {
	private int ticketId;
	private int ticketUser;
	private int ticketMovie;
	private int ticketSession;
	private int ticketSeat;
	private int ticketStatus;
	
	public FilmTicket() {
		super();
	}
	public FilmTicket(int ticketUser, int ticketMovie, 
			int ticketSession, int ticketSeat,int ticketStatus) {
		super();
		this.ticketUser = ticketUser;
		this.ticketMovie = ticketMovie;
		this.ticketSession = ticketSession;
		this.ticketSeat = ticketSeat;
		this.ticketStatus=ticketStatus;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getTicketUser() {
		return ticketUser;
	}
	public void setTicketUser(int ticketUser) {
		this.ticketUser = ticketUser;
	}
	public int getTicketMovie() {
		return ticketMovie;
	}
	public void setTicketMovie(int ticketMovie) {
		this.ticketMovie = ticketMovie;
	}
	public int getTicketSession() {
		return ticketSession;
	}
	public void setTicketSession(int ticketSession) {
		this.ticketSession = ticketSession;
	}
	public int getTicketSeat() {
		return ticketSeat;
	}
	public void setTicketSeat(int ticketSeat) {
		this.ticketSeat = ticketSeat;
	}
	public int getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	/**
	 * 判断状态
	 * @return
	 */
	public String judgeTicketStatus() {
		if(getTicketStatus()==0) {
			return "售出";
		}else {
			return "退单";
		}	
	}
}
