package dao;

import java.util.List;

import entity.City;
/**
 * �����������ݿ�ӿ�
 * @author Administrator
 *
 */
public interface CityDao {
	/**
	 * ��ӳ�����Ϣ������
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int addCity(City city) throws Exception;
	/**
	 * ɾ��������Ϣ��ɾ��
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int deleteCity(City city) throws Exception;
	/**
	 * �޸ĳ�����Ϣ
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int updateCity(City city) throws Exception;
	/**
	 * ���ݳ�������ѯ����������Ϣ
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public City queryCityByName(String cityName) throws Exception;
	/**
	 * ���ݳ���id��ѯ����������Ϣ
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public City queryCityById(int cityId) throws Exception;
	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<City> queryCitys() throws Exception;
	
	public int comparisonCityId(int inputCityId) throws Exception;
	
	public int comparisonCityName(String inputCityName) throws Exception;
}
