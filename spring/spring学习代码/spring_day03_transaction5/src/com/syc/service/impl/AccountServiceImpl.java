package com.syc.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.dao.AccountDao;
import com.syc.service.AccountService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
//		int i = 1/0;
		accountDao.in(inner, money);
		
	}

}
