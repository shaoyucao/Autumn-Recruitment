package com.syc.e_lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("e_lifecycle add user");
	}
	
	

	public void myInit() {
		System.out.println("³õÊ¼»¯");
	}
	
	public void myDestroy() {
		System.out.println("Ïú»Ù");
	}

}
