package com.syc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syc.domain.User;
import com.syc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void demo01(){
		User user = new User();
		user.setUsername("Tom");
		user.setPassword("123");
		user.setAge(25);
		
		userService.register(user);
	}
}

