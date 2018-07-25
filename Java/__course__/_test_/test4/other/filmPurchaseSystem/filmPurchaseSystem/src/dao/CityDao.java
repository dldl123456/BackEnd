package dao;

import java.util.List;

import entity.City;
/**
 * 操作城市数据库接口
 * @author Administrator
 *
 */
public interface CityDao {
	/**
	 * 添加城市信息（增）
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int addCity(City city) throws Exception;
	/**
	 * 删除城市信息（删）
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int deleteCity(City city) throws Exception;
	/**
	 * 修改城市信息
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public int updateCity(City city) throws Exception;
	/**
	 * 根据城市名查询单个城市信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public City queryCityByName(String cityName) throws Exception;
	/**
	 * 根据城市id查询单个城市信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public City queryCityById(int cityId) throws Exception;
	/**
	 * 查询所有城市信息
	 * @return
	 * @throws Exception
	 */
	public List<City> queryCitys() throws Exception;
	
	public int comparisonCityId(int inputCityId) throws Exception;
	
	public int comparisonCityName(String inputCityName) throws Exception;
}
