package com.syc.proxy.b_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 代理处理器，实现了InvocationHandler接口
 * */
public class ProxyHandler implements InvocationHandler {
	//持有目标对象的句柄
	private Subject subject;
	
	public ProxyHandler(Subject subject){
		this.subject = subject;
	}

	/*
	 * invoke()方法
	 * 此方法在代理对象调用任何一个方法时都会被调用
	 * 
	 * 第一个参数：proxy 代理对象
	 * 第二个参数：method 反射里面的Method类，查看具体调用哪个方法
	 * 第三个参数：args 具体的形参
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//输出代理类的名字
		System.out.println(proxy.getClass().getName());//代理对象所属的类是虚拟机自动生成的
		
		//定义预处理工作，当然也可以根据method的不同进行不同的预处理工作
		System.out.println("=========before========");
		//调用真实的目标对象来进行工作
		Object result = method.invoke(subject, args);
		System.out.println("=========before========");
		return result;//返回结果
	}

}
