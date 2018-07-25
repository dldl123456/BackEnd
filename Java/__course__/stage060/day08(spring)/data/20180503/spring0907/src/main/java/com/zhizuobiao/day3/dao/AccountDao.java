package com.zhizuobiao.day3.dao;

import com.zhizuobiao.day3.entity.Account;

public interface AccountDao {

	int insertAccount(Account account);

	// 存钱
	int inMoney(String name, double amount);

	// 取钱
	int outMoney(String name, double amount);
}
