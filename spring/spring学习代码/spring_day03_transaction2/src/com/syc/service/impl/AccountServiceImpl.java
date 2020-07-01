package com.syc.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.syc.dao.AccountDao;
import com.syc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	//需要spring注入事务模板
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(final String outer, final String inner, final Integer money) {
		//execute方法需要一个没有返回结果的回调函数
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					accountDao.out(outer, money);
//					int i = 1/0;
					accountDao.in(inner, money);
			}
		});
		
	}

}
