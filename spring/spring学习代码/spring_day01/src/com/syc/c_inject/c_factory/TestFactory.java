package com.syc.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	//��ǰ�ķ���
	@Test
	public void demo01() {
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		myBeanFactory.createService().addUser();
	}
	
	//ʹ��spring��ʵ������
	@Test
	public void demo02(){
		String xmlPath = "com/syc/c_inject/c_factory/beans.xml";
		ApplicationContext application = new ClassPathXmlApplicationContext(xmlPath);
		//������ݣ�ʹ�ù���������ÿ�ζ�ǿ��ת�����������ͼ���
		UserService userService = application.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
}
