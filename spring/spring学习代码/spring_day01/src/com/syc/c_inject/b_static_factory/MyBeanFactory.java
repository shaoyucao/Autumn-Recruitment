package com.syc.c_inject.b_static_factory;

public class MyBeanFactory {
	
	//静态工厂中所有的方法必须是静态的
	public static UserService createService(){
		return new UserServiceImpl();
	}

}
