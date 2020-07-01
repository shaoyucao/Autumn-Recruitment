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
		
		//Ҫ��1.Ҫִ�����ٷ�������������رգ�2.�����ǵ�����
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();//�˷�����ApplicationContext�ӿ���û�ж��壬ʵ�������ṩ
	}
}