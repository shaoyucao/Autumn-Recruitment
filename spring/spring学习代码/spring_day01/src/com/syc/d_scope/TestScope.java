package com.syc.d_scope;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	
	@Test
	public void demo01(){
		String xmlPath = "com/syc/d_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

		UserService userService1 = applicationContext.getBean("userServiceId", UserService.class);
		UserService userService2 =  applicationContext.getBean("userServiceId", UserService.class);
		System.out.println(userService1);
		System.out.println(userService2);
	}
}