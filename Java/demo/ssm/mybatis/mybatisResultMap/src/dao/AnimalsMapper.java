package dao;

import po.Animals;

public interface AnimalsMapper {
	//根据id查询动物
	public Animals getAnimalsById(Integer id);
}
