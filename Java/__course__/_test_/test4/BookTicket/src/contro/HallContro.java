package contro;

import java.util.List;

import dao.HallDao;
import dao.impl.HallDaoImpl;
import entity.Hall;
import service.HallService;
import service.impl.HallServiceImpl;
import util.Help;

/**
 * 
 * @param 影厅控制层
 * @author zmx2321
 * 
 */

public class HallContro {
	static HallService hallService = new HallServiceImpl();
	static HallDao hallDao = new HallDaoImpl();
	
	//查询所有影厅
	public static void queryHall() {
		List<Hall> hallList = hallDao.querryHall();
		
		if (hallList.isEmpty()) {
			System.out.println("暂无影厅！");
		}
		
		boolean success = hallService.querryHall(hallList);
		
		if (success) {
			for(Hall hall : hallList){
				System.out.println("影厅编号：" + hall.getHall_id() + 
					"\n影厅名称：" + hall.getHall_name() + 
					"\n影院名称：" + hall.getCinema().getCinema_name() +
					"\n"
				);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		hallList.clear();
	}
	
	//添加影厅
	public static void addHall(){
		String hall_name = Help.getString("请输入影厅名称：");
		System.out.println();
		
		CinemaContro.queryCinemaName();
		int cinema_id = Help.getInt("请输入影院编号：");
		
		Hall hall = new Hall(hall_name, cinema_id);
		
		boolean success = hallService.addHall(hall);
		
		if (success) {
			System.out.println("添加成功！\n");
		} else {
			System.out.println("添加失败！\n");
		}
	}
	
	//根据影院id删除影厅信息
	public static void deleteHall(){
		queryHall();
		
		int hall_id = Help.getInt("请输入您要删除的影厅编号：");
		
		boolean success = hallService.deleteHall(hall_id);
		
		if(success){
			System.out.println("影院删除成功！\n");
			queryHall();
		}else{
			System.out.println("影院删除失败！\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//查询所有影厅
		//queryHall();
		
		//添加影厅
		//addHall();
		
		//删除影厅
		//deleteHall();
	}
}
