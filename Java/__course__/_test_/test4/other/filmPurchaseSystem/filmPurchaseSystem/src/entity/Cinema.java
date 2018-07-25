package entity;
/**
 * 电影院实体类
 * @author Administrator
 *
 */
public class Cinema {
	private int cinemaId;
	private String cinemaName;
	private int cinemaCity;
	public Cinema() {
		super();
	}
	public Cinema(String cinemaName, int cinemaCity) {
		super();
		this.cinemaName = cinemaName;
		this.cinemaCity = cinemaCity;
	}
	public int getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getCinemaCity() {
		return cinemaCity;
	}
	public void setCinemaCity(int cinemaCity) {
		this.cinemaCity = cinemaCity;
	}
}
