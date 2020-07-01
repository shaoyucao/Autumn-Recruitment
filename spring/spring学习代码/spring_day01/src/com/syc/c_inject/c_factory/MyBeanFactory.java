package com.syc.c_inject.c_factory;


/*
 * 实例工厂，所有方法非静态
 * */
public class MyBeanFactory {	
	public UserService createService(){
		return new UserServiceImpl();
	}

}
