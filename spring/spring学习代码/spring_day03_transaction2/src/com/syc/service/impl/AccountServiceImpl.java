package com.syc.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.syc.dao.AccountDao;
import com.syc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	//��Ҫspringע������ģ��
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
		//execute������Ҫһ��û�з��ؽ���Ļص�����
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
