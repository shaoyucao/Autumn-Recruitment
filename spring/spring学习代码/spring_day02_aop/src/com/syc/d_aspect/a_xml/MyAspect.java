package com.syc.d_aspect.a_xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 切面类，有多个方法
 * @author SYC
 *
 */
public class MyAspect{
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知:"+joinPoint.getSignature().getName());
	}
	
	//后置通知可以获得方法的返回值
	public void myAfterReturning(JoinPoint joinPoint, Object ret){
		System.out.println("后置通知--->" + ret);
	}
	
	//环绕通知
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("前方法");
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		System.out.println("后方法");
		return obj;
		
	}
	//抛出异常通知
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
		System.out.println("抛出异常"+e.getMessage());
	}
	//最终通知
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知");
	}
	
}
