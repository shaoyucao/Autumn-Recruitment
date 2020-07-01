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
		//从Spring容器获得
		//1.获得容器
		String xmlPath = "com/syc/b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容，不需要自己new，直接从容器中获得
		BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}
	
	@Test
	public void demo02(){
		//使用BeanFactory，第一次调用getBean时才被实例化
		//1.获得容器
		String xmlPath = "com/syc/b_di/beans.xml";		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		//2.获得内容，不需要自己new，直接从容器中获得
		BookService bookService = (BookService) beanFactory.getBean("bookServiceId");
		bookService.addBook();
	}

}