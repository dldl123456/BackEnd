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
		System.out.println("������Ҫ��ӵ���λӰ����ţ�");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("�������Ӱ����Ų����ڣ�����������");
			SeatAddPage();
		}
		System.out.println("������Ҫ��ӵ���һ�У�");
		int row=0;
		row=HandleInputMismatchException.handleInputMismatchException(row);
		System.out.println("������Ҫ��ӵ���һ�У�");
		int rank=0;
		rank=HandleInputMismatchException.handleInputMismatchException(rank);
		seat = new Seat(row,rank,hallId);
		return seat;
	}
	public static int SeatDeleteByIdPage() throws Exception {
		System.out.println("������Ҫɾ������λ��ţ�");
		int seatId=0;
		seatId=HandleInputMismatchException.handleInputMismatchException(seatId);
		if(new SeatDaoImpl().comparisonSeatId(seatId)==-1) {
			System.out.println("������ı�Ų����ڣ�����������");
			SeatDeleteByIdPage();
		}
		return seatId;
	}
	public static int SeatDeleteByRowPage() throws Exception {
		System.out.println("������Ҫɾ������λ���ڵ����ı�ţ�");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("�������Ӱ����Ų����ڣ�����������");
			SeatDeleteByRowPage();
		}
		System.out.println("������Ҫɾ�����б�ţ�");
		int row=0;
		row=HandleInputMismatchException.handleInputMismatchException(row);
		int i=0;
		try {
			i = sdi.deleteSeatByRow(row, hallId);
			if(i>0) {
				System.out.println("ɾ���ɹ�������");
				System.out.println("��ѡ������������");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("ɾ��ʧ�ܣ�����");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int SeatDeleteByRankPage() throws Exception {
		System.out.println("������Ҫɾ������λ���ڵ����ı�ţ�");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("�������Ӱ����Ų����ڣ�����������");
			SeatDeleteByRankPage();
		}
		System.out.println("������Ҫɾ�����б�ţ�");
		int rank=0;
		rank=HandleInputMismatchException.handleInputMismatchException(rank);
		int i = 0;
		try {
			i = sdi.deleteSeatByRow(rank, hallId);
			if(i>0) {
				System.out.println("ɾ���ɹ�������");
				System.out.println("��ѡ������������");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("ɾ��ʧ�ܣ�����");
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
					System.out.println("��Ʊ�ɹ������ĵ�ӰƱ��Ϣ���£�");
					return 1;
				}else {
					System.out.println("�޸�ʧ��");
				}
			}else {
				System.out.println("��ǰ��λ�Ѿ���������ѡ��������λ");
				return 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void SeatUpdateStatusByHall() throws Exception {
		System.out.println("������Ҫ�޸ĵ�Ӱ����ţ�");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("�������Ӱ����Ų����ڣ�����������");
			SeatUpdateStatusByHall();
		}
		try {
			int i=sdi.updateSeatStatusByHall(hallId, 1);
			if(i>0) {
				System.out.println("�޸ĳɹ�");
				System.out.println("��ѡ������������");
				AdminView.adminOperateSeatPage();
			}else {
				System.out.println("�޸�ʧ��");
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
			System.out.println("��ѡ������������");
			AdminView.adminOperateSeatPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void SeatSeeHallAllPage() throws Exception {
		System.out.println("������Ҫ�鿴�����ı�ţ�");
		int hallId=0;
		hallId=HandleInputMismatchException.handleInputMismatchException(hallId);
		if(new HallDaoImpl().comparisonHallId(hallId)==-1) {
			System.out.println("�������Ӱ����Ų����ڣ�����������");
			SeatSeeHallAllPage();
		}
		try {
			List<Seat> seats;
			seats = sdi.querySeatsByHall(hallId);
			for(Seat seat :seats) {
				System.out.println(seatToString(seat));
			}
			System.out.println("��ѡ������������");
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
		return seat.getSeatId()+"\t"+hallName+"\t"+"��"+seat.getSeatRow()+"��"+seat.getSeatRank()+"��"+"\t"+seat.judgeSeatStatus();
	}
}