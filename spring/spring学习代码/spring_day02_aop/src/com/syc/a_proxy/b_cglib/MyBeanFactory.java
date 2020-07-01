package com.syc.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createService(){
		//1.目标类
		final UserServiceImpl userServiceImpl = new UserServiceImpl();
		//2.切面类
		final MyAspect myAspect = new MyAspect();
		//3.代理类 ，采用cglib，底层创建目标类的子类
		
		//3.1核心类
		Enhancer enhancer = new Enhancer();
		//3.2确定父类
		enhancer.setSuperclass(userServiceImpl.getClass());
		/* 3.3 设置回调函数 , 
		 * setCallback需要传入一个Callback接口，MethodInterceptor为其子接口，能对方法进行增强
		 * MethodInterceptor接口 等效 jdk InvocationHandler接口
		 * 	intercept() 等效 jdk  invoke()
		 * 		参数1、参数2、参数3：以invoke一样
		 * 		参数4：methodProxy 方法的代理
		 */
		
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				
				myAspect.before();
				method.invoke(userServiceImpl, args);
				// * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
				methodProxy.invokeSuper(proxy, args);
				myAspect.after();
				return null;
			}
		});
		
		//3.4创建代理
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		return proxyService;
	}
}
