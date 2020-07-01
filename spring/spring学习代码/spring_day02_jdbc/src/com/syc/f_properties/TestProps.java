package com.syc.f_properties;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.a_domain.User;

public class TestProps {
	@Test
	public void demo01(){
		String xmlPath = "com/syc/f_properties/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		List<User> list = userDao.getRequired(2);
		for(User user:list){
			System.out.println(user);
		}
		User user = userDao.getById(1);
		System.out.println(user);
	}

}
