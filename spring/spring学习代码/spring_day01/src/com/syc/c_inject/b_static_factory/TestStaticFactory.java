package com.syc.c_inject.b_static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	//以前的方法
	@Test
	public void demo01() {
		MyBeanFactory.createService().addUser();
	}
	
	//使用spring的静态工厂
	@Test
	public void demo02(){
		String path = "com/syc/c_inject/b_static_factory/beans.xml";
		ApplicationContext application = new ClassPathXmlApplicationContext(path);
		//获得内容，使用工厂，不用每次都强制转换，加上类型即可
		UserService userService = application.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
}
