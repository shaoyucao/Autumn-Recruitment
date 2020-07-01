package com.syc.e_lifecycle;


import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
	
	@Test
	public void demo01() throws Exception{
		String xmlPath = "com/syc/e_lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		
		//Ҫ��1.Ҫִ�����ٷ�������������رգ�2.�����ǵ�����
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();//�˷�����ApplicationContext�ӿ���û�ж��壬ʵ�������ṩ
	}
}