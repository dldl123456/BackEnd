package com.zhizuobiao.day3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhizuobiao.day3.dao.AccountDao;
import com.zhizuobiao.day3.service.AccountService;

@Service("accountServiceImplAnno")
public class AccountServiceImpl3 implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public boolean transferAccount(final String fromName, final String toName, final double amount) {

		// -钱
		accountDao.outMoney(fromName, amount);

		// 模拟出错
		String test = null;
		test.toCharArray();

		// +钱
		accountDao.inMoney(toName, amount);

		return true;
	}

}
