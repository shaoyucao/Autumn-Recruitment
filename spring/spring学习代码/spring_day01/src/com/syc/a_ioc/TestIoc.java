package com.syc.a_ioc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	/*@Test
	public void demo01(){
		//之前new方法
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}*/
	
	@Test
	public void demo02(){
		//从Spring容器获得
		//1.获得容器
		String xmlPath = "com/syc/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容，不需要自己new，直接从容器中获得
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}

}