package bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestCollections {
	private Integer id;
	
	private String array[];  //数组
	private List<String> listValues;  //list集合
	private Set<String> setValues;  //set集合
	private Map<String, String> mapValues;  //map集合(键值对)
	private Properties propValues;  //属性文件整合
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String[] getArray() {
		return array;
	}
	
	public void setArray(String[] array) {
		this.array = array;
	}
	
	public List<String> getListValues() {
		return listValues;
	}
	
	public void setListValues(List<String> listValues) {
		this.listValues = listValues;
	}
	
	public Set<String> getSetValues() {
		return setValues;
	}
	
	public void setSetValues(Set<String> setValues) {
		this.setValues = setValues;
	}
	
	public Map<String, String> getMapValues() {
		return mapValues;
	}
	
	public void setMapValues(Map<String, String> mapValues) {
		this.mapValues = mapValues;
	}
	
	public Properties getPropValues() {
		return propValues;
	}
	
	public void setPropValues(Properties propValues) {
		this.propValues = propValues;
	}

	@Override
	public String toString() {
		return "TestCollections [id=" + id + ", array=" + Arrays.toString(array) + ", listValues=" + listValues
				+ ", setValues=" + setValues + ", mapValues=" + mapValues + ", propValues=" + propValues + "]";
	}
	
}
