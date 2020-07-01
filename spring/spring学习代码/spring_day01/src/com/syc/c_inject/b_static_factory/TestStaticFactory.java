package com.syc.c_inject.b_static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	//��ǰ�ķ���
	@Test
	public void demo01() {
		MyBeanFactory.createService().addUser();
	}
	
	//ʹ��spring�ľ�̬����
	@Test
	public void demo02(){
		String path = "com/syc/c_inject/b_static_factory/beans.xml";
		ApplicationContext application = new ClassPathXmlApplicationContext(path);
		//������ݣ�ʹ�ù���������ÿ�ζ�ǿ��ת�����������ͼ���
		UserService userService = application.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
}
