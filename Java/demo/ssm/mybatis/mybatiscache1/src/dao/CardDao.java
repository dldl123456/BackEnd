package dao;

import po.CardNo;

public interface CardDao {
	//根据用户id查身份证
	public CardNo getPersonById(int pid);
}
