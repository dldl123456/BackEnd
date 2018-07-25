package com.zhizuobiao.day3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.zhizuobiao.day3.dao.AccountDao;
import com.zhizuobiao.day3.service.AccountService;

@Service("accountServiceImplTemplate")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private TransactionTemplate transactionTemplate;

	public boolean transferAccount(final String fromName, final String toName, final double amount) {

		try {

			transactionTemplate.execute(new TransactionCallback<Boolean>() {

				public Boolean doInTransaction(TransactionStatus arg0) {

					// -钱
					accountDao.outMoney(fromName, amount);

					// 模拟出错
					String test = null;
					test.toCharArray();

					// +钱
					accountDao.inMoney(toName, amount);

					return true;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("报错了！！！");
			return false;
		}

		return true;
	}

}
