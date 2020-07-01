package com.syc.d_aspect.a_xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * �����࣬�ж������
 * @author SYC
 *
 */
public class MyAspect{
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ:"+joinPoint.getSignature().getName());
	}
	
	//����֪ͨ���Ի�÷����ķ���ֵ
	public void myAfterReturning(JoinPoint joinPoint, Object ret){
		System.out.println("����֪ͨ--->" + ret);
	}
	
	//����֪ͨ
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("ǰ����");
		//�ֶ�ִ��Ŀ�귽��
		Object obj = joinPoint.proceed();
		System.out.println("�󷽷�");
		return obj;
		
	}
	//�׳��쳣֪ͨ
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
		System.out.println("�׳��쳣"+e.getMessage());
	}
	//����֪ͨ
	public void myAfter(JoinPoint joinPoint){
		System.out.println("����֪ͨ");
	}
	
}
