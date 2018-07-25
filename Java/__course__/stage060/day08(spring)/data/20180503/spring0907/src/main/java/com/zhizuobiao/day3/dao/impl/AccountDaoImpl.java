package com.zhizuobiao.day3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zhizuobiao.day3.dao.AccountDao;
import com.zhizuobiao.day3.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate template;

	public int insertAccount(Account account) {
		// jdbc -> connection
		// mybatis -> dao接口绑定
		// springTemplate ->

		String sql = "insert into account(name,amount) values(?,?)";

		int code = template.update(sql, new Object[] { account.getName(), account.getAmount() });

		return code;
	}

	public int inMoney(String name, double amount) {
		String sql = "update account set amount=amount+? where name= ?";
		int code = template.update(sql, new Object[] { amount, name });
		return code;
	}

	public int outMoney(String name, double amount) {
		String sql = "update account set amount=amount-? where name= ?";
		int code = template.update(sql, new Object[] { amount, name });
		return code;
	}
}