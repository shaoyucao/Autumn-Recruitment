package com.syc.proxy.b_juheProxy;

public class TimerUserProxy implements UserDao {
	
	//获取接口
	private UserDao userDao;
	public TimerUserProxy(UserDao userDao){
		this.userDao = userDao;
	}
	public void query(String name){
		System.out.println("timer log ...");
		userDao.query(name);
		
	}

}
