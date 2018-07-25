package entity;
/**
 * 场次实体类
 * @author Administrator
 *
 */
public class Session {
	private int sessionId;
	private int sessionHall;
	private String sessionStarttime;
	private String sessionStoptime;
	private int sessionMovie;
	public Session() {
		super();
	}
	public Session(int sessionHall, String sessionStarttime,
			String seesionStoptime, int sessionMovie) {
		super();
		this.sessionHall = sessionHall;
		this.sessionStarttime = sessionStarttime;
		this.sessionStoptime = seesionStoptime;
		this.sessionMovie = sessionMovie;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public int getSessionHall() {
		return sessionHall;
	}
	public void setSessionHall(int sessionHall) {
		this.sessionHall = sessionHall;
	}
	public String getSessionStarttime() {
		return sessionStarttime;
	}
	public void setSessionStarttime(String sessionStarttime) {
		this.sessionStarttime = sessionStarttime;
	}
	public String getSeesionStoptime() {
		return sessionStoptime;
	}
	public void setSeesionStoptime(String seesionStoptime) {
		this.sessionStoptime = seesionStoptime;
	}
	public int getSessionMovie() {
		return sessionMovie;
	}
	public void setSessionMovie(int sessionMovie) {
		this.sessionMovie = sessionMovie;
	}
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId +  ", sessionHall=" + sessionHall
				 + ", sessionStarttime=" + sessionStarttime + ", seesionStoptime="
				+ sessionStoptime + ", sessionMovie=" + sessionMovie + "]";
	}
	
}
