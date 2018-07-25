package contro;

import java.util.List;

import dao.SeasonDao;
import dao.impl.SeasonDaoImpl;
import entity.Season;
import service.SeasonService;
import service.impl.SeasonServiceImpl;
import util.Help;

/**
 * 
 * @param 场次控制层
 * @author zmx2321
 * 
 */


public class SeasonContro {
	static SeasonService seasonService = new SeasonServiceImpl();
	static SeasonDao seasonDao = new SeasonDaoImpl();
	
	//查询所有场次
	public static void querySeason() {
		List<Season> seasonList = seasonDao.querrySeason();
		
		if (seasonList.isEmpty()) {
			System.out.println("暂无场次！");
		}
		
		boolean success = seasonService.querySeason();
		
		if (success) {
			for(Season season : seasonList){
				System.out.println("场次编号：" + season.getSeason_id() + 
					"\n影院名称：" + season.getCinema().getCinema_name() +
					"\n影厅名称：" + season.getHall().getHall_name() +
					"\n电影名称：" + season.getMovie().getMovie_name() +
					"\n电影时长：" + season.getMovie().getMovie_length() +
					"\n支付价格：" + season.getSeason_price() + 
					"\n放映时间：" + season.getSeason_time() + 
					"\n放映地址：" + season.getCinema().getCinema_address() + 
					"\n"
				);
			}
		} else {
			System.out.println("查询失败！\n");
		}
		
		seasonList.clear();
	}
	
	//添加场次
	public static void addSeason(){
		MovieControl.queryMoviesName();
		int movie_id = Help.getInt("请输入电影编号：");
		String season_time = Help.getString("请输入放映时间：");
		float season_price = Help.getFloat("请输入支付价格：");
		HallContro.queryHall();
		int hall_id = Help.getInt("请输入影厅编号：");
		
		Season season = new Season(movie_id, season_time, season_price, hall_id);
		
		boolean success = seasonService.addSeason(season);
		
		if (success) {
			System.out.println("添加成功！\n");
		}
	}
	
	//根据id删除场次信息
	public static void deleteSeason(){
		querySeason();
		
		int season_id = Help.getInt("请输入影厅编号：");
		
		boolean success = seasonService.deleteSeason(season_id);
		
		if(success){
			System.out.println("影院删除成功！\n");
			querySeason();
		}else{
			System.out.println("影院删除失败！\n");
		}
	}
	
	//根据电影编号和影厅编号查询场次编号（场次）
	public static void querySeason(int movie_id, int hall_id) throws Exception {
		boolean success = seasonService.querySeason(movie_id, hall_id);
		
		Season season = seasonDao.querySeason(movie_id, hall_id);
		
		if(success){
			System.out.println("查询成功！\n");
			System.out.println(season + "\n");
		}else{
			System.out.println("查询失败！\n");
		}
	}
	
	//根据场次id查询详细信息
	public static void querrySeason(int season_id){
		List<Season> seasonList = seasonDao.querrySeason(season_id);
		
		if (seasonList.isEmpty()) {
			System.out.println("暂无场次！");
		}
		
		boolean success = seasonService.querrySeason(season_id);
		
		if (success) {
			for(Season season : seasonList){
				System.out.println("场次编号：" + season.getSeason_id() + 
					"\n影院名称：" + season.getCinema().getCinema_name() +
					"\n影厅名称：" + season.getHall().getHall_name() +
					"\n电影名称：" + season.getMovie().getMovie_name() +
					"\n电影时长：" + season.getMovie().getMovie_length() +
					"\n支付价格：" + season.getSeason_price() + 
					"\n放映时间：" + season.getSeason_time() + 
					"\n放映地址：" + season.getCinema().getCinema_address() + 
					"\n"
				);
			}
		} else {
			System.out.println("查询失败！\n");
		}
		
		seasonList.clear();
	}

	
	//test
	public static void main(String[] args) throws Exception {
		//查询所有场次
		//querySeason();
		
		//添加场次
		addSeason();
		
		//删除场次
		//deleteSeason();
		
		//根据电影编号和影厅编号查询场次编号（场次）
		//querySeason(2, 5);
		
		//根据场次id查询详细信息
		//querrySeason(1);
	}
}
