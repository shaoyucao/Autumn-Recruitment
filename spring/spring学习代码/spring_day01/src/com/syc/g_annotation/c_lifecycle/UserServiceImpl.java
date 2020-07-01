package com.syc.g_annotation.c_lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userServiceId")
@Scope("prototype")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("g_annotation.c_lifecycle add user");
	}
		
	@PostConstruct
	public void myInit() {
		System.out.println("³õÊ¼»¯");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Ïú»Ù");
	}

}
