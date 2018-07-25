package util;

/**
 * 日期时间工具
 * yyyy-MM-dd HH:mm yyyy年MM月dd日 HH时mm分
 */

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.SeasonDao;
import dao.impl.EvaluateDaoImpl;
import dao.impl.SeasonDaoImpl;
import entity.Evaluate;
import entity.Season;

public class GetData {
	//时间格式1
	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	//时间格式2
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//获取当前系统时间
	public static String getNow(){
		Date date = new Date();
		String str = sdf2.format(date);
		return str;
	}
	
	//时间格式(String ==> Date ==> String)
	public static String dateFormat(String strtime) {
		try {
			Date date = sdf2.parse(strtime);
			String str = sdf2.format(date);
			
			return str;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//时间格式(Timestamp ==> String)
	public static String dateFormat(Timestamp time) {
	    String str = sdf1.format(time);
	    return str;
	}
	
	public static void main(String[] args) {
		//获取当前系统时间
		System.out.println(getNow());
		
		//时间格式(Timestamp ==> String)
		EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
		List<Evaluate> evaluateList = evaluateDao.querryEvaluate();
		
		for(Evaluate evaluate : evaluateList){
			System.out.println(evaluate.getEvaluate_time());
		}
		
		//时间格式(datetime ==> date ==> String)
		SeasonDao seasonDao = new SeasonDaoImpl();
		
		List<Season> seasonList = seasonDao.querrySeason();
		for(Season season : seasonList){
			System.out.println(season.getSeason_time());
		}
	}
}
