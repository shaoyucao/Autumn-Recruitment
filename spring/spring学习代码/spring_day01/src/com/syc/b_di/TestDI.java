package com.syc.b_di;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestDI {

	@Test
	public void demo01(){
		//��Spring�������
		//1.�������
		String xmlPath = "com/syc/b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.������ݣ�����Ҫ�Լ�new��ֱ�Ӵ������л��
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}
	
	@Test
	public void demo02(){
		//ʹ��BeanFactory����һ�ε���getBeanʱ�ű�ʵ����
		//1.�������
		String xmlPath = "com/syc/b_di/beans.xml";		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		//2.������ݣ�����Ҫ�Լ�new��ֱ�Ӵ������л��
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		bookService.addBook();
	}

}