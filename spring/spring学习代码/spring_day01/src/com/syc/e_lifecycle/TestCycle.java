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
		
		//要求：1.要执行销毁方法，容器必须关闭；2.必须是单例的
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();//此方法在ApplicationContext接口中没有定义，实现类中提供
	}
}