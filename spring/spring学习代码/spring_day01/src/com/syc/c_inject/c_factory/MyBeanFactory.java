package com.syc.c_inject.c_factory;


/*
 * ʵ�����������з����Ǿ�̬
 * */
public class MyBeanFactory {	
	public UserService createService(){
		return new UserServiceImpl();
	}

}
