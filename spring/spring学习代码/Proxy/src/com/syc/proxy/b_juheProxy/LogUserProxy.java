package com.syc.proxy.b_juheProxy;

public class LogUserProxy implements UserDao {
	
	//��ȡ�ӿ�
	private UserDao userDao;
	public LogUserProxy(UserDao userDao){
		this.userDao = userDao;
	}
	public void query(String name){
		System.out.println("log proxy2 ...");
		userDao.query(name);
		
	}

}
