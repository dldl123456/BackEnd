package entity;

/**
 * 
 * @param 影票类
 * @author zmx2321
 *
 */

public class Ticket {
	private int ticket_id = 0;  //影票id
	private int season_id = 0;  //场次id
	private int ticket_seat_id = 0;  //选座位id
	private int user_id = 0;  //用户id
	
	//obj
	Cinema cinema;
	Hall hall;
	Season season;
	Movie movie;
	User user;
	
	/**
	 * @return the cinema
	 */
	public Cinema getCinema() {
		return cinema;
	}

	/**
	 * @param cinema the cinema to set
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	/**
	 * @return the hall
	 */
	public Hall getHall() {
		return hall;
	}
	
	/**
	 * @param hall the hall to set
	 */
	public void setHall(Hall hall) {
		this.hall = hall;
	}

	/**
	 * @return the season
	 */
	public Season getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}
	
	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	//影票信息1
	public Ticket() {}

	//影票信息2
	public Ticket(int ticket_id, int season_id, int ticket_seat_id, int user_id) {
		super();
		this.ticket_id = ticket_id;
		this.season_id = season_id;
		this.ticket_seat_id = ticket_seat_id;
		this.user_id = user_id;
	}

	//影票信息3
	public Ticket(int season_id, int ticket_seat_id, int user_id) {
		super();
		this.season_id = season_id;
		this.ticket_seat_id = ticket_seat_id;
		this.user_id = user_id;
	}

	/**
	 * @return the ticket_id
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * @return the season_id
	 */
	public int getSeason_id() {
		return season_id;
	}

	/**
	 * @param season_id the season_id to set
	 */
	public void setSeason_id(int season_id) {
		this.season_id = season_id;
	}

	/**
	 * @return the ticket_seat_id
	 */
	public int getTicket_seat_id() {
		return ticket_seat_id;
	}

	/**
	 * @param ticket_seat_id the ticket_seat_id to set
	 */
	public void setTicket_seat_id(int ticket_seat_id) {
		this.ticket_seat_id = ticket_seat_id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", season_id=" + season_id + ", ticket_seat_id=" + ticket_seat_id
				+ ", user_id=" + user_id + "]";
	}
	
	//test
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		String result = ticket.toString();
		System.out.println(result);
	}
}
