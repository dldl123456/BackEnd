package help;

import java.sql.SQLException;

import dbutil.DbADUClose;

public class Help extends DbADUClose{
	/**
	 * 添加数据的循环方法
	 */
	public void addShuju() {
		int seatCinema=1;
		int seatCity=1;		
		for(int seatHall=1;seatHall<=1155;seatHall++) {//厅1155
			if(seatHall%7==0) {
				for(int seatRow=1;seatRow<=10;seatRow++) {//行
					for(int seatRank=1;seatRank<=10;seatRank++) {//列
						String sql="insert into seat(seat_row,seat_rank,seat_hall,seat_cinema,seat_city) values"
								+ "("+seatRow+","+seatRank+","+seatHall+","+seatCinema+","+seatCity+")";
						try {
							ps=getConnection().prepareStatement(sql);
							ps.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							closeAll();
						}
					}
				}
				seatCinema+=1;
				if(seatCity<15) {
					seatCity+=1;
				}else {
					seatCity=1;
				}
			} else if(seatHall%7==6) {
				for(int seatRow=1;seatRow<=5;seatRow++) {//行
					for(int seatRank=1;seatRank<=5;seatRank++) {//列
						String sql="insert into seat(seat_row,seat_rank,seat_hall,seat_cinema,seat_city) values"
								+ "("+seatRow+","+seatRank+","+seatHall+","+seatCinema+","+seatCity+")";
						try {
							ps=getConnection().prepareStatement(sql);
							ps.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							closeAll();
						}
					}
				}
			}else {
				for(int seatRow=1;seatRow<=8;seatRow++) {//行
					for(int seatRank=1;seatRank<=8;seatRank++) {//列
						String sql="insert into seat(seat_row,seat_rank,seat_hall,seat_cinema,seat_city) values"
								+ "("+seatRow+","+seatRank+","+seatHall+","+seatCinema+","+seatCity+")";
						try {
							ps=getConnection().prepareStatement(sql);
							ps.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							closeAll();
						}
					}
				}
			}
			System.out.println("添加成功"+seatHall);
		}
	}
}
