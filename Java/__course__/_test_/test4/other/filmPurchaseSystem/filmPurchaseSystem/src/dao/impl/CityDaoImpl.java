package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CityDao;
import dbutil.DbADUClose;
import entity.City;

public class CityDaoImpl extends DbADUClose implements CityDao {
	/**
	 * ��ӳ�����Ϣ������
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addCity(City city) throws Exception {
		String sql="insert into City values (default,?)";
		Object[] params = {city.getCityName()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * ɾ��������Ϣ��ɾ��
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteCity(City city) throws Exception {
		String sql="delete from city where city_id=?";
		Object[] params = {city.getCityId()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * �޸ĳ�����Ϣ
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateCity(City city) throws Exception {
		String sql="update city set city_name=? where city_id=?";
		Object[] params= {city.getCityName(),city.getCityId()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * ��ѯ����������Ϣ
	 * @param cityId
	 * @return
	 * @throws Exception
	 */
	@Override
	public City queryCityByName(String cityName) throws Exception {
		try {
			String sql="select * from city where city_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cityName);
			rs=ps.executeQuery();
			if(rs.next()) {
				City city=new City();
				city.setCityId(rs.getInt(1));
				city.setCityName(rs.getString(2));
				return city;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public City queryCityById(int cityId) throws Exception {
		try {
			String sql="select * from city where city_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cityId);
			rs=ps.executeQuery();
			if(rs.next()) {
				City city=new City();
				city.setCityId(rs.getInt(1));
				city.setCityName(rs.getString(2));
				return city;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * ��ѯ���г�����Ϣ
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<City> queryCitys() throws Exception {
		try {
			List<City> citys = new ArrayList<City>();
			String sql ="select * from city order by city_id";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				City city=new City();
				city.setCityId(rs.getInt(1));
				city.setCityName(rs.getString(2));
				citys.add(city);
			}
			return citys;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * �ж�������б���Ƿ����
	 */
	@Override
	public int comparisonCityId(int inputCityId) throws Exception {
		int Num = -1;//����һ���������մ�������ID
		for(int i=0;i<queryCitys().size();i++) {
			if(inputCityId==queryCitys().get(i).getCityId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	/**
	 * �ж�������������Ƿ����
	 */
	@Override
	public int comparisonCityName(String inputCityName) throws Exception {
		int Num = -1;//����һ���������մ�������ID
		for(int i=0;i<queryCitys().size();i++) {
			if(inputCityName.equals(queryCitys().get(i).getCityName())) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
