package contro;

import java.util.List;

import dao.CinemaDao;
import dao.impl.CinemaDaoImpl;
import entity.Cinema;
import service.CinemaService;
import service.impl.CinemaServiceImpl;
import util.Help;

/**
 * 
 * @param 影院控制层
 * @author zmx2321
 * 
 */

public class CinemaContro {
	static CinemaService cinemaService = new CinemaServiceImpl();
	static CinemaDao cinemaDao = new CinemaDaoImpl();
	
	//查询所有影院
	public static void queryCinema() {
		List<Cinema> cinemaList = cinemaDao.querryCinema();
		
		if (cinemaList.isEmpty()) {
			System.out.println("暂无影院！\n");
			return;
		}
		
		boolean success = cinemaService.querryCinema(cinemaList);
		
		if (success) {
			for(Cinema cinema : cinemaList){
				System.out.println(cinema + "\n");
			}
			System.out.println();
		}else {
			System.out.println("查询失败！\n");
		}
		
		cinemaList.clear();
	}
	
	//添加影院
	public static void addCinema(){
		String cinema_name = Help.getString("请输入影院名称：");
		String cinema_address = Help.getString("请输入影院地址：");
		String cinema_city = Help.getString("请输入影院城市：");
		
		Cinema cinema = new Cinema(cinema_name, cinema_address, cinema_city);
		
		boolean success = cinemaService.addCinema(cinema);
		
		if (success) {
			System.out.println("添加成功！\n");
		} else {
			System.out.println("添加失败！\n");
		}
	}
	
	//根据影院id删除影院信息
	public static void deleteCinema(){
		queryCinemaName();
		
		int cinema_id = Help.getInt("请输入您要删除的影院编号：");
		
		boolean success = cinemaService.deleteCinema(cinema_id);
		
		if(success){
			System.out.println("影院删除成功！\n");
			queryCinemaName();
		}else{
			System.out.println("影院删除失败！\n");
		}
	}
	
	//查询影院名和id
	public static void queryCinemaName(){
		List<Cinema> cinemaList = cinemaDao.querryCinema();
		
		if (cinemaList.isEmpty()) {
			System.out.println("暂无影院！\n");
			return;
		}
		
		boolean success = cinemaService.querryCinema(cinemaList);
		
		if (success) {
			for(Cinema cinema : cinemaList){
				System.out.println(cinema.getCinema_id() + "、" + cinema.getCinema_name());
			}
			System.out.println();
		}else {
			System.out.println("查询失败！\n");
		}
		
		cinemaList.clear();
	}
	
	//test
	public static void main(String[] args) {
		//添加影院
		//addCinema();
		
		//查询所有影院
		queryCinema();
		
		//删除影院
		//deleteCinema();
		
		//查询影院名和id
		//queryCinemaName();
	}
}
