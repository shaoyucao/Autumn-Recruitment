package com.syc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.service.AccountService;

public class TestApp {
	@Test
	public void demo01(){
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		AccountService accountService = (AccountService) applicationContext.getBean("proxyAccountService");
		accountService.transfer("jack", "rose", 1000);
	}

}
