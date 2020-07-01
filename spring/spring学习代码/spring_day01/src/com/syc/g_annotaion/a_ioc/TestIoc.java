package com.syc.g_annotaion.a_ioc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {	
	@Test
	public void demo02(){
		//´ÓSpringÈÝÆ÷»ñµÃ
		String xmlPath = "com/syc/g_annotaion/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}

}