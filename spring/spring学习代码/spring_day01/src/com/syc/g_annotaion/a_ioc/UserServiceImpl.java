package com.syc.g_annotaion.a_ioc;

import org.springframework.stereotype.Component;

@Component("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("g_annotaion.a_ioc add user");

	}	

}
