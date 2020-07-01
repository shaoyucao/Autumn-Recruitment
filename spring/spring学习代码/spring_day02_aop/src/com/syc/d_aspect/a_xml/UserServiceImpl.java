package com.syc.d_aspect.a_xml;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_aspect.a_xml addUser");		
	}

	@Override
	public String updateUser() {
		System.out.println("d_aspect.a_xml updateUser");
		//int i = 1/0;
		return "hello aop aspectj afterReturning";
	}

	@Override
	public void deleteUser() {
		System.out.println("d_aspect.a_xml deleteUser");
	}

}
