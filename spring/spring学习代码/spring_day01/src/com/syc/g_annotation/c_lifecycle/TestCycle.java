package com.syc.g_annotation.c_lifecycle;


import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
	
	@Test
	public void demo01() throws Exception{
		String xmlPath = "com/syc/g_annotation/c_lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService1 = (UserService) applicationContext.getBean("userServiceId");
		UserService userService2 = (UserService) applicationContext.getBean("userServiceId");
		userService1.addUser();
		userService2.addUser();
		System.out.println(userService1);
		System.out.println(userService2);
		
		//要求：1.要执行销毁方法，容器必须关闭；2.必须是单例的
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();//此方法在ApplicationContext接口中没有定义，实现类中提供
	}
}