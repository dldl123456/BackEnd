package entity;
/**
 * 影厅实体类
 * @author Administrator
 *
 */
public class Hall {
	private int hallId;
	private String hallName;
	private int hallCinema;
	public Hall() {
		super();
	}
	public Hall(String hallName, int hallCinema) {
		super();
		this.hallName = hallName;
		this.hallCinema = hallCinema;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public int getHallCinema() {
		return hallCinema;
	}
	public void setHallCinema(int hallCinema) {
		this.hallCinema = hallCinema;
	}
	@Override
	public String toString() {
		return "Hall [hallId=" + hallId + ", hallName=" + hallName + ", hallCinema=" + hallCinema + "]";
	}
	
	
}
