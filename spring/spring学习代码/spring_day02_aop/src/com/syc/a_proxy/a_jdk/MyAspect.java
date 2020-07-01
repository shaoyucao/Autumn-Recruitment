package com.syc.a_proxy.a_jdk;

public class MyAspect {
	public void before(){
		System.out.println("开启事务");
		
	}
	
	public void after(){
		System.out.println("提交事务");
	}

}
