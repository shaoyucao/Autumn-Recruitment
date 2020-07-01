package com.syc.service.impl;

import com.syc.dao.AccountDao;
import com.syc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
//		int i= 1/0;
		accountDao.in(inner, money);
		
	}

}
