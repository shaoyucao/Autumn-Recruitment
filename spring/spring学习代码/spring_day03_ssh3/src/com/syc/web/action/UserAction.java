package com.syc.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.syc.domain.User;
import com.syc.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	//2 service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * зЂВс
	 * @return
	 */
	public String register(){
		userService.register(user);
		return "success";
	}


}
