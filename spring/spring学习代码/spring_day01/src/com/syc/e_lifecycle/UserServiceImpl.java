package com.syc.e_lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("e_lifecycle add user");
	}
	
	

	public void myInit() {
		System.out.println("��ʼ��");
	}
	
	public void myDestroy() {
		System.out.println("����");
	}

}
