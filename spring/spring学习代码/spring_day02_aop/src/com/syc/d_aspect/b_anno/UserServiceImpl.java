package com.syc.d_aspect.b_anno;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_aspect.b_anno addUser");		
	}

	@Override
	public String updateUser() {
		System.out.println("d_aspect.b_anno updateUser");
		//int i = 1/0;
		return "hello aop aspectj afterReturning";
	}

	@Override
	public void deleteUser() {
		System.out.println("d_aspect.b_anno deleteUser");
	}

}
