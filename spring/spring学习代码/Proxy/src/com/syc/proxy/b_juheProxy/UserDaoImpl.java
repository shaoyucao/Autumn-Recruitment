package com.syc.proxy.b_juheProxy;

public class UserDaoImpl implements UserDao{
	public void query(String name){
		System.out.println("Query name: " + name);
	}

}
