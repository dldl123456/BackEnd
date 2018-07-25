package entity;
/**
 * 城市实体类
 * @author Administrator
 *
 */
public class City {
	private int cityId;
	private String cityName;
	public City() {
		super();
	}
	public City(String cityName) {
		super();
		this.cityName = cityName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
}
