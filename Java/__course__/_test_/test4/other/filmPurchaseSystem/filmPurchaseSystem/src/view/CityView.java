package view;

import java.util.List;
import java.util.Scanner;

import dao.CityDao;
import dao.impl.CityDaoImpl;
import entity.City;
public class CityView {
	static Scanner input = new Scanner(System.in);
	static City city = new City();
	static CityDao cityDao = new CityDaoImpl();
	
	public static void CityAddPage() throws Exception {
		System.out.println("������Ҫ��ӵĳ������ƣ�");
		String cityName = input.next();
		city = new City(cityName);
		cityDao.addCity(city);
		System.out.println("������ӳɹ�������");
		System.out.println("��Ϊ����ת����һ���б�");
		AdminView.adminOperateCityPage();
	}
	
	public static void CitySeeAllPage() {
		try {
			List<City> citys;
			citys = cityDao.queryCitys();
			System.out.println("���������г�����Ϣ��");
			for(City city :citys) {
				System.out.println(CityToString(city));
			}
			System.out.println("��Ϊ����ת����һ���б�");
			AdminView.adminOperateCityPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static String CityToString(City city) {
		return city.getCityId()+"\t"+city.getCityName();
	}
}
