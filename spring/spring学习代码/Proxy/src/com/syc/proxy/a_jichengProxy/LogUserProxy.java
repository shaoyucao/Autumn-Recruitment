package com.syc.proxy.a_jichengProxy;

public class LogUserProxy extends UserDaoImpl {
	//ʹ�ü̳з�ʽ�ľ�̬����
	public void query(String name){
		System.out.println("log proxy ...");
		super.query(name);
	}

}
