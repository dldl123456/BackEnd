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
 * @param ���ο��Ʋ�
 * @author zmx2321
 * 
 */


public class SeasonContro {
	static SeasonService seasonService = new SeasonServiceImpl();
	static SeasonDao seasonDao = new SeasonDaoImpl();
	
	//��ѯ���г���
	public static void querySeason() {
		List<Season> seasonList = seasonDao.querrySeason();
		
		if (seasonList.isEmpty()) {
			System.out.println("���޳��Σ�");
		}
		
		boolean success = seasonService.querySeason();
		
		if (success) {
			for(Season season : seasonList){
				System.out.println("���α�ţ�" + season.getSeason_id() + 
					"\nӰԺ���ƣ�" + season.getCinema().getCinema_name() +
					"\nӰ�����ƣ�" + season.getHall().getHall_name() +
					"\n��Ӱ���ƣ�" + season.getMovie().getMovie_name() +
					"\n��Ӱʱ����" + season.getMovie().getMovie_length() +
					"\n֧���۸�" + season.getSeason_price() + 
					"\n��ӳʱ�䣺" + season.getSeason_time() + 
					"\n��ӳ��ַ��" + season.getCinema().getCinema_address() + 
					"\n"
				);
			}
		} else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		seasonList.clear();
	}
	
	//��ӳ���
	public static void addSeason(){
		MovieControl.queryMoviesName();
		int movie_id = Help.getInt("�������Ӱ��ţ�");
		String season_time = Help.getString("�������ӳʱ�䣺");
		float season_price = Help.getFloat("������֧���۸�");
		HallContro.queryHall();
		int hall_id = Help.getInt("������Ӱ����ţ�");
		
		Season season = new Season(movie_id, season_time, season_price, hall_id);
		
		boolean success = seasonService.addSeason(season);
		
		if (success) {
			System.out.println("��ӳɹ���\n");
		}
	}
	
	//����idɾ��������Ϣ
	public static void deleteSeason(){
		querySeason();
		
		int season_id = Help.getInt("������Ӱ����ţ�");
		
		boolean success = seasonService.deleteSeason(season_id);
		
		if(success){
			System.out.println("ӰԺɾ���ɹ���\n");
			querySeason();
		}else{
			System.out.println("ӰԺɾ��ʧ�ܣ�\n");
		}
	}
	
	//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
	public static void querySeason(int movie_id, int hall_id) throws Exception {
		boolean success = seasonService.querySeason(movie_id, hall_id);
		
		Season season = seasonDao.querySeason(movie_id, hall_id);
		
		if(success){
			System.out.println("��ѯ�ɹ���\n");
			System.out.println(season + "\n");
		}else{
			System.out.println("��ѯʧ�ܣ�\n");
		}
	}
	
	//���ݳ���id��ѯ��ϸ��Ϣ
	public static void querrySeason(int season_id){
		List<Season> seasonList = seasonDao.querrySeason(season_id);
		
		if (seasonList.isEmpty()) {
			System.out.println("���޳��Σ�");
		}
		
		boolean success = seasonService.querrySeason(season_id);
		
		if (success) {
			for(Season season : seasonList){
				System.out.println("���α�ţ�" + season.getSeason_id() + 
					"\nӰԺ���ƣ�" + season.getCinema().getCinema_name() +
					"\nӰ�����ƣ�" + season.getHall().getHall_name() +
					"\n��Ӱ���ƣ�" + season.getMovie().getMovie_name() +
					"\n��Ӱʱ����" + season.getMovie().getMovie_length() +
					"\n֧���۸�" + season.getSeason_price() + 
					"\n��ӳʱ�䣺" + season.getSeason_time() + 
					"\n��ӳ��ַ��" + season.getCinema().getCinema_address() + 
					"\n"
				);
			}
		} else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		seasonList.clear();
	}

	
	//test
	public static void main(String[] args) throws Exception {
		//��ѯ���г���
		//querySeason();
		
		//��ӳ���
		addSeason();
		
		//ɾ������
		//deleteSeason();
		
		//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
		//querySeason(2, 5);
		
		//���ݳ���id��ѯ��ϸ��Ϣ
		//querrySeason(1);
	}
}
