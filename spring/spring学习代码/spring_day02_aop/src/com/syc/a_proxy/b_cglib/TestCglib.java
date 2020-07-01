package com.syc.a_proxy.b_cglib;

import org.junit.Test;

public class TestCglib {
	@Test
	public void demo(){
		UserServiceImpl userServiceImpl = MyBeanFactory.createService();
		userServiceImpl.addUser();
		userServiceImpl.updateUser();
		userServiceImpl.deleteUser();
	}

}
