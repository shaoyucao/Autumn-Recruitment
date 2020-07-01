package com.syc.proxy.a_jichengProxy;

public class LogUserProxy extends UserDaoImpl {
	//使用继承方式的静态代理
	public void query(String name){
		System.out.println("log proxy ...");
		super.query(name);
	}

}
