package service.impl;

import java.util.List;

import dao.CinemaDao;
import dao.impl.CinemaDaoImpl;
import entity.Cinema;
import service.CinemaService;

/**
 * 
 * @param 实现影院服务接口
 * @author zmx2321
 * 
 */

public class CinemaServiceImpl implements CinemaService {
	private static List<Cinema> cinemalist = null;
	private int code = 0;  //sql执行状态
	
	private CinemaDao cinemaDao;
	
	public CinemaServiceImpl() {
		cinemaDao = new CinemaDaoImpl();
	}
	
	//查询所有影院
	@Override
	public boolean querryCinema(List<Cinema> cinemalist) {
		cinemalist = cinemaDao.querryCinema();
		
		return cinemalist == null ? false : true;
	}
	
	//添加影院
	@Override
	public boolean addCinema(Cinema cinema) {
		code = cinemaDao.addCinema(cinema);
		
		return code == 0 ? false : true;
	}
	
	//删除电影
	@Override
	public boolean deleteCinema(int cinema_id) {
		code = cinemaDao.deleteCinema(cinema_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		CinemaServiceImpl csi = new CinemaServiceImpl();
		Cinema cinema = new Cinema("杭州百美汇影城", "下城区延安路385号杭州嘉里中心3号楼4楼", "杭州市");
		
		//查询所有评论
		System.out.println(csi.querryCinema(cinemalist));
		
		//添加影院
		System.out.println(csi.addCinema(cinema));
		
		//删除影院
		System.out.println(csi.deleteCinema(1));
	}
}
