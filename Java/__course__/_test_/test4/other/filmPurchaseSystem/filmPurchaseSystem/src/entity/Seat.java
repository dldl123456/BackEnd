package entity;
/**
 * 座位实体类
 * @author Administrator
 *
 */
public class Seat {
	private int seatId;
	private int seatRow;
	private int seatRank;
	private int seatHall;
	private int seatStatus;
	public Seat() {
		super();
	}
	public Seat(int seatRow, int seatRank, int seatHall) {
		super();
		this.seatRow = seatRow;
		this.seatRank = seatRank;
		this.seatHall = seatHall;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatRank() {
		return seatRank;
	}
	public void setSeatRank(int seatRank) {
		this.seatRank = seatRank;
	}
	public int getSeatHall() {
		return seatHall;
	}
	public void setSeatHall(int seatHall) {
		this.seatHall = seatHall;
	}
	public int getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(int seatStatus) {
		this.seatStatus = seatStatus;
	}
	/**
	 * 判断状态
	 * @return
	 */
	public String judgeSeatStatus() {
		if(getSeatStatus()==0) {
			return "空座";
		}else {
			return "售出";
		}	
	}
}
