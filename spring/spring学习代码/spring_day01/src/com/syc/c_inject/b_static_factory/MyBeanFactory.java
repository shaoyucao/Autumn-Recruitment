package com.syc.c_inject.b_static_factory;

public class MyBeanFactory {
	
	//��̬���������еķ��������Ǿ�̬��
	public static UserService createService(){
		return new UserServiceImpl();
	}

}
