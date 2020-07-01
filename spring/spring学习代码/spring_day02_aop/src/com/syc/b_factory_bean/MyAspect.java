package com.syc.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/*
 * 因为要用spring的aop，所以要用规范。切面类中确定通知，需要实现不同的接口，接口就是规范，用于确定不同的方法
 * 采用环绕通知（环绕通知必须手动地执行目标方法）
 */
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {		
		System.out.println("前方法");
		//手动执行目标方法
		Object obj = mi.proceed();
		System.out.println("后方法");
		return obj;
	}

}
