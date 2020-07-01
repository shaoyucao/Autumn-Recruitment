package com.syc.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	//以前的方法
	@Test
	public void demo01() {
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		myBeanFactory.createService().addUser();
	}
	
	//使用spring的实例工厂
	@Test
	public void demo02(){
		String xmlPath = "com/syc/c_inject/c_factory/beans.xml";
		ApplicationContext application = new ClassPathXmlApplicationContext(xmlPath);
		//获得内容，使用工厂，不用每次都强制转换，加上类型即可
		UserService userService = application.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
}
