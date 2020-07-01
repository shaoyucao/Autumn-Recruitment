package com.syc.c_dbcp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.a_domain.User;

public class TestDBCP {
	@Test
	public void demo01(){
		User user = new User();
		user.setId(1);
		user.setUsername("½Ü¿Ë");
		user.setPassword("999");
		String xmlPath = "com/syc/c_dbcp/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		userDao.update(user);
	}

}
