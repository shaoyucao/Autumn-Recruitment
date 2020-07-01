package com.syc.d_aspect.b_anno;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 切面类，有多个方法
 */
@Component
@Aspect
public class MyAspect{
	//切入点当前有效
	//@Before("execution(* com.syc.d_aspect.b_anno.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知:"+joinPoint.getSignature().getName());
	}
	
	//声明公共切入点
	@Pointcut("execution(* com.syc.d_aspect.b_anno.UserServiceImpl.*(..))")
	private void myPointCut(){
		
	}
	//后置通知可以获得方法的返回值
	//@AfterReturning(value="myPointCut()", returning="ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret){
		System.out.println("后置通知--->" + ret);
	}
	
	//环绕通知
	//@Around(value="myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("前方法");
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		System.out.println("后方法");
		return obj;
	}
	//抛出异常通知
	//@AfterThrowing(value="myPointCut()", throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
		System.out.println("抛出异常"+e.getMessage());
	}
	//最终通知
	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知");
	}
	
}
