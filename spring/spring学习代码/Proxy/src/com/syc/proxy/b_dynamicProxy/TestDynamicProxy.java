package com.syc.proxy.b_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理模式
public class TestDynamicProxy {
	public static void main(String[] args) {
		//1.创建目标对象
		final Subject subject = new SubjectImpl();
		
		//2.创建代理处理器对象
		ProxyHandler proxyHandler = new ProxyHandler(subject);
		
		//3.动态生成代理对象
		Subject proxySubject = (Subject) Proxy.newProxyInstance(
				subject.getClass().getClassLoader(), //类加载器
				subject.getClass().getInterfaces(), //具体的接口
				proxyHandler);	//代理对象需要代理处理器对象，代理处理器重写了invoke方法	

		//4.客户端通过代理对象调用方法，本次调用将自动地被代理处理器的invoke方法接收
		proxySubject.request();
		
		System.out.println(proxySubject.getClass().getName());
	}

}
