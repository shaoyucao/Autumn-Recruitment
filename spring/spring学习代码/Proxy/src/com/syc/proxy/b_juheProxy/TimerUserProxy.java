package com.syc.proxy.b_juheProxy;

public class TimerUserProxy implements UserDao {
	
	//��ȡ�ӿ�
	private UserDao userDao;
	public TimerUserProxy(UserDao userDao){
		this.userDao = userDao;
	}
	public void query(String name){
		System.out.println("timer log ...");
		userDao.query(name);
		
	}

}
