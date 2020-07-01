package com.syc.d_c3p0;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.a_domain.User;

public class TestC3P0 {
	@Test
	public void demo01(){
		String xmlPath = "com/syc/d_c3p0/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		List<User> list = userDao.queryAll();
		for(User user:list){
			System.out.println(user);
		}
	}

}
