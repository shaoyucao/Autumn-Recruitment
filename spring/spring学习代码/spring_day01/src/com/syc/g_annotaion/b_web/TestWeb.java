package com.syc.g_annotaion.b_web;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWeb {	
	@Test
	public void demo02(){
		//´ÓSpringÈÝÆ÷»ñµÃ
		String xmlPath = "com/syc/g_annotaion/b_web/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentAction = (StudentAction) applicationContext.getBean("studentActionId");
		studentAction.execute();
		
	}
}