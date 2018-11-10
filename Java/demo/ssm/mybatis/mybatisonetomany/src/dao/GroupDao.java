package dao;

import po.Group;

public interface GroupDao {
	//根据组id查找用户信息
	public Group getGroupById(int gid);
	
	
}
