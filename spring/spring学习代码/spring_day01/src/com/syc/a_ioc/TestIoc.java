package com.syc.a_ioc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	/*@Test
	public void demo01(){
		//֮ǰnew����
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}*/
	
	@Test
	public void demo02(){
		//��Spring�������
		//1.�������
		String xmlPath = "com/syc/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.������ݣ�����Ҫ�Լ�new��ֱ�Ӵ������л��
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
	}

}