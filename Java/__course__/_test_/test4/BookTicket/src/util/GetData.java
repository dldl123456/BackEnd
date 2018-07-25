package util;

/**
 * ����ʱ�乤��
 * yyyy-MM-dd HH:mm yyyy��MM��dd�� HHʱmm��
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
	//ʱ���ʽ1
	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	//ʱ���ʽ2
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//��ȡ��ǰϵͳʱ��
	public static String getNow(){
		Date date = new Date();
		String str = sdf2.format(date);
		return str;
	}
	
	//ʱ���ʽ(String ==> Date ==> String)
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
	
	//ʱ���ʽ(Timestamp ==> String)
	public static String dateFormat(Timestamp time) {
	    String str = sdf1.format(time);
	    return str;
	}
	
	public static void main(String[] args) {
		//��ȡ��ǰϵͳʱ��
		System.out.println(getNow());
		
		//ʱ���ʽ(Timestamp ==> String)
		EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
		List<Evaluate> evaluateList = evaluateDao.querryEvaluate();
		
		for(Evaluate evaluate : evaluateList){
			System.out.println(evaluate.getEvaluate_time());
		}
		
		//ʱ���ʽ(datetime ==> date ==> String)
		SeasonDao seasonDao = new SeasonDaoImpl();
		
		List<Season> seasonList = seasonDao.querrySeason();
		for(Season season : seasonList){
			System.out.println(season.getSeason_time());
		}
	}
}
