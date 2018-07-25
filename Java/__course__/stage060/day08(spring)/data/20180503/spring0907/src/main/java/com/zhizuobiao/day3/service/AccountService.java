package com.zhizuobiao.day3.service;

public interface AccountService {

	/**
	 * 转账
	 * @param fromName 从xx账号
	 * @param toName 到xx账号
	 * @param amount 转账金额
	 * @return
	 */
	boolean transferAccount(String fromName, String toName, double amount);
}
