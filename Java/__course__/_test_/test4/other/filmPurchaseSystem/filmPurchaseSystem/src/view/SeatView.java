package view;

import java.util.List;

import dao.SeatDao;
import dao.impl.HallDaoImpl;
import dao.impl.SeatDaoImpl;
import entity.Seat;
import help.HandleInputMismatchException;

public class SeatView {
	static Seat seat = new Seat();
	static SeatDao sdi = new SeatDaoImpl();
	
	public static Seat SeatAddPage() throws Exception {
		System.out.println("请输入要添加的座位影厅编号：");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("您输入的影厅编号不存在，请重新输入");
			SeatAddPage();
		}
		System.out.println("请输入要添加到哪一行：");
		int row=0;
		row=HandleInputMismatchException.handleInputMismatchException(row);
		System.out.println("请输入要添加到哪一列：");
		int rank=0;
		rank=HandleInputMismatchException.handleInputMismatchException(rank);
		seat = new Seat(row,rank,hallId);
		return seat;
	}
	public static int SeatDeleteByIdPage() throws Exception {
		System.out.println("请输入要删除的座位编号：");
		int seatId=0;
		seatId=HandleInputMismatchException.handleInputMismatchException(seatId);
		if(new SeatDaoImpl().comparisonSeatId(seatId)==-1) {
			System.out.println("您输入的编号不存在，请重新输入");
			SeatDeleteByIdPage();
		}
		return seatId;
	}
	public static int SeatDeleteByRowPage() throws Exception {
		System.out.println("请输入要删除的座位所在的厅的编号：");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("您输入的影厅编号不存在，请重新输入");
			SeatDeleteByRowPage();
		}
		System.out.println("请输入要删除的行编号：");
		int row=0;
		row=HandleInputMismatchException.handleInputMismatchException(row);
		int i=0;
		try {
			i = sdi.deleteSeatByRow(row, hallId);
			if(i>0) {
				System.out.println("删除成功！！！");
				System.out.println("请选择其他操作：");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("删除失败！！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int SeatDeleteByRankPage() throws Exception {
		System.out.println("请输入要删除的座位所在的厅的编号：");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("您输入的影厅编号不存在，请重新输入");
			SeatDeleteByRankPage();
		}
		System.out.println("请输入要删除的列编号：");
		int rank=0;
		rank=HandleInputMismatchException.handleInputMismatchException(rank);
		int i = 0;
		try {
			i = sdi.deleteSeatByRow(rank, hallId);
			if(i>0) {
				System.out.println("删除成功！！！");
				System.out.println("请选择其他操作：");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("删除失败！！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int SeatUpdateStatusById(int seatId) {
		try {
			int number = sdi.querySeatById(seatId).getSeatStatus();
			if(number==0) {
				int i=sdi.updateSeatStatusById(seatId, 1);
				if(i>0) {
					System.out.println("购票成功，您的电影票信息如下：");
					return 1;
				}else {
					System.out.println("修改失败");
				}
			}else {
				System.out.println("当前座位已经被购买，请选择其他座位");
				return 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void SeatUpdateStatusByHall() throws Exception {
		System.out.println("请输入要修改的影厅编号：");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("您输入的影厅编号不存在，请重新输入");
			SeatUpdateStatusByHall();
		}
		try {
			int i=sdi.updateSeatStatusByHall(hallId, 1);
			if(i>0) {
				System.out.println("修改成功");
				System.out.println("请选择其他操作：");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SeatSeeAllPage() {
		try {
			List<Seat> seats;
			seats = sdi.querySeats();
			for(Seat seat :seats) {
				System.out.println(seatToString(seat));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateSeatPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void SeatSeeHallAllPage() throws Exception {
		System.out.println("请输入要查看的厅的编号：");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("您输入的影厅编号不存在，请重新输入");
			SeatSeeHallAllPage();
		}
		try {
			List<Seat> seats;
			seats = sdi.querySeatsByHall(hallId);
			for(Seat seat :seats) {
				System.out.println(seatToString(seat));
			}
			System.out.println("请选择其他操作：");
			AdminView.adminOperateSeatPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String seatToString(Seat seat) {
		String hallName=null;
		try {
			hallName = new HallDaoImpl().queryHallById(seat.getSeatHall()).getHallName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seat.getSeatId()+"\t"+hallName+"\t"+"第"+seat.getSeatRow()+"排"+seat.getSeatRank()+"号"+"\t"+seat.judgeSeatStatus();
	}
}