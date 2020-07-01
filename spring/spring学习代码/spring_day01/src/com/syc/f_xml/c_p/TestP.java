package com.syc.f_xml.c_p;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestP {

	@Test
	public void demo01(){
		String xmlPath = "com/syc/f_xml/c_p/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		Person person = (Person) applicationContext.getBean("personId");
		System.out.println(person);
	}	

}